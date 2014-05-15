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
import com.cnsintegration.srcmarineinfo1.R;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;
import com.cnsintegration.srcmarineinfo1.adapter.ETypeData;
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.MTitles;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class MOSTypeFragment extends ListFragment {

    OnMOSTypeSelectedListener mCallback;



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
    List<MTitles> _listDataHeader;


    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;

    public String[] MOS_TABLE_COLUMNS = { DataBaseWrapper.MOSTITLES_ID, DataBaseWrapper.MOSTITLES_TITLE, DataBaseWrapper.MOSTITLES_BRANCH};



    public String[] MOS_TABLE_COLUMNS2 = { DataBaseWrapper.MOS_ID, DataBaseWrapper.MOS_NUMBER, DataBaseWrapper.MOS_NAME, DataBaseWrapper.MOS_TYPE, DataBaseWrapper.MOS_RANK, DataBaseWrapper.MOS_TITLE};






    public MOSTypeFragment(int i) {
        mActiontype = i;
    }

    public List getMOSES(int mostitleid) {
        List moses = new ArrayList();
        String tempposition = Integer.toString(mostitleid);


        Cursor cursor = database.query(DataBaseWrapper.MOS, MOS_TABLE_COLUMNS2, "most_id=" + tempposition, null, null, null, null);

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




        return mos;
    }




    public List getAllMOST(int branch) {
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

            database = dbHelper.getReadableDatabase();

            //get all moses for selected branch and display the mos type

            //step 1 get all most titles for branch
            //step2 get all mos for titles

            //place all mos types in array to list


            //step1:
            List values = getAllMOST(mActiontype);
            _listDataHeader = new ArrayList<MTitles>();

            for (int k = 0; k < values.size(); k++) {
                MTitles mtitle = (MTitles) values.get(k);

                _listDataHeader.add(mtitle);


            }


            branchesDataCollection = new ArrayList<String>();
            for (int i = 0; i < _listDataHeader.size(); i++) {
                // get all the ranks for type and add it to an list then add the list to data array
                HashMap<String, String> top250 = new HashMap<String, String>();
                List<String> childGroupForFirstGroupRow;
                //Step:2
                List values1 = getMOSES( _listDataHeader.get(i).getMOS_TITLES_ID());
                childGroupForFirstGroupRow = new ArrayList<String>();


                for (int k = 0; k < values1.size(); k++) {

                    MOS mos = (MOS) values1.get(k);



                    if (branchesDataCollection.contains(mos.getMOS_TYPE())) {
                        System.out.println("Account found");
                    } else {
                        // Map<String, String> map1 = new HashMap<String, String>();
                        //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                        //groupData.add(map1);
                        branchesDataCollection.add(mos.getMOS_TYPE());
                        System.out.println("Account Added");
                    }






                }


            }



            branchesDataCollection.add("All");

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
            mCallback = (OnMOSTypeSelectedListener) activity;
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
        mCallback.onMOSTypeelected(map1, mActiontype);




        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }


    public interface OnMOSTypeSelectedListener {
        /** Called by ServiceFragment when a list item is selected */



        public void onMOSTypeelected(String mostype, int postion);



    }



}
