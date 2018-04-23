package com.example.android.middleofnowhere;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.android.middleofnowhere.Adapter.CreditsAdapter;
import com.example.android.middleofnowhere.Adapter.SimpleFragmentPageAdapter;
import com.example.android.middleofnowhere.CustomClass.Credits;
import com.example.android.middleofnowhere.CustomClass.Places;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;

public class MainActivity extends AppCompatActivity {

    //ALL HAIL SAINT BUTTERKNIFE!
    //Later findViewById!
    //ButterKnife - http://jakewharton.github.io/butterknife/
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.slidingTabs)
    TabLayout tabLayout;
    @BindView(R.id.iconCredits)
    ImageView iconCredits;
    @BindView(R.id.credits)
    LinearLayout creditsMenu;
    @BindView(R.id.creditsList)
    ListView resourcesUsed;

    //global variable that holds the resources used
    private final ArrayList<Credits> creditsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //ViewPager and Tab Layout adapters
        SimpleFragmentPageAdapter adapter = new SimpleFragmentPageAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //call to method that add icons to the tab layout tabs
        setupIcons();

        //call to method that add the objects with the info of the resources used to the array list
        setupCredits();

        //adapter of the credits' list view
        CreditsAdapter creditsAdapter = new CreditsAdapter(this, creditsArrayList);
        resourcesUsed.setAdapter(creditsAdapter);

        //click listener of the credits
        //it hides and show a menu with them with clicks on the icon of the app
        iconCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (creditsMenu.getVisibility() == View.VISIBLE) {
                    creditsMenu.setVisibility(View.GONE);
                } else {
                    creditsMenu.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    //method to display icons in the tab layout
    private void setupIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_monument_grey_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_museum_grey_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_pastry_grey_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_restaurant_grey_24dp);
    }

    //method that adds the credits objects to the array list
    private void setupCredits() {
        creditsArrayList.add(new Credits(getString(R.string.creditName0), getString(R.string.creditURL0)));
        creditsArrayList.add(new Credits(getString(R.string.creditName1), getString(R.string.creditURL1)));
        creditsArrayList.add(new Credits(getString(R.string.creditName2), getString(R.string.creditURL2)));
        creditsArrayList.add(new Credits(getString(R.string.creditName3), getString(R.string.creditURL3)));
        creditsArrayList.add(new Credits(getString(R.string.creditName4), getString(R.string.creditURL4)));
        creditsArrayList.add(new Credits(getString(R.string.creditName5), getString(R.string.creditURL5)));
        creditsArrayList.add(new Credits(getString(R.string.creditName6), getString(R.string.creditURL6)));
        creditsArrayList.add(new Credits(getString(R.string.creditName7), getString(R.string.creditURL7)));
        creditsArrayList.add(new Credits(getString(R.string.creditName8), getString(R.string.creditURL8)));
        creditsArrayList.add(new Credits(getString(R.string.creditName9), getString(R.string.creditURL9)));
        creditsArrayList.add(new Credits(getString(R.string.creditName10), getString(R.string.creditURL10)));
        creditsArrayList.add(new Credits(getString(R.string.creditName11), getString(R.string.creditURL11)));
        creditsArrayList.add(new Credits(getString(R.string.creditName12), getString(R.string.creditURL12)));
        creditsArrayList.add(new Credits(getString(R.string.creditName13), getString(R.string.creditURL13)));
        creditsArrayList.add(new Credits(getString(R.string.creditName14), getString(R.string.creditURL14)));
        creditsArrayList.add(new Credits(getString(R.string.creditName15), getString(R.string.creditURL15)));
        creditsArrayList.add(new Credits(getString(R.string.creditName16), getString(R.string.creditURL16)));
    }
}
