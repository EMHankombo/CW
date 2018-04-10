package com.os.codewars;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.os.codewarsapp.R;
import com.os.codewars.search_user.SearchUserFragment;

public class MainActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, new SearchUserFragment())
                    .disallowAddToBackStack()
//                    .addToBackStack(null)
                    .commit();
        }

    }

    public void loadChallenges(){
        Intent intent = new Intent(this, ChallengesActivity.class);
        startActivity(intent);
    }
}
