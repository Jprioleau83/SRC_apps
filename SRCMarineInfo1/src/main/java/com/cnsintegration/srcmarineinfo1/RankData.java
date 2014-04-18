package com.cnsintegration.srcmarineinfo1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/5/2014.
 */
public class RankData extends BaseAdapter {

    static final String KEY_TAG = "rankdata"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_ICON = "icon";

    LayoutInflater inflater;
    ImageView thumb_image;
    List<HashMap<String,String>> branchDataCollection;
    ViewHolder holder;



    public RankData(Activity act, List<HashMap<String, String>> map) {

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

            vi = inflater.inflate(R.layout.rank_view, null);
            holder = new ViewHolder();

            holder.tvRank = (TextView)vi.findViewById(R.id.rank); // city name
            holder.tvPay = (TextView)vi.findViewById(R.id.payscale); // city name
            holder.tvRankImage =(ImageView)vi.findViewById(R.id.rank_image); // thumb image

            vi.setTag(holder);
        }
        else{

            holder = (ViewHolder)vi.getTag();
        }

        // Setting all values in listview

        holder.tvRank.setText(branchDataCollection.get(position).get(KEY_NAME));
        holder.tvPay.setText(branchDataCollection.get(position).get(KEY_PAY));
        //holder.tvRank.setTextColor(Color.WHITE);
        //holder.tvPay.setTextColor(Color.WHITE);


        //Setting an image
        String uri = "drawable/"+ branchDataCollection.get(position).get(KEY_ICON);
        int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
        Drawable image = vi.getContext().getResources().getDrawable(imageResource);
        holder.tvRankImage.setImageDrawable(image);

        return vi;



    }
    static class ViewHolder{

        TextView tvRank;
        TextView tvPay;
        ImageView tvRankImage;
    }
}
