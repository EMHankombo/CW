package com.os.codewars;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.os.codewars.challenges.authored.AuthoredFragment;
import com.os.codewars.challenges.completed.CompletedFragment;
import com.os.codewars.challenges.details.DetailsFragment;
import com.os.codewarsapp.R;

public class ChallengesActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_completed:
                    loadCompleted();
                    return true;
                case R.id.navigation_authored:
                    loadAuthored();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        // fragmentManager initialised
        fragmentManager = getSupportFragmentManager();

        // Completed as Default loading fragment on the challenges activity
        if (savedInstanceState == null) {
            // load the completed fragment
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentChallenges, new CompletedFragment())
                    .addToBackStack(null)
                    .commit();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public static void loadCompleted(){
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentChallenges, new CompletedFragment())
                .addToBackStack(null)
                .commit();
    }

    public static void loadAuthored(){
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentChallenges, new AuthoredFragment())
                .addToBackStack(null)
                .commit();
    }

    public static void loadChallengeDetails(){
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentChallenges, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }
}
