package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;
import com.cnsintegration.srcmarineinfo1.adapter.ETypeData;
import com.cnsintegration.srcmarineinfo1.model.Branch;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class RankTypeFragment extends ListFragment {

    OnRankTypeSelectedListener mCallback;



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
    ArrayList<String> branchesDataCollection;



    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;

    public String[] Ranks_TABLE_COLUMNS = { DataBaseWrapper.rank_ID, DataBaseWrapper.Rank_PAY, DataBaseWrapper.Rank_SHORT, DataBaseWrapper.Rank_NAME,
            DataBaseWrapper.Rank_ICON, DataBaseWrapper.Rank_TYPE, DataBaseWrapper.Rank_DETAILS, DataBaseWrapper.Rank_LINK, DataBaseWrapper.Rank_Branch };





    public RankTypeFragment(int i) {
        mActiontype = i;
    }

    public interface OnRankTypeSelectedListener {
        /** Called by ServiceFragment when a list item is selected */



            public void onRankTypeSelected(String rtype, int position);



    }



    public List getAllRanks(int position) {
        List ranks = new ArrayList();
        String tempposition = Integer.toString(position);
        Cursor cursor = database.query(DataBaseWrapper.Ranks, Ranks_TABLE_COLUMNS , "_branch=" + tempposition, null, null, null, null);

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


        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        //  BinderData bindingData = new BinderData(this,branchesDataCollection);

        Activity act = getActivity();
        // Create an array adapter for the list view, using the Ipsum headlines array
            dbHelper = new DataBaseWrapper(act);

            database = dbHelper.getReadableDatabase();



            List values = getAllRanks(mActiontype);
            branchesDataCollection = new ArrayList<String>();

            HashMap<String,String> map = null;
            for (int i = 0; i < values.size(); i++) {
                Rank rank = (Rank) values.get(i);
                if (branchesDataCollection.contains(rank.getRank_TYPE())) {
                    System.out.println("Account found");
                } else {
                    // Map<String, String> map1 = new HashMap<String, String>();
                    //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                    //groupData.add(map1);
                    branchesDataCollection.add(rank.getRank_TYPE());
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
            mCallback = (OnRankTypeSelectedListener) activity;
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
        mCallback.onRankTypeSelected(map1,mActiontype);




        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }






}
