package com.cnsintegration.srcmarineinfo1;

import android.content.Context;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OrgFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    Context con;
    Matrix imageMatrix;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int res1;

    public OrgFragment(int res1) {
        this.res1 = res1;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrgFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrgFragment newInstance(String param1, String param2) {
        OrgFragment fragment = new OrgFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public OrgFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_org, container, false);

        con = getActivity();

        TouchImageView img = new TouchImageView(con);
        img.setImageResource(res1);
        img.setMaxZoom(4f);




        return img;

    }




}
