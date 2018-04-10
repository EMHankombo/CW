package com.os.codewars.search_user.adapter;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.os.codewars.utils.IOnItemClickListener;
import com.os.codewars.MyApp;
import com.os.codewarsapp.R;
import com.os.codewars.ChallengesActivity;
import com.os.codewars.data_model.network.model.User;

import java.util.List;


public class UserSearchAdapter extends RecyclerView.Adapter<UserSearchAdapter.MyViewHolder> {
    private List<User> userList;
    private int row_search_user;
    private FragmentActivity activity;

    public UserSearchAdapter(List<User> userList, int row_search_user, FragmentActivity activity) {
        this.userList = userList;
        this.row_search_user = row_search_user;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row_search_user, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvUsername.setText(userList.get(position).getUsername());
        holder.tvUserRank.setText("Rank: " + userList.get(position).getLeaderboardPosition());

        holder.callItemClick(new IOnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
//                SharedPreferences.Editor editor = activity.getPreferences(Context.MODE_PRIVATE).edit();
//                editor.putString("USERNAME", userList.get(position).getUsername());
//                editor.putString("test","test Value");
//                editor.commit();
                MyApp.setUsername(userList.get(position).getUsername());
                Intent intent = new Intent(activity.getApplicationContext(), ChallengesActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvUsername;
        private TextView tvUserRank;

        private IOnItemClickListener clickListener;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            tvUserRank = (TextView) itemView.findViewById(R.id.tvUserRank);

            itemView.setOnClickListener(this);
        }

        private void callItemClick(IOnItemClickListener clickListener) {
            this.clickListener = clickListener;
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getPosition());
        }
    }
}
