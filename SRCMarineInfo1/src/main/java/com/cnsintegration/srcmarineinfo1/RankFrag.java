package com.cnsintegration.srcmarineinfo1;

/**
 * Created by jprioleau on 4/9/2014.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */

public class RankFrag extends Fragment {

    View v;
    ExpandableListAdapter mAdapter;
    List<String> _listDataHeader;
    HashMap<String, List<HashMap<String, String>>> _listDataChild;

    ExpandableListView lv;
    Context con;

    OnServicesSelectedListener mCallback;
    OnServicesSelectedListener1 mCallback1;



    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_TYPE = "type";
    static final String KEY_ICON = "icon";
    static final String KEY_DETAILS = "details";
    static final String KEY_LINKS = "link";

    public static final String Ranks = "Ranks";
    public static final String rank_ID = "_id";
    public static final String Rank_PAY = "_pay";
    public static final String Rank_SHORT = "_short";
    public static final String Rank_NAME = "_name";
    public static final String Rank_ICON = "_icon";
    public static final String Rank_TYPE = "_type";
    public static final String Rank_DETAILS = "_details";
    public static final String Rank_LINK = "_link";
    public static final String Rank_Branch = "_branch";

    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;

    public String[] Ranks_TABLE_COLUMNS = { DataBaseWrapper.rank_ID, DataBaseWrapper.Rank_PAY, DataBaseWrapper.Rank_SHORT, DataBaseWrapper.Rank_NAME,
            DataBaseWrapper.Rank_ICON, DataBaseWrapper.Rank_TYPE, DataBaseWrapper.Rank_DETAILS, DataBaseWrapper.Rank_LINK, DataBaseWrapper.Rank_Branch };







    final static String ARG_POSITION = "position";
    final static String ARG_POSITION1 = "type";
    int mCurrentPosition = -1;
    String mCurrentType = null;
    List<HashMap<String, String>> branchesDataCollection;


    public interface OnServicesSelectedListener {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        public void onRankSelected(int position);
    }


    public interface OnServicesSelectedListener1 {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        public void onRankCreated();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.rank_lst,
                container, false);


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
            mCurrentType = savedInstanceState.getString(ARG_POSITION1);
        }
        dbHelper = new DataBaseWrapper(act);




    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback1 = (OnServicesSelectedListener1) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
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
            updateRankView(args.getString(ARG_POSITION1),args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateRankView(mCurrentType,mCurrentPosition);
        }
        mCallback1.onRankCreated();



        /** else{
         String[] listItems = {};

         setListAdapter(new ArrayAdapter(getActivity(),
         android.R.layout.simple_list_item_1, listItems));
         }**/


    }




/**
    public List getAllRanks() {
        List ranks = new ArrayList();

        Cursor cursor = database.query(DataBaseWrapper.Ranks,
                Ranks_TABLE_COLUMNS , null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Rank rank = parseStudent(cursor);
            ranks.add(rank);
            cursor.moveToNext();
        }

        cursor.close();
        return ranks;
    }**/


    public List getAllRanks(String rtype, int position) {
        List ranks = new ArrayList();
        String tempposition = Integer.toString(position);
        Cursor cursor = database.query(DataBaseWrapper.Ranks, Ranks_TABLE_COLUMNS , "_branch=" + tempposition + " AND _type='" + rtype + "'", null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Rank rank = parseStudent(cursor);
            ranks.add(rank);
            cursor.moveToNext();
        }

        cursor.close();
        return ranks;
    }

    private Rank parseStudent(Cursor cursor) {




        Rank rank = new Rank();
        rank.setId((cursor.getInt(0)));
        rank.setRank_PAY(cursor.getString(1));
        rank.setShortName(cursor.getString(2));
        rank.setName(cursor.getString(3));
        rank.setIcon(cursor.getString(4));

        rank.setRank_TYPE(cursor.getString(5));
        rank.setRank_DETAILS(cursor.getString(6));
        rank.setRank_LINK(cursor.getString(7));
        rank.setRank_Branch(cursor.getInt(8));
        return rank;
    }







    public void updateRankView(String rtype, int position) {
        database = dbHelper.getWritableDatabase();

        List values = getAllRanks(rtype, position);


        _listDataHeader = new ArrayList<String>();

        _listDataChild = new HashMap<String, List<HashMap<String, String>>>();


        for (int i = 0; i < values.size(); i++) {
           Rank rank = (Rank) values.get(i);
            if (_listDataHeader.contains(rank.getRank_TYPE())) {
                System.out.println("Account found");
            } else {
                // Map<String, String> map1 = new HashMap<String, String>();
                //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                //groupData.add(map1);
                _listDataHeader.add(rank.getRank_TYPE());
                System.out.println("Account Added");
            }

        }
        _listDataChild = new HashMap<String, List<HashMap<String, String>>>();

        for (int i = 0; i < _listDataHeader.size(); i++) {
            // get all the ranks for type and add it to an list then add the list to data array
            HashMap<String, String> top250 = new HashMap<String, String>();
            List<HashMap<String, String>> childGroupForFirstGroupRow;


            childGroupForFirstGroupRow = new ArrayList<HashMap<String, String>>();
            for (int k = 0; k < values.size(); k++) {
                Rank rank = (Rank) values.get(k);

                String ty = (String) rank.getRank_TYPE();
                String t1 = (String) _listDataHeader.get(i);

                if (ty.equals(t1)) {
                    //add it to list
                    HashMap<String, String> map1 = null;

                    map1 = new HashMap<String, String>();
                    map1.put(KEY_NAME, rank.getName());
                    map1.put(KEY_PAY, rank.getRank_PAY());
                    map1.put(KEY_ICON, rank.getIcon());
                    map1.put(KEY_DETAILS,rank.getRank_DETAILS());
                    map1.put(KEY_LINKS, rank.getRank_LINK());

                    childGroupForFirstGroupRow.add(map1);



                }
            }


            if(childGroupForFirstGroupRow!=null && !childGroupForFirstGroupRow.isEmpty()){

                _listDataChild.put(_listDataHeader.get(i), childGroupForFirstGroupRow);
            }

        }



        ExpandableListView lv = (ExpandableListView) v.findViewById(R.id.expandable_list);

        //here setting all the values to Parent and child classes
        // setDataValues();
        //prepareListData();//here get the values and set this values to adoptor and set it visible
        con=getActivity();

        // mAdapter=new ExpandabelListAdoptor(con,_listDataHeader, _listDataChild) ; //here i didnt set list values to this adoptor
        mAdapter=new ExpandabelListAdoptor(con,_listDataHeader, _listDataChild) ; //here i didnt set list values to this adoptor



        // mAdapter = new ExpandableListAdapter(this, _listDataHeader, _listDataChild);

        // setting list adapter
        lv.setAdapter(mAdapter);

        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                final HashMap<String, String> branchDataCollection1 = (HashMap<String, String>) mAdapter.getChild(groupPosition, childPosition);

                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(branchDataCollection1.get(KEY_LINKS)));
                    startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "No application can handle this request,"
                            + " Please install a webbrowser", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                return false;
            }
        });

        dbHelper.close();
    //end updaterank method
    }









}
