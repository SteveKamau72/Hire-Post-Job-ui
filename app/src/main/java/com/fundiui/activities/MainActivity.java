package com.fundiui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.fundiui.R;
import com.fundiui.listeners.OnSelectedItemChangeListener;
import com.fundiui.utils.BottomNavigation;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        BottomNavigation bottomNavigation = (BottomNavigation) findViewById(R.id.bottom_navigation);
        bottomNavigation.setDefaultItem(0);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId) {
                    case R.id.tab_home:
                        setUpFragments(new HomeFragment());
                        break;
                    case R.id.tab_services:
                        setUpFragments(new ServicesFragment());
                        break;
                    case R.id.tab_profile:
                        setUpFragments(new ProfileFragment());
                        break;
                    case R.id.tab_settings:
                        setUpFragments(new SettingsFragment());
                        break;
                }

            }
        });
    }

    private void setUpFragments(Fragment fragment) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_fragment_containers, fragment);
        transaction.commit();
    }
}
