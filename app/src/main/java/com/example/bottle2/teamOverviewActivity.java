package com.example.bottle2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class teamOverviewActivity extends AppCompatActivity {

    int teamID;
    String teamName;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_overview);

        ActionBar actionBar = getSupportActionBar();

        teamID = getIntent().getExtras().getInt("teamID");
        teamName = getIntent().getExtras().getString("teamName");

        Toast.makeText(this, "Selected: " + Integer.toString(teamID) + ":" + teamName, Toast.LENGTH_SHORT).show();

        tabLayout = findViewById(R.id.teamOverview_tab_layout);
        viewPager = findViewById(R.id.teamOverview_viewPager);

        viewPager.setAdapter(new teamOverview_viewpager_adapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
