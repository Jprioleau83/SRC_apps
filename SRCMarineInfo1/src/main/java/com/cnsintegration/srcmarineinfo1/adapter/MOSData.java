package com.cnsintegration.srcmarineinfo1.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cnsintegration.srcmarineinfo1.R;
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/29/2014.
 */
public class MOSData extends BaseAdapter  {

    LayoutInflater inflater;
    ImageView thumb_image;
    List<HashMap<String,String>> branchDataCollection;
    ViewHolder holder;


    List tmos = new ArrayList();
    private Context _context;


    public MOSData(Context con, List mos) {
        this._context=con;
        tmos = mos;

        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return tmos.size();
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

        final MOS thismos = (MOS) tmos.get(position);
        if(convertView==null){
            inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.mos_view, null);
            holder = new ViewHolder();



            holder.tvRank = (TextView) vi.findViewById(R.id.rank); // city name
            holder.tvPay = (TextView) vi.findViewById(R.id.payscale); // city name
            holder.tvDetail = (TextView) vi.findViewById(R.id.rank_details); // city name
            holder.tvLink = (TextView) vi.findViewById(R.id.mos_link); // city n

            vi.setTag(holder);
        }
        else{

            holder = (ViewHolder)vi.getTag();
        }



        holder.tvRank.setText(thismos.getMOS_NAME());
        holder.tvPay.setText(thismos.getMOS_NUMBER());
        holder.tvDetail.setText(thismos.getMOS_RANK());
        if (thismos.getMOS_LINK() != null) {
            holder.tvLink.setText("Click here for more details");

        }
        // Setting all values in listview

        holder.tvLink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thismos.getMOS_LINK()));
                    _context.startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(_context, "No application can handle this request,"
                            + " Please install a webbrowser", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });



        return vi;



    }





    public static class ViewHolder{

        TextView tvRank;
        TextView tvshort;
        TextView tvPay;
        TextView tvDetail;
        TextView tvLink;

        ImageView tvRankImage;
    }

}
