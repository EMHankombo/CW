package com.os.codewars.challenges.completed;

import com.os.codewars.ui.base.MvpPresenter;


public interface ICompletedMVPPresenter<V extends ICompletedMVPVIew>
        extends MvpPresenter<V> {

    void loadCompletedChallenges (String username);
}
