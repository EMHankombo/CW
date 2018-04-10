package com.os.codewars.challenges.authored;

import com.os.codewars.data_model.network.model.Authored;
import com.os.codewars.ui.base.MvpView;



public interface IAuthoredMVPView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccessAuthored(Authored authored);
    void onFetchDataError(String error);
}
