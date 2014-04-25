package com.cnsintegration.srcmarineinfo1.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsintegration.srcmarineinfo1.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class MOSTitleData extends BaseAdapter {


    LayoutInflater inflater;
    ImageView thumb_image;
    List<HashMap<String,String>> branchDataCollection;
    ViewHolder holder;

    private List<String> _listDataHeader;



    public MOSTitleData(Activity act, List<String> listDataHeader) {

        this._listDataHeader = listDataHeader;

        inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {

        return _listDataHeader.size();

    }

    @Override
    public Object getItem(int i) {
        // TODO Auto-generated method stub
        return this._listDataHeader.get(i);
    }




    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String headerTitle = (String) getItem(position);
        View vi=convertView;
        if (convertView == null) {

            vi = inflater.inflate(R.layout.article_view, null);
            holder = new ViewHolder();
            holder.tvBranch = (TextView)vi.findViewById(R.id.article); // city name
            holder.tvBranchImage =(ImageView)vi.findViewById(R.id.list_image); // thumb image

            vi.setTag(holder);
        }else{

            holder = (ViewHolder)vi.getTag();
        }

        holder.tvBranch.setText(headerTitle);

        // holder.tvBranch.setTextColor(Color.WHITE);


        //Setting an image
        String uri = "drawable/sunny";
        int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
        Drawable image = vi.getContext().getResources().getDrawable(imageResource);
        holder.tvBranchImage.setImageDrawable(image);

        return vi;








    }


    static class ViewHolder{

        TextView tvBranch;

        ImageView tvBranchImage;
    }
}
