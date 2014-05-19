package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;
import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor3;
import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor4;
import com.cnsintegration.srcmarineinfo1.model.Ack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class AckFragment extends Fragment {



    public static final String Ackdb = "acronym";
    public static final String Ack = "ack";
    public static final String Ack_Name = "ackname";
    public static final String Ack_Details = "ackdetails";
    public static final String Ack_Link = "acklink";
    public static final String Ack_Icon = "ackicon";


    public static int mActiontype;
    int mCurrentPosition = -1;
    public Context mCtx;
    ListView list;
    BinderData adapter = null;
    List<HashMap<String,String>> branchesDataCollection;
    HashMap<String, com.cnsintegration.srcmarineinfo1.model.Ack> _listDataChild;
    View v;
    Context con;
    List<String> _Headers;

    ExpandableListAdapter mAdapter;

    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;

    public String[] Ack_TABLE_COLUMNS = { "id", DataBaseWrapper.Ack, DataBaseWrapper.Ack_Name, DataBaseWrapper.Ack_Details, DataBaseWrapper.Ack_Link, DataBaseWrapper.Ack_Icon };
    final static String ARG_POSITION = "position";






    public List getAllAck() {
        List acks = new ArrayList();

        Cursor cursor = database.query(DataBaseWrapper.Ackdb, Ack_TABLE_COLUMNS , null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ack ack = parseAck(cursor);
            acks.add(ack);
            cursor.moveToNext();
        }

        cursor.close();
        return acks;
    }

    private Ack parseAck(Cursor cursor) {




        Ack ack = new Ack();

        ack.setId(cursor.getInt(0));
        ack.setAck_name(cursor.getString(1));
        ack.setAck_details(cursor.getString(2));
        ack.setAck_link(cursor.getString(3));
        ack.setAck_icon(cursor.getString(4));




        return ack;
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
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.




        updateAckView();


    }


    public void updateAckView() {

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        //  BinderData bindingData = new BinderData(this,branchesDataCollection);

        Activity act = getActivity();
        // Create an array adapter for the list view, using the Ipsum headlines array
            dbHelper = new DataBaseWrapper(act);

            database = dbHelper.getReadableDatabase();



            List values = getAllAck();
            branchesDataCollection = new ArrayList<HashMap<String, String>>();
            HashMap<String,String> map = null;
            _Headers = new ArrayList<String>();
            _listDataChild = new HashMap<String, Ack>();

            for (int k = 0; k < values.size(); k++) {

                Ack ack = (Ack) values.get(k);
                map = new HashMap<String, String>();
                int id = ack.getId();

                map.put("id", Integer.toString(id));
                map.put(Ack, ack.getAck());
                map.put(Ack_Name, ack.getAck_name());
                map.put(Ack_Details, ack.getAck_details());
                map.put(Ack_Link, ack.getAck_link());
                map.put(Ack_Icon, ack.getAck_icon());

                branchesDataCollection.add(map);

                if (_Headers.contains(ack.getAck_name())) {
                    System.out.println("Account found");
                } else {
                    // Map<String, String> map1 = new HashMap<String, String>();
                    //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                    //groupData.add(map1);
                    _Headers.add(ack.getAck_name());
                    System.out.println("Account Added");
                }

                _listDataChild.put(ack.getAck_name(), ack);
            }


            ExpandableListView lv = (ExpandableListView) v.findViewById(R.id.expandable_list);


            con = getActivity();


            mAdapter = new ExpandabelListAdoptor4(con, _Headers, _listDataChild); //here i didnt set list values to this adoptor


            lv.setAdapter(mAdapter);
            dbHelper.close();




    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.



    }








}
