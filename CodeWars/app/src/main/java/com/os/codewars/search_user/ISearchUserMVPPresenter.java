package com.os.codewars.search_user;

import com.os.codewars.ui.base.MvpPresenter;



public interface ISearchUserMVPPresenter<V extends ISearchUserMVPView>
        extends MvpPresenter<V> {

    void loadUser(String username);
}
