package com.example.day;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class EventsByClubs extends AppCompatActivity {


    private TabLayout tabLayout;
    //    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_by_clubs);

        tabLayout = findViewById(R.id.tablayoutid);
        viewPager = findViewById(R.id.viewpageid);

        toolbar= findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.AddFrragment(new club1(),"#include");
        adapter.AddFrragment(new club2(),"Codefoaster");
        adapter.AddFrragment(new club3(),"Ojaswa");
        adapter.AddFrragment(new club4(),"pratibimb");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
