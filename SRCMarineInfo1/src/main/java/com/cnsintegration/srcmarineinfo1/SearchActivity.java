package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.MOSData;
import com.cnsintegration.srcmarineinfo1.adapter.searchrankresult;
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.FragmentManager;

/**
 * Created by jprioleau on 5/27/2014.
 */
public class SearchActivity extends ListActivity {
    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;

    public String[] MOS_TABLE_COLUMNS = {DataBaseWrapper.MOSTITLES_ID, DataBaseWrapper.MOSTITLES_TITLE, DataBaseWrapper.MOSTITLES_BRANCH};

    public String[] MOS_TABLE_COLUMNS2 = {DataBaseWrapper.MOS_ID, DataBaseWrapper.MOS_NUMBER, DataBaseWrapper.MOS_NAME, DataBaseWrapper.MOS_TYPE, DataBaseWrapper.MOS_RANK, DataBaseWrapper.MOS_TITLE, DataBaseWrapper.MOS_Link};

    public String[] Ranks_TABLE_COLUMNS = { DataBaseWrapper.rank_ID, DataBaseWrapper.Rank_PAY, DataBaseWrapper.Rank_SHORT, DataBaseWrapper.Rank_NAME,
            DataBaseWrapper.Rank_ICON, DataBaseWrapper.Rank_TYPE, DataBaseWrapper.Rank_DETAILS, DataBaseWrapper.Rank_LINK, DataBaseWrapper.Rank_Branch };




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    public void onListItemClick(ListView l,
                                View v, int position, long id) {
        // call detail activity for clicked entry
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query =
                    intent.getStringExtra(SearchManager.QUERY);
            doSearch(query);
        }
    }

    private void doSearch(String queryStr) {
        // get a Cursor, prepare the ListAdapter

        // and set it



        dbHelper = new DataBaseWrapper(this);

        database = dbHelper.getWritableDatabase();



        //if string has number search for mos if not search rank
        if(queryStr.matches(".*\\d.*")){
            // search mos
            Cursor cursor;
            List moses = new ArrayList();

            cursor = database.query(DataBaseWrapper.MOS, MOS_TABLE_COLUMNS2, "mos_number LIKE '" + queryStr + "'", null, null, null, null);


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MOS mos = parseStudent1(cursor);
            moses.add(mos);
            cursor.moveToNext();
        }

        cursor.close();

            //display mos

            setListAdapter(new MOSData(this,moses));
            dbHelper.close();






        } else{
            // search rank

            Cursor cursor = database.query(DataBaseWrapper.Ranks, Ranks_TABLE_COLUMNS , "_name LIKE '" + queryStr + "' OR _short LIKE '" + queryStr + "'", null, null, null, null);
            List ranks = new ArrayList();
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Rank rank = parseStudent(cursor);
                ranks.add(rank);
                cursor.moveToNext();
            }

            cursor.close();


            setListAdapter(new searchrankresult(this,ranks));





        }



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
}