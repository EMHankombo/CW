package com.os.codewars.data_model.network.service;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.os.codewars.MyApp;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ServiceConnection {

    static Retrofit retrofit;
    static OkHttpClient okHttpClient;
    private static final int CACHE_SIZE = 10*1024*1024;
    private static final int MAX_AGE = 60;
    private static final String HEADER_NAME = "Cache-Control";

    public static IRequestInterface getConnection() {

        Cache cache = new Cache(MyApp.getAppInstance().getAppContext().getCacheDir(), CACHE_SIZE);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(x ->{
                    Response response = x.proceed(x.request());

                    if (response.networkResponse()!=null) {
                        Log.i(MyApp.LOG_TAG, "cache: Network response");
                    }

                    if (response.cacheControl() != null) {
                        Log.i(MyApp.LOG_TAG, "cache: Cached response");
                    }

                    return response;
                })
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new getRewriteResponseInterceptor())
                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(IRequestInterface.class);
    }

    private static class getRewriteResponseInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            String cacheControl = originalResponse.header(HEADER_NAME);

            if (cacheControl == null
                    || cacheControl.contains("no-store")
                    || cacheControl.contains("no-cache")
                    || cacheControl.contains("must-revalidate")
                    || cacheControl.contains("max-age=0")) {

                Log.i("Values", "REWRITE_RESPONSE_CACHE");

                return originalResponse.newBuilder()
                        .header(HEADER_NAME, "public, max-age=" + MAX_AGE)
                        .build();
            }

            else {
                Log.i("Values", "REWRITE_RESPONSE_INTERCEPTOR");
                return originalResponse;
            }
        }
    }
}
