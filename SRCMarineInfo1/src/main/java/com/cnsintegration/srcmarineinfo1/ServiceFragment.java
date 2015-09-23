package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import android.content.Context;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;
import com.cnsintegration.srcmarineinfo1.model.Branch;
import com.cnsintegration.srcmarineinfo1.model.Rank;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class ServiceFragment extends ListFragment {

    OnServicesSelectedListener mCallback;
    OnServicesSelectedListener2 mCallback1;


    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_ICON = "icon";
    final static String ARG_POSITION = "position";
    public static int mActiontype;
    int mCurrentPosition = -1;
    public Context mCtx;
    ListView list;
    BinderData adapter = null;
    List<HashMap<String,String>> branchesDataCollection;



    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;

    public String[] BRANCH_TABLE_COLUMNS = { DataBaseWrapper.Branch_ID, DataBaseWrapper.Branch_NAME, DataBaseWrapper.Branch_ICON };



    public ServiceFragment(int i) {
        mActiontype = i;
    }

    public ServiceFragment() {

    }
    public interface OnServicesSelectedListener {
        /** Called by ServiceFragment when a list item is selected */


        void onServiceSelected(int position);



    }
    public interface OnServicesSelectedListener2 {
        /**
         * Called by ServiceFragment when a list item is selected
         */


        void onServiceSelected2(int position);


    }


    public List getAllBranches() {
        List branches = new ArrayList();

        Cursor cursor = database.query(DataBaseWrapper.Branch, BRANCH_TABLE_COLUMNS , null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Branch branch = parseStudent(cursor);
            branches.add(branch);
            cursor.moveToNext();
        }

        cursor.close();
        return branches;
    }

    private Branch parseStudent(Cursor cursor) {




        Branch branch = new Branch();
        branch.setBranch_ID((cursor.getInt(0)));
        branch.setBranch_NAME(cursor.getString(1));
        branch.setBranch_ICON(cursor.getString(2));



        return branch;
    }





        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setRetainInstance(true);
        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        //  BinderData bindingData = new BinderData(this,branchesDataCollection);

        Activity act = getActivity();
        // Create an array adapter for the list view, using the Ipsum headlines array
            dbHelper = new DataBaseWrapper(act);

            database = dbHelper.getReadableDatabase();



            List values = getAllBranches();
            branchesDataCollection = new ArrayList<HashMap<String, String>>();
            HashMap<String,String> map = null;
            for (int k = 0; k < values.size(); k++) {

                Branch branch = (Branch) values.get(k);
                map = new HashMap<String, String>();
                int id = branch.getBranch_ID();

                map.put(KEY_ID, Integer.toString(id));
                map.put(KEY_NAME, branch.getBranch_NAME());
                map.put(KEY_ICON, branch.getBranch_ICON());

                branchesDataCollection.add(map);
            }


        setListAdapter(new BinderData(getActivity(), branchesDataCollection));
            dbHelper.close();




    }

    @Override
    public void onStart() {
        super.onStart();

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)

        if (getFragmentManager().findFragmentById(R.id.rank_fragment) != null) {
           getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }





    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnServicesSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
        try {
            mCallback1 = (OnServicesSelectedListener2) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }



    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item

        if(mActiontype == 0){
            HashMap<String,String> map1 = null;
            map1 = new HashMap<String, String>();
            map1 = branchesDataCollection.get(position);
            int tid = Integer.parseInt(map1.get("id"));
            mCallback.onServiceSelected(tid);
        }
        if(mActiontype == 1){
            HashMap<String,String> map1 = null;
            map1 = new HashMap<String, String>();
            map1 = branchesDataCollection.get(position);
            int tid = Integer.parseInt(map1.get("id"));
            mCallback1.onServiceSelected2(tid);



        }


        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }






}
