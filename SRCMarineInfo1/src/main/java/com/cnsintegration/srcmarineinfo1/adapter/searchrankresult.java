package com.cnsintegration.srcmarineinfo1.adapter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cnsintegration.srcmarineinfo1.Database.DataBaseWrapper;
import com.cnsintegration.srcmarineinfo1.R;
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.MTitles;
import com.cnsintegration.srcmarineinfo1.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/29/2014.
 */
public class searchrankresult extends BaseAdapter  {

    LayoutInflater inflater;
    ImageView thumb_image;
    List<HashMap<String,String>> branchDataCollection;
    ViewHolder holder;


    List tmos = new ArrayList();
    private Context _context;


    public searchrankresult(Context con, List Rank) {
        this._context=con;
        tmos = Rank;

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

        final Rank thisrank = (Rank) tmos.get(position);
        if(convertView==null){
            inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.view_rank2, null);
            holder = new ViewHolder();



            holder.tvRank = (TextView)vi.findViewById(R.id.rankname); // rank
            holder.tvshort = (TextView)vi.findViewById(R.id.rankshort); // rank short name
            holder.tvPay = (TextView)vi.findViewById(R.id.rankpay); // city name
            holder.tvDetail = (TextView)vi.findViewById(R.id.rankdetails); // city name
            holder.tvLink = (TextView)vi.findViewById(R.id.ranklink); // city name
            holder.tvRankImage = (ImageView)vi.findViewById(R.id.rankicon);
            holder.tvBranch = (TextView)vi.findViewById(R.id.rankbranch); // city name
            vi.setTag(holder);
        }
        else{

            holder = (ViewHolder)vi.getTag();
        }


        holder.tvRank.setText(thisrank.getName());

        holder.tvPay.setText(thisrank.getRank_PAY());

        holder.tvshort.setText(thisrank.getShortName());

        holder.tvDetail.setText(thisrank.getRank_DETAILS());
        //get branch text
        DataBaseWrapper dbHelper;

        SQLiteDatabase database;
        Activity act = (Activity) this._context;



        dbHelper = new DataBaseWrapper(act);

        database = dbHelper.getWritableDatabase();
        String[] Branch_TABLE_COLUMNS = {DataBaseWrapper.Branch_ID, DataBaseWrapper.Branch_NAME};


        Cursor cursor = database.query(DataBaseWrapper.Branch, Branch_TABLE_COLUMNS, "branch_id = '" + thisrank.getRank_Branch() + "'", null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            //cursor.getString(1);
            holder.tvBranch.setText(cursor.getString(1));
            cursor.moveToNext();
        }

        cursor.close();



/**
        if(thisrank.getRank_Branch() ==  1){
            holder.tvBranch.setText("US Marines");
        }
        if(thisrank.getRank_Branch() ==  2){
            holder.tvBranch.setText("US Air Force");
        }

        if(thisrank.getRank_Branch() ==  3){
            holder.tvBranch.setText("US Air Force");
        }
**/
        dbHelper.close();

        holder.tvLink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thisrank.getRank_LINK()));
                    _context.startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(_context, "No application can handle this request,"
                            + " Please install a webbrowser", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        //holder.tvRank.setTextColor(Color.WHITE);
        //holder.tvPay.setTextColor(Color.WHITE);


        //Setting an image
        String uri = "drawable/"+ thisrank.getIcon();
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
        TextView tvBranch;
        TextView tvLink;

        ImageView tvRankImage;
    }

}
