package com.cnsintegration.srcmarineinfo1;

/**
 * Created by jprioleau on 4/9/2014.
 */

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor2;
import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor3;
import com.cnsintegration.srcmarineinfo1.adapter.MyAdapter;
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.MTitles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */

public class MOSFrag extends Fragment {

    View v;
    ExpandableListAdapter mAdapter;
    List<MTitles> _listDataHeader;
    HashMap<String, List<MOS>> _listDataChild;

    ExpandableListView lv;
    Context con;

    OnMosSelectedListener mCallback;


    final static String ARG_POSITION = "position";
    public int mCurrentPosition = -1;
    List<HashMap<String, String>> branchesDataCollection;


    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;


    public String[] MOS_TABLE_COLUMNS = {DataBaseWrapper.MOSTITLES_ID, DataBaseWrapper.MOSTITLES_TITLE, DataBaseWrapper.MOSTITLES_BRANCH};

    public String[] MOS_TABLE_COLUMNS2 = {DataBaseWrapper.MOS_ID, DataBaseWrapper.MOS_NUMBER, DataBaseWrapper.MOS_NAME, DataBaseWrapper.MOS_TYPE, DataBaseWrapper.MOS_RANK, DataBaseWrapper.MOS_TITLE, DataBaseWrapper.MOS_Link};


    public interface OnMosSelectedListener {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        // publigc void onRankSelected(int position);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.rank_lst,
                container, false);


        // return v;

        // ViewPager mViewPager = (ViewPager) v.findViewById(R.id.pager);
        // Set the ViewPagerAdapter into ViewPager
        //mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        super.onActivityCreated(savedInstanceState);

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        //  BinderData bindingData = new BinderData(this,branchesDataCollection);

        Activity act = getActivity();
        // Create an array adapter for the list view, using the Ipsum headlines array

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        /** try {
         mCallback = (OnMosSelectedListener) activity;
         } catch (ClassCastException e) {
         throw new ClassCastException(activity.toString()
         + " must implement OnHeadlineSelectedListener");
         }**/

    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateMOSView(args.getInt(ARG_POSITION), args.getString("Type"));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateMOSView(mCurrentPosition, args.getString("Type") );
        }


        /** else{
         String[] listItems = {};

         setListAdapter(new ArrayAdapter(getActivity(),
         android.R.layout.simple_list_item_1, listItems));
         }**/


    }


    public List getMOSES(int mostitleid, String mtype) {
        List moses = new ArrayList();
        String tempposition = Integer.toString(mostitleid);


        Cursor cursor = database.query(DataBaseWrapper.MOS, MOS_TABLE_COLUMNS2, "most_id=" + tempposition + " AND mos_type LIKE '" + mtype + "'" , null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MOS mos = parseStudent1(cursor);
            moses.add(mos);
            cursor.moveToNext();
        }

        cursor.close();
        return moses;
    }

    private MOS parseStudent1(Cursor cursor) {


        //DataBaseWrapper.MOS_NUMBER, DataBaseWrapper.MOS_TITLE, DataBaseWrapper.MOS_NAME,DataBaseWrapper.MOS_TYPE,DataBaseWrapper.MOS_RANK};


        MOS mos = new MOS();
        mos.setMOS_ID(cursor.getInt(0));
        mos.setMOS_NUMBER(cursor.getString(1));
        mos.setMOS_TITLE(cursor.getInt(5));
        mos.setMOS_NAME(cursor.getString(2));
        mos.setMOS_TYPE(cursor.getString(3));
        mos.setMOS_RANK(cursor.getString(4));
        mos.setMOS_LINK(cursor.getString(6));


        return mos;
    }


    public List getAllMOS(int branch) {
        List titles = new ArrayList();
        String tempposition = Integer.toString(branch);


        Cursor cursor = database.query(DataBaseWrapper.MOSTITLES, MOS_TABLE_COLUMNS, "mos_branch= " + tempposition, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MTitles mtitles = parseStudent(cursor);
            titles.add(mtitles);
            cursor.moveToNext();
        }

        cursor.close();
        return titles;
    }

    private MTitles parseStudent(Cursor cursor) {


        MTitles mtitle = new MTitles();
        mtitle.setMOS_TITLES_ID(cursor.getInt(0));
        mtitle.setMOS_TITLES_BRANCH(cursor.getInt(2));
        mtitle.setMOS_TITLES_TITLE(cursor.getString(1));


        return mtitle;
    }

    public void updateMOSView(int position, String mtype) {
        Activity act = getActivity();

        dbHelper = new DataBaseWrapper(act);

        database = dbHelper.getWritableDatabase();

        List values = getAllMOS(position);

        branchesDataCollection = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = null;
        _listDataHeader = new ArrayList<MTitles>();

        for (int k = 0; k < values.size(); k++) {
            MTitles mtitle = (MTitles) values.get(k);

            _listDataHeader.add(mtitle);


        }
        _listDataChild = new HashMap<String, List<MOS>>();


        for (int i = 0; i < _listDataHeader.size(); i++) {
            // get all the ranks for type and add it to an list then add the list to data array
            HashMap<String, String> top250 = new HashMap<String, String>();
            List<MOS> childGroupForFirstGroupRow;

            List values1 = getMOSES(_listDataHeader.get(i).getMOS_TITLES_ID(), mtype);


            childGroupForFirstGroupRow = new ArrayList<MOS>();

            if (values1.size() == 0) {

                _listDataHeader.remove(i);
                continue;
            }


            for (int k = 0; k < values1.size(); k++) {

                MOS mos = (MOS) values1.get(k);

                int ty = (int) mos.getMOS_TITLE();
                MTitles selectedtitle = _listDataHeader.get(i);
                int t1 = selectedtitle.getMOS_TITLES_ID();

                if (ty == t1) {
                    //add it to list


                    HashMap<String, String> map1 = null;

                    map1 = new HashMap<String, String>();
                    map1.put("Name", mos.getMOS_NAME());
                    map1.put("Number", mos.getMOS_NUMBER());
                    map1.put("Ranks", mos.getMOS_RANK());
                    map1.put("Link", mos.getMOS_LINK());


                    childGroupForFirstGroupRow.add(mos);


                }
            }
            if (childGroupForFirstGroupRow != null && !childGroupForFirstGroupRow.isEmpty()) {

                _listDataChild.put(_listDataHeader.get(i).getMOS_TITLES_TITLE(), childGroupForFirstGroupRow);
            }





        }
        //   v= inflater.inflate(R.layout.rank_lst, container, false);


        ExpandableListView lv = (ExpandableListView) v.findViewById(R.id.expandable_list);


        con = getActivity();


        mAdapter = new ExpandabelListAdoptor3(con, _listDataHeader, _listDataChild, position); //here i didnt set list values to this adoptor


        lv.setAdapter(mAdapter);
        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                final MOS mos = (MOS) mAdapter.getChild(groupPosition, childPosition);


                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mos.getMOS_LINK()));
                    startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "No application can handle this request,"
                            + " Please install a webbrowser", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                return false;
            }
        });


    }


}
