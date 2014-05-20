package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.cnsintegration.srcmarineinfo1.adapter.ActionData;
import com.cnsintegration.srcmarineinfo1.adapter.BinderData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class ActionFragment extends ListFragment {

    OnServicesSelectedListener mCallback;


    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_ICON = "icon";
    public Context mCtx;
    ListView list;
    BinderData adapter = null;
    List<HashMap<String,String>> branchesDataCollection;

    public interface OnServicesSelectedListener {
        /** Called by ServiceFragment when a list item is selected */
        public void onActionSelected(int position);
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



            branchesDataCollection = new ArrayList<HashMap<String, String>>();



            //HashMap<String,String> map = null;


        HashMap<String,String> map = new HashMap<String,String>();
        HashMap<String,String> map1 = new HashMap<String,String>();
        HashMap<String,String> map2 = new HashMap<String,String>();
        HashMap<String,String> map3 = new HashMap<String,String>();
        HashMap<String,String> map4 = new HashMap<String,String>();
        HashMap<String,String> map5 = new HashMap<String,String>();
        HashMap<String,String> map6 = new HashMap<String,String>();

                    //-actions list
                    map6.put(KEY_ID, "0");
                    map6.put(KEY_NAME, "Home");
                    map6.put(KEY_ICON, "home_icon");


                    branchesDataCollection.add(map6);

                    //-actions list
                    map.put(KEY_ID, "1");
                    map.put(KEY_NAME, "Ranks");
                    map.put(KEY_ICON, "rank_icon");


                    branchesDataCollection.add(map);
                    map1.put(KEY_ID, "2");
                    map1.put(KEY_NAME, "Military Time");
                    map1.put(KEY_ICON, "wallclock");


                    branchesDataCollection.add(map1);
                    map2.put(KEY_ID, "3");
                    map2.put(KEY_NAME, "MOS");
                    map2.put(KEY_ICON, "patch");


                    branchesDataCollection.add(map2);
                    map3.put(KEY_ID, "4");
                    map3.put(KEY_NAME, "Alpha Numeric");
                    map3.put(KEY_ICON, "alpha");


                    branchesDataCollection.add(map3);
                    map4.put(KEY_ID, "5");
                    map4.put(KEY_NAME, "Org structure");
                    map4.put(KEY_ICON, "orgstructure");


                    branchesDataCollection.add(map4);
                    map5.put(KEY_ID, "6");
                    map5.put(KEY_NAME, "ACKs");
                    map5.put(KEY_ICON, "sunny");


                    branchesDataCollection.add(map5);




























            //setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Branches.Services));
        setListAdapter(new ActionData(getActivity(),branchesDataCollection));





    }

    @Override
    public void onStart() {
        super.onStart();

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)

        if (getFragmentManager().findFragmentById(R.id.rank_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
        ListView lv=getListView();
        lv.setDivider(this.getResources().getDrawable(R.drawable.black));
        lv.setDividerHeight(2);
        Drawable d=getResources().getDrawable(R.drawable.tiled_bk);
        lv.setBackground(d);


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
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item
        mCallback.onActionSelected(position);

        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }






}
