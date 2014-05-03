package com.cnsintegration.srcmarineinfo1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cnsintegration.srcmarineinfo1.HomeFragment;
import com.cnsintegration.srcmarineinfo1.MOSFrag;
import com.cnsintegration.srcmarineinfo1.MOSFragment;
import com.cnsintegration.srcmarineinfo1.MOSHomeFragment;

/**
 * Created by jprioleau on 4/26/2014.
 */
public class MyAdapter2 extends FragmentPagerAdapter {

    public FragmentManager fragmanager;
    public MOSFrag passedfrag;
    public int branch = 0;

    public MyAdapter2(FragmentManager fm, MOSFrag pfrag, int serviceb) {
        super(fm);
        fragmanager = fm;
        passedfrag = pfrag;
        branch = serviceb;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (passedfrag.mCurrentPosition == 1) {
                    return new MOSHomeFragment();
                } else {
                    return new MOSHomeFragment();
                }
            case 1:


                return passedfrag;

            default:
                return null;
        }
    }


    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {


        if (position == 0) {
            return "MOS Overview ";
        } else {
            return "MOS Details List ";
        }

    }


}