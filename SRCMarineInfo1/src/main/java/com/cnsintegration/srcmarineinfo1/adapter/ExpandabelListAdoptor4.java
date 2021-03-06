package com.cnsintegration.srcmarineinfo1.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsintegration.srcmarineinfo1.R;
import com.cnsintegration.srcmarineinfo1.model.Ack;
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.MTitles;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/9/2014.
 */
public class ExpandabelListAdoptor4 extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, Ack> _listDataChild;




    ViewHolder holder;
    LayoutInflater inflater;
    static int position;


    public ExpandabelListAdoptor4(Context con, List<String> listDataHeader, HashMap<String, Ack> listDataChild) {
        this._context = con;
        //branchesDataCollection = listDataChild;
        this._listDataChild = listDataChild;
        this._listDataHeader = listDataHeader;

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition));


    }


    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        final Ack ack = (Ack) getChild(groupPosition, childPosition);


        View vi = convertView;
        if (convertView == null) {
            inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.ack_view, null);
            holder = new ViewHolder();

            holder.ack_tx = (TextView) vi.findViewById(R.id.ack); // city name
            holder.ackname_tx = (TextView) vi.findViewById(R.id.ackname); // city name
            holder.ackdetails_tx = (TextView) vi.findViewById(R.id.ackdetails); // city name
            holder.ack_image_im = (ImageView) vi.findViewById(R.id.ack_image);


            vi.setTag(holder);
        } else {

            holder = (ViewHolder) vi.getTag();
        }

        // Setting all values in listview




        holder.ack_tx.setText(ack.getAck());
        holder.ackname_tx.setText(ack.getAck_name());
        holder.ackdetails_tx.setText(ack.getAck_details());
       // if (mos.getMOS_LINK() != null) {
         //   holder.tvLink.setText("Click here for more details");

        //}
        //holder.tvRank.setTextColor(Color.WHITE);
        //holder.tvPay.setTextColor(Color.WHITE);

        //Setting an image
        String uri = "drawable/"+ ack.getAck_icon();
        int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
        Drawable image = vi.getContext().getResources().getDrawable(imageResource);
        holder.ack_image_im.setImageDrawable(image);

        return vi;


    }


    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub


        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);

        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        //Setting an image
/**
 String iconname = lblListHeader.toString().toLowerCase();
 String uri = "drawable/usmc";
 int imageResource = _context.getResources().getIdentifier(uri, null, _context.getPackageName());
 Drawable image = _context.getResources().getDrawable(imageResource);

 holder.tvRankImage =(ImageView)convertView.findViewById(R.id.rank_image);
 ImageView groupimg =  holder.tvRankImage.setImageDrawable(image);
 **/


        return convertView;
    }


    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

    public static class ViewHolder {

        TextView ack_tx;
        TextView ackname_tx;
        TextView ackdetails_tx;
        ImageView ack_image_im;


    }
}