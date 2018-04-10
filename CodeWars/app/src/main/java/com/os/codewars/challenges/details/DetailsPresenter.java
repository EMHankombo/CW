package com.os.codewars.challenges.details;

import com.os.codewars.data_model.network.model.ChallengeDetails;
import com.os.codewars.ui.base.BasePresenter;
import com.os.codewars.data_model.DataManager;
import com.os.codewars.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;



public class DetailsPresenter<V extends IDetailsMVPView>
        extends BasePresenter<V>
        implements IDetailsMVPPresenter<V> {

    public DetailsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadChallengeDetails(String challengeID) {
        getMvpView().onFetchDataProgress();
        getCompositeDisposable().add(
            getDataManager().searchChallengeDetails(challengeID)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ChallengeDetails>() {
                    @Override
                    public void accept(ChallengeDetails challengeDetails) throws Exception {
                        // success
                        getMvpView().onFetchDataSuccess(challengeDetails);
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
