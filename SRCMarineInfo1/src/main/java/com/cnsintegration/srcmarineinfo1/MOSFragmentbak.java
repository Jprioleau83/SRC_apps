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
import com.cnsintegration.srcmarineinfo1.adapter.MOSTitleData;
import com.cnsintegration.srcmarineinfo1.model.MTitles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class MOSFragmentbak extends ListFragment {

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

    List<MTitles> _listDataHeader;
    HashMap<String, List<HashMap<String, String>>> _listDataChild;


    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;



    public String[] MOS_TABLE_COLUMNS = { DataBaseWrapper.MOSTITLES_ID, DataBaseWrapper.MOSTITLES_TITLE, DataBaseWrapper.MOSTITLES_BRANCH};





    public MOSFragmentbak(int i) {
        mActiontype = i;
    }

    public interface OnServicesSelectedListener {
        /** Called by ServiceFragment when a list item is selected */



            public void onRankCreated();



    }
    public interface OnServicesSelectedListener2 {
        /**
         * Called by ServiceFragment when a list item is selected
         */


        public void onMOSSelected(int groupposition);


    }



    public List getAllMOS(int branch) {
        List titles = new ArrayList();
        String tempposition = Integer.toString(branch);


        Cursor cursor = database.query(DataBaseWrapper.MOSTITLES, MOS_TABLE_COLUMNS, "mos_branch=" + tempposition, null, null, null, null);

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

            database = dbHelper.getWritableDatabase();

            List values = getAllMOS(mActiontype);
            branchesDataCollection = new ArrayList<HashMap<String, String>>();
            HashMap<String,String> map = null;
            _listDataHeader = new ArrayList<MTitles>();

            for (int k = 0; k < values.size(); k++) {
                MTitles mtitle = (MTitles) values.get(k);

                _listDataHeader.add(mtitle);



            }


        setListAdapter(new MOSTitleData(getActivity(),_listDataHeader));






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
       /** try {
            mCallback = (OnServicesSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnServicesSelectedListener");
        }**/
        try {
            mCallback1 = (OnServicesSelectedListener2) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnServicesSelectedListener2");
        }



    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item


            MTitles selectedtitle = _listDataHeader.get(position);

            mCallback1.onMOSSelected(selectedtitle.getMOS_TITLES_ID());



        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }






}
