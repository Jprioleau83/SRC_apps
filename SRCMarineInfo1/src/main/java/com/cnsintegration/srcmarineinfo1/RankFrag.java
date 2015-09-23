package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ListView;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;
import com.cnsintegration.srcmarineinfo1.adapter.RankData;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class RankFrag extends ListFragment {




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
    Rank tRanks;



    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;
    public String rank_type;

    public String[] Ranks_TABLE_COLUMNS = { DataBaseWrapper.rank_ID, DataBaseWrapper.Rank_PAY, DataBaseWrapper.Rank_SHORT, DataBaseWrapper.Rank_NAME,
            DataBaseWrapper.Rank_ICON, DataBaseWrapper.Rank_TYPE, DataBaseWrapper.Rank_DETAILS, DataBaseWrapper.Rank_LINK, DataBaseWrapper.Rank_Branch };


    public RankFrag(Rank rank) {
        tRanks = rank;


    }
    public RankFrag() {


    }




    public Rank getRank(int id) {
        Rank rank = new Rank();
        String tempposition = Integer.toString(id);
        Cursor cursor = database.query(DataBaseWrapper.Ranks, Ranks_TABLE_COLUMNS , "_id=" + tempposition, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            rank = parseStudent(cursor);
            cursor.moveToNext();
        }

        cursor.close();
        return rank;
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


        // Rank value = getRank((int)tRanks.getId());


        setListAdapter(new RankData(act, tRanks));

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








}
