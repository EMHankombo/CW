package com.os.codewars.search_user;

import com.os.codewars.data_model.network.model.User;
import com.os.codewars.ui.base.BasePresenter;
import com.os.codewars.ui.utils.rx.SchedulerProvider;
import com.os.codewars.data_model.DataManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;



public class SearchUserPresenter<V extends ISearchUserMVPView>
        extends BasePresenter<V>
        implements ISearchUserMVPPresenter<V> {

    public SearchUserPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadUser(String username) {
        getMvpView().onFetchDataProgress();
        getCompositeDisposable().add(
          getDataManager().searchUsername(username)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        // success
                        getMvpView().onFetchDataSuccess(user);
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
