package com.os.codewars.challenges.authored;

import com.os.codewars.data_model.network.model.Authored;
import com.os.codewars.ui.base.BasePresenter;
import com.os.codewars.data_model.DataManager;
import com.os.codewars.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;



public class AuthoredPresenter<V extends IAuthoredMVPView>
        extends BasePresenter<V>
        implements IAuthoredMVPPresenter<V> {

    public AuthoredPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void loadAuthoredChallenges(String username) {
        getMvpView().onFetchDataProgress();
        getCompositeDisposable().add(
            getDataManager().searchAuthored(username)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Authored>() {
                    @Override
                    public void accept(Authored authored) throws Exception {
                        // success
                        getMvpView().onFetchDataSuccessAuthored(authored);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // error
                        getMvpView().onFetchDataError(throwable.getMessage());
                    }
                })
        );
    }
}
