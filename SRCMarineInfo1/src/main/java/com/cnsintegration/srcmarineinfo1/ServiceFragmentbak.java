package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.cnsintegration.srcmarineinfo1.adapter.BinderData;

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

/**
 * Created by jprioleau on 4/5/2014.
 */
public class ServiceFragmentbak extends ListFragment {

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

    public ServiceFragmentbak(int i) {
        mActiontype = i;
    }

    public interface OnServicesSelectedListener {
        /** Called by ServiceFragment when a list item is selected */



            public void onServiceSelected(int position);



    }
    public interface OnServicesSelectedListener2 {
        /**
         * Called by ServiceFragment when a list item is selected
         */


        public void onServiceSelected2(int position);


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

        try {


            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (getActivity().getAssets().open("branchdata.xml"));




            branchesDataCollection = new ArrayList<HashMap<String, String>>();

            doc.getDocumentElement ().normalize ();

            NodeList BranchList = doc.getElementsByTagName("branchdata");

            HashMap<String,String> map = null;

            for (int i = 0; i < BranchList.getLength(); i++) {

                map = new HashMap<String,String>();
                Node firstBranchNode = BranchList.item(i);



                if(firstBranchNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element firstbranchElement = (Element)firstBranchNode;

                    NodeList idList = firstbranchElement.getElementsByTagName(KEY_ID);
                    Element firstIdElement = (Element) idList.item(0);
                    NodeList textIdList = firstIdElement.getChildNodes();
                    //--id
                    map.put(KEY_ID, ((Node) textIdList.item(0)).getNodeValue().trim());

                    //2.-------
                    NodeList branchnameList = firstbranchElement.getElementsByTagName(KEY_NAME);
                    Element firstCityElement = (Element) branchnameList.item(0);
                    NodeList textCityList = firstCityElement.getChildNodes();
                    //--city
                    map.put(KEY_NAME, ((Node) textCityList.item(0)).getNodeValue().trim());

                    //3.-------
                    NodeList iconList = firstbranchElement.getElementsByTagName(KEY_ICON);
                    Element firstTempElement = (Element) iconList.item(0);
                    NodeList textTempList = firstTempElement.getChildNodes();
                    //--city
                    map.put(KEY_ICON, ((Node) textTempList.item(0)).getNodeValue().trim());


                    branchesDataCollection.add(map);
                }
            }



        } catch (IOException ex) {
            Log.e("Error", ex.getMessage());
        } catch (Exception ex) {
            Log.e("Error", "Loading exception");
        }




















            //setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Branches.Services));
        setListAdapter(new BinderData(getActivity(),branchesDataCollection));





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
            mCallback.onServiceSelected(position);
        }
        if(mActiontype == 1){
            mCallback1.onServiceSelected2(position);
        }


        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }






}
