package com.os.codewars.challenges.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.os.codewars.MyApp;
import com.os.codewars.data_model.network.model.ChallengeDetails;
import com.os.codewars.ui.base.BaseFragment;
import com.os.codewars.ui.utils.rx.AppSchedulerProvider;
import com.os.codewarsapp.R;
import com.os.codewars.data_model.DataManager;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
//public class DetailsFragment extends Fragment {
public class DetailsFragment
        extends BaseFragment
        implements IDetailsMVPView {

    IDetailsMVPPresenter<DetailsFragment> iDetailsMVPPresenter;

    String CHALLENGE_ID;

    @BindView(R.id.tvChallengeDetailsName)
    TextView tvChallengeDetailsName;

    @BindView(R.id.tvCreatedBy)
    TextView tvCreatedBy;

    @BindView(R.id.tvDescription)
    TextView tvDescription;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initiate iDetailsMVPPresenter
        iDetailsMVPPresenter = new DetailsPresenter<>(
                new DataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable()
        );

        iDetailsMVPPresenter.onAttach(this);

        CHALLENGE_ID = MyApp.getChallengeID();

        iDetailsMVPPresenter.loadChallengeDetails(CHALLENGE_ID);
    }

    @Override
    public void onFetchDataProgress() {
        showLoading();
    }

    @Override
    public void onFetchDataSuccess(ChallengeDetails challengeDetails) {
        displayDetails(challengeDetails);
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {
        Log.i(MyApp.LOG_TAG, error);
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
        if (error.equals("HTTP 500 ")){
            Toast.makeText(getActivity(), "Server error try again later", Toast.LENGTH_LONG).show();
        }
        hideLoading();
    }

    private void displayDetails(ChallengeDetails challengeDetails) {
        tvChallengeDetailsName.setText(challengeDetails.getName());

        tvCreatedBy.setText("Created by: " + challengeDetails.getCreatedBy().getUsername());

        tvDescription.setText("Description: \n" + challengeDetails.getDescription());
    }
}
