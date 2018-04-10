package com.os.codewars.challenges.completed;

import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.ui.base.MvpView;



public interface ICompletedMVPVIew extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccessCompleted(Completed completed);
    void onFetchDataError(String error);
}
