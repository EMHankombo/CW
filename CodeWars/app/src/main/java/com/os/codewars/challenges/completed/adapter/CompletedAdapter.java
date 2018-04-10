package com.os.codewars.challenges.completed.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.os.codewars.data_model.network.model.Completed;
import com.os.codewars.utils.IOnItemClickListener;
import com.os.codewars.ChallengesActivity;
import com.os.codewars.MyApp;
import com.os.codewarsapp.R;



public class CompletedAdapter extends RecyclerView.Adapter<CompletedAdapter.MyViewHolder> {
    private Completed completed;
    private int row_challenges;
    private FragmentActivity activity;

    public CompletedAdapter(Completed completed, int row_challenges, FragmentActivity activity) {
        this.completed = completed;
        this.row_challenges = row_challenges;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row_challenges,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvChallengeName.setText(completed.getData().get(position).getName());

        holder.callItemClick(new IOnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                MyApp.setChallengeID(completed.getData().get(position).getId());
                // load the fragment with the details.
                ChallengesActivity.loadChallengeDetails();
            }
        });
    }

    @Override
    public int getItemCount() {
        return completed.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvChallengeName;
        private IOnItemClickListener clickListener;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvChallengeName = (TextView) itemView.findViewById(R.id.tvChallengeName);

            itemView.setOnClickListener(this);

        }

        private void callItemClick (IOnItemClickListener clickListener){
            this.clickListener = clickListener;
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getPosition());
        }
    }
}
