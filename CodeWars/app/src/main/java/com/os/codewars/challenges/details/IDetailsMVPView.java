package com.os.codewars.challenges.details;

import com.os.codewars.data_model.network.model.ChallengeDetails;
import com.os.codewars.ui.base.MvpView;



public interface IDetailsMVPView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(ChallengeDetails challengeDetails);
    void onFetchDataError(String error);
}
