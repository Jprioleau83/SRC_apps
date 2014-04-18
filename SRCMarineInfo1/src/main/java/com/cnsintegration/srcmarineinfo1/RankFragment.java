package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import android.content.Context;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleExpandableListAdapter;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class RankFragment extends ListFragment {
    OnServicesSelectedListener mCallback;
    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_TYPE = "type";
    static final String KEY_ICON = "icon";
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    public int mCtx;
    ListView list;
    BinderData adapter = null;
    List<HashMap<String, String>> branchesDataCollection;
    HashMap<String, List<String>> listDataChild;
    HashMap<String,String> mapheader;

    List<Map<String, String>> groupData;
    List<List<Map<String, String>>> listOfChildGroups;

    List<String> listDataHeader; // header titles
    RankDatabak listAdapter;

    //public RankFragment(int position) {
      //  mCurrentPosition = position;
    //}

    public interface OnServicesSelectedListener {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        public void onRankSelected(int position);
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

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }




    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateRankView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateRankView(mCurrentPosition);
        }
        else{
            String[] listItems = {};

            setListAdapter(new ArrayAdapter(getActivity(),
                    android.R.layout.simple_list_item_1, listItems));
        }


    }

    public void updateRankView(int position) {

        String rankfilename = "";

        if (position == 0){
            rankfilename = "usmcranks.xml";
        }
        if (position == 1){
            rankfilename = "usafranks.xml";
        }
        if (position == 2){
            rankfilename = "usarmyranks.xml";
        }
        if (position == 3){
            rankfilename = "usnavyranks.xml";
        }
        if (position == 4){
            rankfilename = "uscgranks.xml";
        }


        Log.i("Click",String.valueOf(position));
        if (rankfilename != "") {
            try {


                DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(getActivity().getAssets().open(rankfilename));


                branchesDataCollection = new ArrayList<HashMap<String, String>>();

                doc.getDocumentElement().normalize();

                NodeList BranchList = doc.getElementsByTagName("ranksdata");

                HashMap<String, String> map = null;

                for (int i = 0; i < BranchList.getLength(); i++) {

                    map = new HashMap<String, String>();
                    Node firstBranchNode = BranchList.item(i);


                    if (firstBranchNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element firstbranchElement = (Element) firstBranchNode;

                        NodeList ranktypeList = firstbranchElement.getElementsByTagName(KEY_TYPE);
                        Element ranktypeElement = (Element) ranktypeList.item(0);
                        NodeList typeList = ranktypeElement.getChildNodes();
                        //--city
                        map.put(KEY_TYPE, ((Node) typeList.item(0)).getNodeValue().trim());



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
                        NodeList paynameList = firstbranchElement.getElementsByTagName(KEY_PAY);
                        Element payElement = (Element) paynameList.item(0);
                        NodeList payList = payElement.getChildNodes();
                        //--city
                        map.put(KEY_PAY, ((Node) payList.item(0)).getNodeValue().trim());

                        //4.-------
                        NodeList iconList = firstbranchElement.getElementsByTagName(KEY_ICON);
                        Element firstTempElement = (Element) iconList.item(0);
                        NodeList textTempList = firstTempElement.getChildNodes();
                        //--city
                        map.put(KEY_ICON, ((Node) textTempList.item(0)).getNodeValue().trim());


                        branchesDataCollection.add(map);
                    }
                }


                listDataHeader = new ArrayList<String>();

                listDataChild = new HashMap<String, List<String>>();

                for (int i = 0; i < branchesDataCollection.size(); i++) {
                    if (listDataHeader.contains(branchesDataCollection.get(i).get(KEY_TYPE))) {
                        System.out.println("Account found");
                    } else {
                       // Map<String, String> map1 = new HashMap<String, String>();
                        //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                        //groupData.add(map1);
                        listDataHeader.add(branchesDataCollection.get(i).get(KEY_TYPE));
                    }

                }
                listDataChild = new HashMap<String, List<String>>();

                for (int i = 0; i < listDataHeader.size(); i++) {
                    // get all the ranks for type and add it to an list then add the list to data array
                    List<String> top250 = new ArrayList<String>();

                   // List<Map<String, String>> childGroupForFirstGroupRow = null;

                    for (int k = 0; k < branchesDataCollection.size(); k++) {
                        String ty = (String) branchesDataCollection.get(k).get(KEY_TYPE).toString();
                        String t1 = (String) listDataHeader.get(i);

                        if (ty.equals(t1)) {
                            //add it to list
                           //Map<String, String> map1 = new HashMap<String, String>();
                            //map1.put(branchesDataCollection.get(i).get(KEY_NAME), branchesDataCollection.get(i).get(KEY_NAME));
                            //childGroupForFirstGroupRow.add(map1);
                            top250.add((branchesDataCollection.get(k).get(KEY_NAME)));

                        }
                    }
                    //listOfChildGroups.add(childGroupForFirstGroupRow);

                    boolean retval = top250.isEmpty();
                    if (retval == false) {
                        listDataChild.put(listDataHeader.get(i), top250);
                    }


                }


            } catch (IOException ex) {
                Log.e("Error", ex.getMessage());
            } catch (Exception ex) {
                Log.e("Error", "Loading exception");
            }




            //setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Branches.Services));
            //setListAdapter(new RankData(getActivity(),branchesDataCollection));
            //setListAdapter( new RankDatabak(getActivity(), listDataHeader, branchesDataCollection));
           listAdapter = new RankDatabak(getActivity(), listDataHeader, listDataChild);

           /** new SimpleExpandableListAdapter(
                    getActivity(),

                    branchesDataCollection,
                    android.R.layout.simple_expandable_list_item_1,
                    new String[] { "ROOT_NAME" },
                    new int[] { android.R.id.text1 },

                    listOfChildGroups,
                    android.R.layout.simple_expandable_list_item_2,
                    new String[] { KEY_NAME, KEY_NAME },
                    new int[] { android.R.id.text1, android.R.id.text2 }
            );**/

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
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item
        mCallback.onRankSelected(position);

        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }

}
