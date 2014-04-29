package com.cnsintegration.srcmarineinfo1;

/**
 * Created by jprioleau on 4/9/2014.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

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
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */

public class MOSFragbak extends Fragment {

    View v;
    ExpandableListAdapter mAdapter;
    List<String> _listDataHeader;
    HashMap<String, List<HashMap<String, String>>> _listDataChild;

    ExpandableListView lv;
    Context con;

    OnMosSelectedListener mCallback;



    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_TYPE = "type";
    static final String KEY_ICON = "icon";
    static final String KEY_DETAILS = "details";
    static final String KEY_LINKS = "link";

    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    List<HashMap<String, String>> branchesDataCollection;


    public interface OnMosSelectedListener {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        public void onRankSelected(int position);
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.rank_lst,
                container, false);


        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        super.onActivityCreated(savedInstanceState);

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
       /** try {
            mCallback = (OnMosSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }**/

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
            updateMOSView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateMOSView(mCurrentPosition);
        }



       /** else{
            String[] listItems = {};

            setListAdapter(new ArrayAdapter(getActivity(),
                    android.R.layout.simple_list_item_1, listItems));
        }**/


    }



    public void updateMOSView(int position) {

        String mosfilename = "";

        if (position == 0){
            mosfilename = "usmcmos.xml";
        }


        Log.i("Click", String.valueOf(position));
        if (mosfilename != "") {
            try {


                DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(getActivity().getAssets().open(mosfilename));


                branchesDataCollection = new ArrayList<HashMap<String, String>>();

                doc.getDocumentElement().normalize();

                NodeList BranchList = doc.getElementsByTagName("mosdata");

                _listDataChild = new HashMap<String, List<HashMap<String, String>>>();
                _listDataHeader = new ArrayList<String>();

                for (int i = 0; i < BranchList.getLength(); i++) {




                    Node firstBranchNode = BranchList.item(i);


                    if (firstBranchNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element firstbranchElement = (Element) firstBranchNode;

                        NodeList ranktypeList = firstbranchElement.getElementsByTagName("mostitle");
                        Element ranktypeElement = (Element) ranktypeList.item(0);
                        NodeList typeList = ranktypeElement.getChildNodes();
                        //--city
                        _listDataHeader.add(((Node) typeList.item(0)).getNodeValue().trim());

                        NodeList BranchList2 = doc.getElementsByTagName("rtype");
                        List<HashMap<String, String>> childGroupForFirstGroupRow;

                        childGroupForFirstGroupRow = new ArrayList<HashMap<String, String>>();






                        for (int j = 0; j < BranchList2.getLength(); j++) {
                            Node firstBranchNode2 = BranchList2.item(j);
                            HashMap<String, String> map = null;
                            map = new HashMap<String, String>();
                            if (firstBranchNode2.getNodeType() == Node.ELEMENT_NODE) {

                                Element enlistmenttype = (Element) firstBranchNode2;

                                NodeList enlisttypeList = enlistmenttype.getElementsByTagName("rtypetitle");
                                Element enlisttypeElement = (Element) enlisttypeList.item(0);
                                NodeList entypeList = enlisttypeElement.getChildNodes();

                                map.put("rtypetitle", ((Node) entypeList.item(0)).getNodeValue().trim());
                                childGroupForFirstGroupRow.add(map);

                            }
                            if(childGroupForFirstGroupRow!=null && !childGroupForFirstGroupRow.isEmpty()){

                                _listDataChild.put(_listDataHeader.get(i), childGroupForFirstGroupRow);
                            }

                        }





                        //map.put("mostitle", ((Node) typeList.item(0)).getNodeValue().trim());

                       /** NodeList BranchList2 = doc.getElementsByTagName("rtype");

                        for (int k = 0; i < BranchList2.getLength(); k++) {
                            Node firstmosNode = BranchList2.item(i);


                            if (firstmosNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element firstmosElement = (Element) firstBranchNode;

                                NodeList mostypeList = firstmosElement.getElementsByTagName("rtypetitle");
                                Element mostypeElement = (Element) mostypeList.item(0);
                                NodeList mosList = mostypeElement.getChildNodes();
                                //--city
                                map.put("mostitle", ((Node) mosList.item(0)).getNodeValue().trim());

                            }
                         }**/


                    }


                }

                //setListAdapter(new MOSTitleData(getActivity(),_listDataHeader));




            } catch (IOException ex) {
                Log.e("Error", ex.getMessage());
            } catch (Exception ex) {
                Log.e("Error", "Loading exception");
            }








        }
    }









}
