package com.example.android.middleofnowhere.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.middleofnowhere.Fragment.CategoryTwo;
import com.example.android.middleofnowhere.Fragment.CategoryZero;
import com.example.android.middleofnowhere.Fragment.CategoryOne;
import com.example.android.middleofnowhere.R;
import com.example.android.middleofnowhere.Fragment.CategoryThree;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    //global variable needed to make the Fragment Page Adapter work
    private final Context thisContext;

    //our "onCreate" method for the Fragment Page Adapter
    public SimpleFragmentPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        thisContext = context;
    }

    //method that overrides the getPageTitle method to populate it with the names of our tabs
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return thisContext.getString(R.string.place0);
            case 1:
                return thisContext.getString(R.string.place1);
            case 2:
                return thisContext.getString(R.string.place2);
            case 3:
                return thisContext.getString(R.string.place3);
            default:
                return null;
        }
    }

    //method that overrides the getItem method with the fragments that need to be loaded for each tab
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CategoryZero();
            case 1:
                return new CategoryOne();
            case 2:
                return new CategoryTwo();
            case 3:
                return new CategoryThree();
            default:
                return null;
        }
    }

    //method that overrides the getCount method with the exact number of tabs/fragments we're going
    //to use
    @Override
    public int getCount() {
        return 4;
    }
}
