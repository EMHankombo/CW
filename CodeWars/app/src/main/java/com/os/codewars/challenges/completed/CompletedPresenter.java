package com.os.codewars.challenges.completed;

import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.ui.base.BasePresenter;
import com.os.codewars.data_model.DataManager;
import com.os.codewars.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;



public class CompletedPresenter<V extends ICompletedMVPVIew>
        extends BasePresenter<V>
        implements ICompletedMVPPresenter<V> {

    public CompletedPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void loadCompletedChallenges(String username) {
        getMvpView().onFetchDataProgress();
        getCompositeDisposable().add(
            getDataManager().searchCompleted(username)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Completed>() {
                    @Override
                    public void accept(Completed completed) throws Exception {
                        // success
                        getMvpView().onFetchDataSuccessCompleted(completed);
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
