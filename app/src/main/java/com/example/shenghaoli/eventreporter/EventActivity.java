package com.example.shenghaoli.eventreporter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Shenghao Li on 4/10/2017.
 */

public class EventActivity extends AppCompatActivity {
    ReportEventFragment reportFragment;
    String username;
    TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        //get user name from MainActivity
        Intent intent = getIntent();
        username = intent.getStringExtra("Username");
        usernameTextView = (TextView) findViewById(R.id.text_user);
        usernameTextView.setText("Welcome, " + username);

        // Create ReportEventFragment
        if (reportFragment == null) {
            reportFragment = new ReportEventFragment();
        }

        // Add Fragment to the fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, reportFragment).commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        // Set Item click listener to the menu items
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_profile:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragment_container, reportFragment).commit();
                                break;
                            case R.id.action_events:

                        }
                        return false;
                    }
                });
    }


    // Username used by fragment
    public String getUsername() {
        return username;
    }
}
