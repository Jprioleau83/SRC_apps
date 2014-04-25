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
import com.cnsintegration.srcmarineinfo1.adapter.MOSTitleData;

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
public class MOSFragment extends ListFragment {

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

    List<String> _listDataHeader;
    HashMap<String, List<HashMap<String, String>>> _listDataChild;

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


        public void onMOSSelected(int groupposition, int position);


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

            String mosfilename = "";
            int position = mActiontype;
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

                    setListAdapter(new MOSTitleData(getActivity(),_listDataHeader));




                } catch (IOException ex) {
                    Log.e("Error", ex.getMessage());
                } catch (Exception ex) {
                    Log.e("Error", "Loading exception");
                }








            }




    }

    @Override
    public void onStart() {
        super.onStart();

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)

        if (getFragmentManager().findFragmentById(R.id.rank_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
        mCallback.onRankCreated();




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
                    + " must implement OnServicesSelectedListener");
        }
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



            mCallback1.onMOSSelected(mActiontype ,position);



        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }






}
