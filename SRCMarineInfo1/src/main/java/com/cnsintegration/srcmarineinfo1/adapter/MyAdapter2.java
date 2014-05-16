package com.cnsintegration.srcmarineinfo1.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cnsintegration.srcmarineinfo1.AFSCHomeFragment;
import com.cnsintegration.srcmarineinfo1.ArmyHomeFragment;
import com.cnsintegration.srcmarineinfo1.CGHomeFragment;
import com.cnsintegration.srcmarineinfo1.HomeFragment;
import com.cnsintegration.srcmarineinfo1.MOSFrag;
import com.cnsintegration.srcmarineinfo1.MOSFragment;
import com.cnsintegration.srcmarineinfo1.MOSHomeFragment;
import com.cnsintegration.srcmarineinfo1.NavyHomeFragment;

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
                Bundle args = passedfrag.getArguments();
                int pos =  args.getInt("position");
                if (pos == 1) {


                    return new MOSHomeFragment();
                }else if(pos == 2){
                    return new AFSCHomeFragment();
                }else if(pos == 3){
                    return new ArmyHomeFragment();
                }else if(pos == 4){
                    return new NavyHomeFragment();
                }
                else if(pos == 5){
                    return new CGHomeFragment();
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