package com.cnsintegration.srcmarineinfo1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsintegration.srcmarineinfo1.adapter.MyAdapter;
import com.cnsintegration.srcmarineinfo1.adapter.RankAdapter;
import com.cnsintegration.srcmarineinfo1.adapter.ViewPagerAdapter;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by jprioleau on 4/27/2014.
 */
public class RankviewerFragment extends Fragment {

    List<Rank> Ranks;
    private ViewPagerAdapter mPagerAdapter;
    public FragmentManager fm;

    public RankviewerFragment(List tRanks, FragmentManager frm) {

        fm = frm;

        Ranks = tRanks;
    }

    public RankviewerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main2, container, false);
        // Locate the ViewPager in viewpager_main.xml
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.pager);

        // Set the ViewPagerAdapter into ViewPager     mViewPager.setAdapter(new RankAdapter(getChildFragmentManager(),Ranks ));
        this.mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        for (Rank rank : Ranks) {

            int tid = (int) rank.getId();
            final RankFrag rt = new RankFrag(rank);

            mPagerAdapter.addTab(rt, rank.getName());

        }
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setAdapter(this.mPagerAdapter);


        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
       /* try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
            fm.popBackStack();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }*/
    }
}
