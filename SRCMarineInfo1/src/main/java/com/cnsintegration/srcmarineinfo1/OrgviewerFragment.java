package com.cnsintegration.srcmarineinfo1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsintegration.srcmarineinfo1.adapter.ViewPagerAdapter;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by jprioleau on 4/27/2014.
 */
public class OrgviewerFragment extends Fragment {


    private ViewPagerAdapter mPagerAdapter;
    public FragmentManager fm;

    public OrgviewerFragment(FragmentManager frm) {

        fm = frm;


    }

    public OrgviewerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main2, container, false);
        // Locate the ViewPager in viewpager_main.xml
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.pager);

        // Set the ViewPagerAdapter into ViewPager     mViewPager.setAdapter(new RankAdapter(getChildFragmentManager(),Ranks ));
        this.mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

       /* for (Rank rank : Ranks) {

            int tid = (int) rank.getId();
            final RankFrag rt = new RankFrag(rank);

            mPagerAdapter.addTab(rt, rank.getName());

        }*/

        final OrgFragment og1 = new OrgFragment(R.drawable.spawarorgcht);
        mPagerAdapter.addTab(og1, "Spawar Org chart");

        final OrgFragment og2 = new OrgFragment(R.drawable.spawarorgchart_exec);
        mPagerAdapter.addTab(og2, "SRC Exec Management Org Chart");


       final OrgFragment og3 = new OrgFragment(R.drawable.spawarorgchart_iss);
        mPagerAdapter.addTab(og3, "SRC ISS Division Org Chart");

        final OrgFragment og4 = new OrgFragment(R.drawable.spawarorgchart_sti);
        mPagerAdapter.addTab(og4, "SRC STI Division Org Chart");

        final OrgFragment og5 = new OrgFragment(R.drawable.spawarorgchart_cne);
        mPagerAdapter.addTab(og5, "SRC CNE Division Org Chart");

        final OrgFragment og6 = new OrgFragment(R.drawable.spawarorgchart_cne);
        mPagerAdapter.addTab(og6, "SRC Corporate Services Org Chart");

        final OrgFragment og7 = new OrgFragment(R.drawable.spawarorgchart_acc);
        mPagerAdapter.addTab(og7, "SRC Corporate Services Org Chart");

        final OrgFragment og8 = new OrgFragment(R.drawable.spawarorgchart_hr);
        mPagerAdapter.addTab(og8, "SRC HR Org Chart");

        final OrgFragment og9 = new OrgFragment(R.drawable.spawarorgchart_sec);
        mPagerAdapter.addTab(og9, "SRC Security  Org Chart");

        final OrgFragment og10 = new OrgFragment(R.drawable.spawarorgchart_it);
        mPagerAdapter.addTab(og10, "SRC IT  Org Chart");

        final OrgFragment og11 = new OrgFragment(R.drawable.spawarorgchart_fac);
        mPagerAdapter.addTab(og11, "SRC Facilities  Org Chart");

        final OrgFragment og12 = new OrgFragment(R.drawable.spawarorgchart_prosol);
        mPagerAdapter.addTab(og12, "SRC ProSolutions  Org Chart");

        final OrgFragment og13 = new OrgFragment(R.drawable.spawarorgchart_contracts);
        mPagerAdapter.addTab(og13, "SRC Contracts  Org Chart");

        final OrgFragment og14 = new OrgFragment(R.drawable.spawarorgchart_legal);
        mPagerAdapter.addTab(og14, "SRC Contracts  Org Chart");

        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setAdapter(this.mPagerAdapter);


        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
     /*   try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
           // fm.popBackStack();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }*/
    }
}
