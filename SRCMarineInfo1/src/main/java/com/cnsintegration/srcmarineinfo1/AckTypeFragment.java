package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;
import com.cnsintegration.srcmarineinfo1.adapter.ETypeData;
import com.cnsintegration.srcmarineinfo1.model.Ack;
import com.cnsintegration.srcmarineinfo1.model.Branch;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class AckTypeFragment extends ListFragment {

    OnAckheadSelectedListener mCallback;




    public static int mActiontype;
    int mCurrentPosition = -1;
    public Context mCtx;
    ListView list;
    BinderData adapter = null;
    ArrayList<String> branchesDataCollection;



    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;

    public String[] Ack_TABLE_COLUMNS = { "id", DataBaseWrapper.Ack, DataBaseWrapper.Ack_Name, DataBaseWrapper.Ack_Details, DataBaseWrapper.Ack_Link, DataBaseWrapper.Ack_Icon };
    final static String ARG_POSITION = "position";



    public AckTypeFragment(int i) {
        mActiontype = i;
    }

    public AckTypeFragment() {

    }
    public interface OnAckheadSelectedListener {
        /** Called by ServiceFragment when a list item is selected */


        void onAckTypeSelected(String letter);



    }


    public List getAllAck() {
        List acks = new ArrayList();

        Cursor cursor = database.query(DataBaseWrapper.Ackdb, Ack_TABLE_COLUMNS , null, null, null, null, "ack");

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
        ack.setAck(cursor.getString(1));
        ack.setAck_name(cursor.getString(2));
        ack.setAck_details(cursor.getString(3));
        ack.setAck_link(cursor.getString(4));
        ack.setAck_icon(cursor.getString(5));




        return ack;
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

            database = dbHelper.getWritableDatabase();



            List values = getAllAck();

        branchesDataCollection = new ArrayList<String>();

        HashMap<String,String> map = null;
        for (int i = 0; i < values.size(); i++) {
            Ack ack = (Ack) values.get(i);
            if (branchesDataCollection.contains(ack.getAck().substring(0,1).toUpperCase() )) {
                System.out.println("Account found");
            } else {
                // Map<String, String> map1 = new HashMap<String, String>();
                //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                //groupData.add(map1);
                branchesDataCollection.add(ack.getAck().substring(0, 1).toUpperCase());
                System.out.println("Account Added");
            }

        }





        setListAdapter(new ETypeData(getActivity(),branchesDataCollection));

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
            mCallback = (OnAckheadSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }




    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item


        String map1 = null;

        map1 = branchesDataCollection.get(position);
        //int tid = Integer.parseInt(map1.get("id"));
        mCallback.onAckTypeSelected(map1);





        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }





}
