package com.os.codewars.data_model.network;

import com.os.codewars.data_model.network.model.Authored;
import com.os.codewars.data_model.network.model.ChallengeDetails;
import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.data_model.network.model.User;
import com.os.codewars.data_model.network.service.IRequestInterface;
import com.os.codewars.data_model.network.service.ServiceConnection;

import io.reactivex.Observable;



public class APIHelper implements IAPIHelper{

    private IRequestInterface iRequestInterface;

    public APIHelper() {
        this.iRequestInterface = ServiceConnection.getConnection();
    }

    @Override
    public Observable<User> searchUsername(String username) {
        return iRequestInterface.searchUsername(username);
    }

    @Override
    public Observable<Completed> searchCompleted(String username) {
        return iRequestInterface.searchCompleted(username);
    }

    @Override
    public Observable<Authored> searchAuthored(String username) {
        return iRequestInterface.searchAuthored(username);
    }

    @Override
    public Observable<ChallengeDetails> searchChallengeDetails(String challengeID) {
        return iRequestInterface.searchChallengeDetails(challengeID);
    }
}
