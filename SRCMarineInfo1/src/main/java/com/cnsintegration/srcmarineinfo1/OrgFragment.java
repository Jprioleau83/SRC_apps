package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cnsintegration.srcmarineinfo1.utils.DecodeUtils;

import java.io.InputStream;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import it.sephiroth.android.library.imagezoom.utils.*;

public class OrgFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ImageViewTouch mImage;
    Context con;
    Matrix imageMatrix;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



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


        mImage = (ImageViewTouch) V.findViewById(R.id.image);

        // set the default image display type
        mImage.setDisplayType( ImageViewTouchBase.DisplayType.FIT_IF_BIGGER );

        con = getActivity();

        final int size = -1;
        String imageUri = "drawable/spawarorgcht";

        int imageResource = V.getContext().getApplicationContext().getResources().getIdentifier(imageUri, null, V.getContext().getApplicationContext().getPackageName());


        //Uri uri = Uri.parse("android.resource://com.cnsintegration.srcmarineinfo1/R.drawable.spawarorgcht");
        Resources resources = con.getResources();
        Uri uri  = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(imageResource) + '/' + resources.getResourceTypeName(imageResource) + '/' + resources.getResourceEntryName(imageResource) );


        Bitmap bitmap = DecodeUtils.decode(con, uri, size, size);
        if( null != bitmap )
        {
            // calling this will force the image to fit the ImageView container width/height

            if( null == imageMatrix ) {
                imageMatrix = new Matrix();
            } else {
                // get the current image matrix, if we want restore the
                // previous matrix once the bitmap is changed
                // imageMatrix = mImage.getDisplayMatrix();
            }

            mImage.setImageBitmap( bitmap, imageMatrix.isIdentity() ? null : imageMatrix, ImageViewTouchBase.ZOOM_INVALID, ImageViewTouchBase.ZOOM_INVALID );

        }
        return V;

    }




}
