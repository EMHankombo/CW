package com.os.codewars.challenges.authored;

import com.os.codewars.ui.base.MvpPresenter;



public interface IAuthoredMVPPresenter<V extends IAuthoredMVPView>
        extends MvpPresenter<V> {

    void loadAuthoredChallenges (String username);
}
