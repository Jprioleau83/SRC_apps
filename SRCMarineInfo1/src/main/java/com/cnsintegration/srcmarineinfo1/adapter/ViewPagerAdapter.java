package com.cnsintegration.srcmarineinfo1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;

import java.util.ArrayList;

/**
 * Created by jprioleau on 4/30/2014.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<TabInfo> tabs;


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        tabs = new ArrayList<TabInfo>();
    }

    @Override
    public Fragment getItem(int i) {
        return tabs.get(i).fragment;


    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabs.get(position).title;
    }


    public class TabInfo {
        public Fragment fragment;
        String title;
    }

    public void addTab(Fragment _fragment, String _title) {
        final TabInfo _tabInfo = new TabInfo();
        _tabInfo.fragment = _fragment;
        _tabInfo.title = _title;
        tabs.add(_tabInfo);
    }

}