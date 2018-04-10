package com.os.codewars.data_model.network.service;

import com.os.codewars.data_model.network.model.Authored;
import com.os.codewars.data_model.network.model.ChallengeDetails;
import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.data_model.network.model.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;


public interface IRequestInterface {

    // Search User
    @Headers("Authorization: b6PAAZ_mXXes4zEKf7Xi")
    @GET(APIConstants.SEARCH_USER)
    Observable<User> searchUsername(@Path("username") String username);

    // Search Completed
    @Headers("Authorization: b6PAAZ_mXXes4zEKf7Xi")
    @GET(APIConstants.CHALLENGES_COMPLETED)
    Observable<Completed> searchCompleted(@Path("username") String username);

    // Search Authored
    @Headers("Authorization: b6PAAZ_mXXes4zEKf7Xi")
    @GET(APIConstants.CHALLENGES_AUTHORED)
    Observable<Authored> searchAuthored(@Path("username") String username);

    // Challenge Details
    @Headers("Authorization: b6PAAZ_mXXes4zEKf7Xi")
    @GET(APIConstants.CHALLENGES_DETAILS)
    Observable<ChallengeDetails> searchChallengeDetails(@Path("challengeID") String challengeID);


}
