package com.os.codewars.data_model;

import com.os.codewars.data_model.network.APIHelper;
import com.os.codewars.data_model.network.IAPIHelper;
import com.os.codewars.data_model.network.model.Authored;
import com.os.codewars.data_model.network.model.ChallengeDetails;
import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.data_model.network.model.User;

import io.reactivex.Observable;



public class DataManager implements IDataManager {
    private IAPIHelper iapiHelper;

    public DataManager() {
        this.iapiHelper = new APIHelper();
    }

    @Override
    public Observable<User> searchUsername(String username) {
        return iapiHelper.searchUsername(username);
    }

    @Override
    public Observable<Completed> searchCompleted(String username) {
        return iapiHelper.searchCompleted(username);
    }

    @Override
    public Observable<Authored> searchAuthored(String username) {
        return iapiHelper.searchAuthored(username);
    }

    @Override
    public Observable<ChallengeDetails> searchChallengeDetails(String challengeID) {
        return iapiHelper.searchChallengeDetails(challengeID);
    }
}
