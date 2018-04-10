package com.os.codewars.search_user;

import com.os.codewars.ui.base.MvpView;
import com.os.codewars.data_model.network.model.User;



public interface ISearchUserMVPView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(User user);
    void onFetchDataError(String error);
}
