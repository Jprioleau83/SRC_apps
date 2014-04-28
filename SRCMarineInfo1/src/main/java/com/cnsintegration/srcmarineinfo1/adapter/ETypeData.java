package com.cnsintegration.srcmarineinfo1.adapter;

import android.app.Activity;
import android.content.Context;
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
public class ETypeData extends BaseAdapter {




    LayoutInflater inflater;
    ImageView thumb_image;
    List<String> branchDataCollection;
    ViewHolder holder;



    public ETypeData(Activity act, List<String> map) {

        this.branchDataCollection = map;

        inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {

        return branchDataCollection.size();

    }

    @Override
    public Object getItem(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null){

            vi = inflater.inflate(R.layout.list_view, null);
            holder = new ViewHolder();

            holder.tvBranch = (TextView)vi.findViewById(R.id.listtext); // city name


            vi.setTag(holder);
        }
        else{

            holder = (ViewHolder)vi.getTag();
        }

        // Setting all values in listview

        holder.tvBranch.setText(branchDataCollection.get(position));




        return vi;



    }
    static class ViewHolder{

        TextView tvBranch;


    }
}
