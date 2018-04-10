package com.os.codewars.challenges.details;

import com.os.codewars.ui.base.MvpPresenter;



public interface IDetailsMVPPresenter<V extends IDetailsMVPView>
        extends MvpPresenter<V> {

    void loadChallengeDetails (String challengeID);
}
