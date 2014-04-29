package com.cnsintegration.srcmarineinfo1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsintegration.srcmarineinfo1.R;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/29/2014.
 */
public class RankData extends BaseAdapter {

    LayoutInflater inflater;
    ImageView thumb_image;
    List<HashMap<String,String>> branchDataCollection;
    ViewHolder holder;
    public Rank tRank;
    private Context _context;


    public RankData(Context con, Rank rank) {
        this._context=con;
        tRank = rank;

        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
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
            inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.view_rank, null);
            holder = new ViewHolder();

            holder.tvRank = (TextView)vi.findViewById(R.id.rankname); // rank
            holder.tvshort = (TextView)vi.findViewById(R.id.rankshort); // rank short name
            holder.tvPay = (TextView)vi.findViewById(R.id.rankpay); // city name
            holder.tvDetail = (TextView)vi.findViewById(R.id.rankdetails); // city name

            holder.tvRankImage =(ImageView)vi.findViewById(R.id.rankicon); // thumb image

            vi.setTag(holder);
        }
        else{

            holder = (ViewHolder)vi.getTag();
        }

        // Setting all values in listview

        holder.tvRank.setText(tRank.getName());
        holder.tvPay.setText(tRank.getRank_PAY());
        holder.tvshort.setText(tRank.getShortName());
        holder.tvDetail.setText(tRank.getRank_DETAILS());
        //holder.tvRank.setTextColor(Color.WHITE);
        //holder.tvPay.setTextColor(Color.WHITE);


        //Setting an image
        String uri = "drawable/"+ tRank.getIcon();
        int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
        Drawable image = vi.getContext().getResources().getDrawable(imageResource);
        holder.tvRankImage.setImageDrawable(image);


        return vi;



    }



    public static class ViewHolder{

        TextView tvRank;
        TextView tvshort;
        TextView tvPay;
        TextView tvDetail;

        ImageView tvRankImage;
    }

}
