package com.cnsintegration.srcmarineinfo1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import com.cnsintegration.srcmarineinfo1.HomeFragment;
import com.cnsintegration.srcmarineinfo1.MOSFrag;
import com.cnsintegration.srcmarineinfo1.RankFrag;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.List;

/**
 * Created by jprioleau on 4/26/2014.
 */
public class RankAdapter extends FragmentPagerAdapter {
    public FragmentManager fragmanager;
    public List<Rank> Ranks;

    public RankAdapter(FragmentManager fm, List ranks) {
        super(fm);
        fragmanager = fm;
        Ranks = ranks;


    }

    @Override
    public int getCount() {
        return Ranks.size();
    }

    @Override
    public Fragment getItem(int position) {


        Rank rank = Ranks.get(position);

       switch (position) {

            default:

                int tid = (int) rank.getId();
                // final RankFrag rt = new RankFrag(tid);
                final RankFrag rt = new RankFrag(rank);
                return rt;
                //return new rt

        }


    }



    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        Rank rank = Ranks.get(position);


        return rank.getName();
    }

}
