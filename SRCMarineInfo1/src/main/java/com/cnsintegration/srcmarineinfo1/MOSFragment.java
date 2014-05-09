package com.cnsintegration.srcmarineinfo1;

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
import android.widget.ListView;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;
import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor3;
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.MTitles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class MOSFragment extends Fragment {

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
    HashMap<String, List<MOS>> _listDataChild;
    View v;
    Context con;
    ExpandableListAdapter mAdapter;


    public DataBaseWrapper dbHelper;

    public SQLiteDatabase database;



    public String[] MOS_TABLE_COLUMNS = { DataBaseWrapper.MOSTITLES_ID, DataBaseWrapper.MOSTITLES_TITLE, DataBaseWrapper.MOSTITLES_BRANCH};



    public String[] MOS_TABLE_COLUMNS2 = { DataBaseWrapper.MOS_ID, DataBaseWrapper.MOS_NUMBER, DataBaseWrapper.MOS_NAME, DataBaseWrapper.MOS_TYPE, DataBaseWrapper.MOS_RANK, DataBaseWrapper.MOS_TITLE};





    public MOSFragment(int i) {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.rank_lst,
                container, false);


        // return v;

        // ViewPager mViewPager = (ViewPager) v.findViewById(R.id.pager);
        // Set the ViewPagerAdapter into ViewPager
        //mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        return v;
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
        _listDataChild = new HashMap<String, List<MOS>>();


        for (int i = 0; i < _listDataHeader.size(); i++) {
            // get all the ranks for type and add it to an list then add the list to data array
            HashMap<String, String> top250 = new HashMap<String, String>();
            List<MOS> childGroupForFirstGroupRow;

            List values1 = getMOSES( _listDataHeader.get(i).getMOS_TITLES_ID());
            childGroupForFirstGroupRow = new ArrayList<MOS>();
            for (int k = 0; k < values1.size(); k++) {

                MOS mos = (MOS) values1.get(k);

                String ty = (String) mos.getMOS_TYPE();
                MTitles selectedtitle = _listDataHeader.get(i);
                String t1 = selectedtitle.getMOS_TITLES_TITLE();

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

                _listDataChild.put(_listDataHeader.get(i).getMOS_TITLES_TITLE(), childGroupForFirstGroupRow);
            }

        }
     //   v= inflater.inflate(R.layout.rank_lst, container, false);


        ExpandableListView lv = (ExpandableListView) v.findViewById(R.id.expandable_list);


        con=getActivity();


        mAdapter = new ExpandabelListAdoptor3(con, _listDataHeader, _listDataChild, mActiontype); //here i didnt set list values to this adoptor


        lv.setAdapter(mAdapter);







        }

    @Override
    public void onStart() {
        super.onStart();

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)

        if (getFragmentManager().findFragmentById(R.id.rank_fragment) != null) {
           // getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }





    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        /**
        try {
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
/**
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item


            //MTitles selectedtitle = _listDataHeader.get(position);

            //mCallback1.onMOSSelected(selectedtitle.getMOS_TITLES_ID());



        // Set the item as checked to be highlighted when in two-pane layout
        //getListView().setItemChecked(position, true);
    }

**/




}
