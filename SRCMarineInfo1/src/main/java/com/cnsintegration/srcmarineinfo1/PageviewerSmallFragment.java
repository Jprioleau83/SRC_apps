package com.cnsintegration.srcmarineinfo1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsintegration.srcmarineinfo1.R;
import com.cnsintegration.srcmarineinfo1.adapter.MyAdapter;
import com.cnsintegration.srcmarineinfo1.adapter.MyAdapter2;

import java.lang.reflect.Field;

/**
 * Created by jprioleau on 4/27/2014.
 */
public class PageviewerSmallFragment extends Fragment {

    public MOSFrag passedfrag;
    public int Branch = 0;

    public PageviewerSmallFragment(MOSFrag mosFragment, int position) {
        passedfrag = mosFragment;
        Branch = position;
    }
    public PageviewerSmallFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main2, container, false);
        // Locate the ViewPager in viewpager_main.xml
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.pager);

        // Set the ViewPagerAdapter into ViewPager


        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setAdapter(new MyAdapter2(getChildFragmentManager(), passedfrag, Branch));

        return view;


    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
