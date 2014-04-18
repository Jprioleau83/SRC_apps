package com.cnsintegration.srcmarineinfo1;

/**
 * Created by jprioleau on 4/9/2014.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.cnsintegration.srcmarineinfo1.adapter.ExpandabelListAdoptor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */

public class RankFrag extends Fragment {

    View v;
    ExpandableListAdapter mAdapter;
    List<String> _listDataHeader;
    HashMap<String, List<HashMap<String, String>>> _listDataChild;

    ExpandableListView lv;
    Context con;

    OnServicesSelectedListener mCallback;
    OnServicesSelectedListener1 mCallback1;



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


    public interface OnServicesSelectedListener {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        public void onRankSelected(int position);
    }


    public interface OnServicesSelectedListener1 {
        /**
         * Called by ServiceFragment when a list item is selected
         */
        public void onRankCreated();
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
        try {
            mCallback1 = (OnServicesSelectedListener1) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
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
        mCallback1.onRankCreated();



       /** else{
            String[] listItems = {};

            setListAdapter(new ArrayAdapter(getActivity(),
                    android.R.layout.simple_list_item_1, listItems));
        }**/


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


        Log.i("Click", String.valueOf(position));
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

                        //4.-------
                        NodeList detailList = firstbranchElement.getElementsByTagName(KEY_DETAILS);
                        Element detailsElement = (Element) detailList.item(0);
                        NodeList detailTempList = detailsElement.getChildNodes();
                        //--city
                        map.put(KEY_DETAILS, ((Node) detailTempList.item(0)).getNodeValue().trim());
                        //5.-------
                        NodeList linkList = firstbranchElement.getElementsByTagName(KEY_LINKS);
                        Element linkElement = (Element) linkList.item(0);
                        NodeList linkTempList = linkElement.getChildNodes();
                        //--city
                        map.put(KEY_LINKS, ((Node) linkTempList.item(0)).getNodeValue().trim());


                        branchesDataCollection.add(map);
                    }
                }


                _listDataHeader = new ArrayList<String>();

                _listDataChild = new HashMap<String, List<HashMap<String, String>>>();

                for (int i = 0; i < branchesDataCollection.size(); i++) {
                    if (_listDataHeader.contains(branchesDataCollection.get(i).get(KEY_TYPE))) {
                        System.out.println("Account found");
                    } else {
                        // Map<String, String> map1 = new HashMap<String, String>();
                        //map1.put(KEY_TYPE, branchesDataCollection.get(i).get(KEY_TYPE));
                        //groupData.add(map1);
                        _listDataHeader.add(branchesDataCollection.get(i).get(KEY_TYPE));
                    }

                }
                _listDataChild = new HashMap<String, List<HashMap<String, String>>>();

                for (int i = 0; i < _listDataHeader.size(); i++) {
                    // get all the ranks for type and add it to an list then add the list to data array
                    HashMap<String, String> top250 = new HashMap<String, String>();
                    List<HashMap<String, String>> childGroupForFirstGroupRow;


                    childGroupForFirstGroupRow = new ArrayList<HashMap<String, String>>();
                    for (int k = 0; k < branchesDataCollection.size(); k++) {
                        String ty = (String) branchesDataCollection.get(k).get(KEY_TYPE).toString();
                        String t1 = (String) _listDataHeader.get(i);

                        if (ty.equals(t1)) {
                            //add it to list
                            HashMap<String, String> map1 = null;

                            map1 = new HashMap<String, String>();
                            map1.put(KEY_NAME, branchesDataCollection.get(k).get(KEY_NAME));
                            map1.put(KEY_PAY, branchesDataCollection.get(k).get(KEY_PAY));
                            map1.put(KEY_ICON, branchesDataCollection.get(k).get(KEY_ICON));
                            map1.put(KEY_DETAILS, branchesDataCollection.get(k).get(KEY_DETAILS));
                            map1.put(KEY_LINKS, branchesDataCollection.get(k).get(KEY_LINKS));

                            childGroupForFirstGroupRow.add(map1);
                            //top250.add((branchesDataCollection.get(k).get(KEY_NAME)));
                           // top250.add((branchesDataCollection.get(k).get(KEY_PAY)));
                            //top250.add((branchesDataCollection.get(k).get(KEY_ICON)));


                        }
                    }
                    //listOfChildGroups.add(childGroupForFirstGroupRow);
                    if(childGroupForFirstGroupRow!=null && !childGroupForFirstGroupRow.isEmpty()){

                        _listDataChild.put(_listDataHeader.get(i), childGroupForFirstGroupRow);
                    }


                }


            } catch (IOException ex) {
                Log.e("Error", ex.getMessage());
            } catch (Exception ex) {
                Log.e("Error", "Loading exception");
            }




            ExpandableListView lv = (ExpandableListView) v.findViewById(R.id.expandable_list);

            //here setting all the values to Parent and child classes
            // setDataValues();
            //prepareListData();//here get the values and set this values to adoptor and set it visible
            con=getActivity();

           // mAdapter=new ExpandabelListAdoptor(con,_listDataHeader, _listDataChild) ; //here i didnt set list values to this adoptor
            mAdapter=new ExpandabelListAdoptor(con,_listDataHeader, _listDataChild) ; //here i didnt set list values to this adoptor



            // mAdapter = new ExpandableListAdapter(this, _listDataHeader, _listDataChild);

            // setting list adapter
            lv.setAdapter(mAdapter);

            lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {

                    final HashMap<String, String> branchDataCollection1 = (HashMap<String, String>) mAdapter.getChild(groupPosition, childPosition);

                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(branchDataCollection1.get(KEY_LINKS)));
                        startActivity(browserIntent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getActivity(), "No application can handle this request,"
                                + " Please install a webbrowser", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    return false;
                }
            });



        }
    }









}
