package com.os.codewars.challenges.completed;


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
import com.os.codewars.challenges.completed.adapter.CompletedAdapter;
import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.ui.base.BaseFragment;
import com.os.codewars.ui.utils.rx.AppSchedulerProvider;
import com.os.codewarsapp.R;
import com.os.codewars.data_model.DataManager;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
//public class CompletedFragment extends Fragment {
public class CompletedFragment
        extends BaseFragment
        implements ICompletedMVPVIew {

    ICompletedMVPPresenter<CompletedFragment> iCompletedMVPPresenter;

    String USERNAME;

    @BindView(R.id.rvCompletedChallenges)
    RecyclerView recyclerViewCompletedChallenges;

    public CompletedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initiate iCompletedMVPPresenter
        iCompletedMVPPresenter = new CompletedPresenter<>(
                new DataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable()
        );

        iCompletedMVPPresenter.onAttach(this);

        // initiate recyclerViewCompletedChallenges
        recyclerViewCompletedChallenges.setLayoutManager(new LinearLayoutManager(getActivity()));

//        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
//        USERNAME = sharedPreferences.getString("USERNAME","");
        USERNAME = MyApp.getUsername();

        iCompletedMVPPresenter.loadCompletedChallenges(USERNAME);

    }

    @Override
    public void onFetchDataProgress() {
        showLoading();
    }

    @Override
    public void onFetchDataSuccessCompleted(Completed completed) {
        recyclerViewCompletedChallenges.setAdapter(new CompletedAdapter(completed, R.layout.row_challenges, getActivity()));
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {
        Log.i(MyApp.LOG_TAG, error);
        hideLoading();
    }
}
