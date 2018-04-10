package com.os.codewars.search_user;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.os.codewars.MyApp;
import com.os.codewars.search_user.adapter.UserSearchAdapter;
import com.os.codewars.ui.base.BaseFragment;
import com.os.codewars.ui.utils.rx.AppSchedulerProvider;
import com.os.codewarsapp.R;
import com.os.codewars.data_model.DataManager;
import com.os.codewars.data_model.network.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;


/**
 * A simple {@link Fragment} subclass.
 */
//public class SearchUserFragment extends Fragment {
public class SearchUserFragment
        extends BaseFragment
        implements ISearchUserMVPView, SearchView.OnQueryTextListener {

    ISearchUserMVPPresenter<SearchUserFragment> iSearchUserMVPPresenter;

    @BindView(R.id.svUsername)
    SearchView searchViewUsername;
    @BindView(R.id.rvUsername)
    RecyclerView recyclerViewUsername;

    List<User> userList = new ArrayList<>();



    public SearchUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initiate iSearchUserMVPPresenter
        iSearchUserMVPPresenter = new SearchUserPresenter<>(
                new DataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable()
        );

        iSearchUserMVPPresenter.onAttach(this);

        // initiate the recyclerViewUsername
        recyclerViewUsername.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchViewUsername.setOnQueryTextListener(this);
//        Toast.makeText(getActivity(), "USERNAME", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFetchDataProgress() {
        showLoading();
    }

    @Override
    public void onFetchDataSuccess(User user) {
        Toast.makeText(getActivity(), "UserName Found", Toast.LENGTH_SHORT).show();
        if (userList.size() >= 5){
            userList.remove(4);
            userList.add(0,user);
        } else {
            userList.add(0,user);
        }

        if (userList.size() > 0){
            recyclerViewUsername.setAdapter(new UserSearchAdapter(userList, R.layout.row_search_user,getActivity()));
        }
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {
        Toast.makeText(getActivity(), "No data Found", Toast.LENGTH_SHORT).show();
        Log.i(MyApp.LOG_TAG, error);
        hideLoading();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
//        Toast.makeText(getActivity(), "SEARCH = " + query, Toast.LENGTH_SHORT).show();
        iSearchUserMVPPresenter.loadUser(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
