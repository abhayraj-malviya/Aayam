package com.example.day;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
//    private FrameLayout frameLayout;
    private MapFragment mapFragment;
    private HomeFragment homeFragment;
    private ScheduleFragment scheduleFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        frameLayout = findViewById(R.id.main_frame);
        bottomNavigationView = findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        mapFragment = new MapFragment();
        scheduleFragment = new ScheduleFragment();
        setFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case  R.id.nav_home:
                        bottomNavigationView.setBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_map:
                        bottomNavigationView.setBackgroundResource(R.color.green);
                        setFragment(mapFragment);
                        return true;
                    case R.id.nav_schedule:
                        bottomNavigationView.setBackgroundResource(R.color.deeppurple);
                        setFragment(scheduleFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
