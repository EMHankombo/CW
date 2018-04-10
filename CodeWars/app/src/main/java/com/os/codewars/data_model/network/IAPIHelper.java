package com.os.codewars.data_model.network;

import com.os.codewars.data_model.network.model.Authored;
import com.os.codewars.data_model.network.model.ChallengeDetails;
import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.data_model.network.model.User;

import io.reactivex.Observable;



public interface IAPIHelper {
    Observable<User> searchUsername(String username);
    Observable<Completed> searchCompleted(String username);
    Observable<Authored> searchAuthored(String username);
    Observable<ChallengeDetails> searchChallengeDetails(String challengeID);
}
