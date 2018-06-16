package com.example.android.potsdamguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_event_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_place_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_account_balance_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_restaurant_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_hotel_white_24dp));

        tabLayout.setupWithViewPager(viewPager);
    }
}
