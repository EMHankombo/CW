package com.os.codewars.challenges.authored;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.os.codewars.MyApp;
import com.os.codewars.challenges.authored.adapter.AuthoredAdapter;
import com.os.codewars.data_model.network.model.Authored;
import com.os.codewars.ui.base.BaseFragment;
import com.os.codewars.ui.utils.rx.AppSchedulerProvider;
import com.os.codewarsapp.R;
import com.os.codewars.data_model.DataManager;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
//public class AuthoredFragment extends Fragment {
public class AuthoredFragment
        extends BaseFragment
        implements IAuthoredMVPView {

    IAuthoredMVPPresenter<AuthoredFragment> iAuthoredMVPPresenter;

    String USERNAME;

    @BindView(R.id.rvAuthoredChallenges)
    RecyclerView recyclerViewAuthoredChallenges;

    public AuthoredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authored, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initiate iAuthoredMVPPresenter
        iAuthoredMVPPresenter = new AuthoredPresenter<>(
                new DataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable()
        );

        iAuthoredMVPPresenter.onAttach(this);

        // initiate recyclerViewAuthoredChallenges
        recyclerViewAuthoredChallenges.setLayoutManager(new LinearLayoutManager(getActivity()));

        USERNAME = MyApp.getUsername();

        iAuthoredMVPPresenter.loadAuthoredChallenges(USERNAME);

    }

    @Override
    public void onFetchDataProgress() {
        showLoading();
    }

    @Override
    public void onFetchDataSuccessAuthored(Authored authored) {
        recyclerViewAuthoredChallenges.setAdapter(new AuthoredAdapter(authored, R.layout.row_challenges, getActivity()));
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {
        Log.i(MyApp.LOG_TAG, error);
//        Log.i(MyApp.LOG_TAG, error);
        hideLoading();
    }
}
