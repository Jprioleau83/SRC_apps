package com.cnsintegration.srcmarineinfo1;

/**
 * Created by jprioleau on 4/9/2014.
 */

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor2;
import com.cnsintegration.srcmarineinfo1.model.MOS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */

public class MOSFrag extends Fragment {

    View v;
    ExpandableListAdapter mAdapter;
    List<String> _listDataHeader;
    HashMap<String, List<MOS>> _listDataChild;

    ExpandableListView lv;
    Context con;

    OnMosSelectedListener mCallback;





    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    List<HashMap<String, String>> branchesDataCollection;



    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;




    public String[] MOS_TABLE_COLUMNS = { DataBaseWrapper.MOS_ID, DataBaseWrapper.MOS_NUMBER, DataBaseWrapper.MOS_NAME, DataBaseWrapper.MOS_TYPE, DataBaseWrapper.MOS_RANK, DataBaseWrapper.MOS_TITLE};




    public interface OnMosSelectedListener {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        public void onRankSelected(int position);
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
        }




    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnMosSelectedListener) activity;
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
            updateMOSView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateMOSView(mCurrentPosition);
        }



       /** else{
            String[] listItems = {};

            setListAdapter(new ArrayAdapter(getActivity(),
                    android.R.layout.simple_list_item_1, listItems));
        }**/


    }




    public List getMOSES(int mostitleid) {
        List moses = new ArrayList();
        String tempposition = Integer.toString(mostitleid);


        Cursor cursor = database.query(DataBaseWrapper.MOS, MOS_TABLE_COLUMNS, "most_id=" + tempposition, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MOS mos = parseStudent(cursor);
            moses.add(mos);
            cursor.moveToNext();
        }

        cursor.close();
        return moses;
    }

    private MOS parseStudent(Cursor cursor) {



       //DataBaseWrapper.MOS_NUMBER, DataBaseWrapper.MOS_TITLE, DataBaseWrapper.MOS_NAME,DataBaseWrapper.MOS_TYPE,DataBaseWrapper.MOS_RANK};




        MOS mos = new MOS();
        mos.setMOS_ID(cursor.getInt(0));
        mos.setMOS_NUMBER(cursor.getString(1));
        mos.setMOS_TITLE(cursor.getInt(5));
        mos.setMOS_NAME(cursor.getString(2));
        mos.setMOS_TYPE(cursor.getString(3));
        mos.setMOS_RANK(cursor.getString(4));




        return mos;
    }

    public void updateMOSView(int position) {
        Activity act = getActivity();

        dbHelper = new DataBaseWrapper(act);

        database = dbHelper.getWritableDatabase();

        List values = getMOSES(position);



        _listDataHeader = new ArrayList<String>();

        _listDataChild = new HashMap<String, List<MOS>>();

        for (int h = 0; h <  values.size(); h++) {
            MOS mos = (MOS) values.get(h);
            if (_listDataHeader.contains(mos.getMOS_TYPE())) {
                System.out.println("Account found");
            } else {
                // Map<String, String> map1 = new HashMap<String, String>();
                //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                //groupData.add(map1);
                _listDataHeader.add(mos.getMOS_TYPE());
            }

        }


        for (int i = 0; i < _listDataHeader.size(); i++) {
            // get all the ranks for type and add it to an list then add the list to data array
            HashMap<String, String> top250 = new HashMap<String, String>();
            List<MOS> childGroupForFirstGroupRow;


            childGroupForFirstGroupRow = new ArrayList<MOS>();
            for (int k = 0; k < values.size(); k++) {

                MOS mos = (MOS) values.get(k);

                String ty = (String) mos.getMOS_TYPE();
                String t1 = (String) _listDataHeader.get(i);

                if (ty.equals(t1)) {
                    //add it to list


                    HashMap<String, String> map1 = null;

                    map1 = new HashMap<String, String>();
                    map1.put("Name", mos.getMOS_NAME());
                    map1.put("Number", mos.getMOS_NUMBER());
                    map1.put("Ranks", mos.getMOS_RANK());


                    childGroupForFirstGroupRow.add(mos);


                }
            }
            if(childGroupForFirstGroupRow!=null && !childGroupForFirstGroupRow.isEmpty()){

                _listDataChild.put(_listDataHeader.get(i), childGroupForFirstGroupRow);
            }

        }

        ExpandableListView lv = (ExpandableListView) v.findViewById(R.id.expandable_list);


        con=getActivity();


        mAdapter=new ExpandabelListAdoptor2(con,_listDataHeader, _listDataChild) ; //here i didnt set list values to this adoptor

        lv.setAdapter(mAdapter);





    }









}
