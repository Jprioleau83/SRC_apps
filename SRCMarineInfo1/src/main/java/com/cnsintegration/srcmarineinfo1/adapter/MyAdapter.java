package com.cnsintegration.srcmarineinfo1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cnsintegration.srcmarineinfo1.HomeFragment;
import com.cnsintegration.srcmarineinfo1.MOSFrag;
import com.cnsintegration.srcmarineinfo1.MOSFragment;
import com.cnsintegration.srcmarineinfo1.ServiceFragment;

/**
 * Created by jprioleau on 4/26/2014.
 */
public class MyAdapter extends FragmentPagerAdapter {
    public FragmentManager fragmanager;
    public MyAdapter(FragmentManager fm) {
        super(fm);
        fragmanager = fm;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:


                return  new MOSFrag();

            default:
                return null;
        }
    }
}