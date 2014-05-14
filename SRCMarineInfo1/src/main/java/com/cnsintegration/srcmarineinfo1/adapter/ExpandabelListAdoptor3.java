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
import com.cnsintegration.srcmarineinfo1.model.MOS;
import com.cnsintegration.srcmarineinfo1.model.MTitles;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jprioleau on 4/9/2014.
 */
public class ExpandabelListAdoptor3 extends BaseExpandableListAdapter {

    private Context _context;
    private List<MTitles> _listDataHeader;
    private HashMap<String, List<MOS>> _listDataChild;
    List<HashMap<String, String>> branchesDataCollection;
    static final String KEY_TAG = "rankdata"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_ICON = "icon";
    static final String KEY_DETAILS = "details";
    ViewHolder holder;
    LayoutInflater inflater;
    static int position;


    public ExpandabelListAdoptor3(Context con, List<MTitles> listDataHeader, HashMap<String, List<MOS>> listDataChild, int position) {
        this._context = con;
        //branchesDataCollection = listDataChild;
        this._listDataChild = listDataChild;
        this._listDataHeader = listDataHeader;
        this.position = position;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition).getMOS_TITLES_TITLE())
                .get(childPosititon);


    }


    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        final MOS mos = (MOS) getChild(groupPosition, childPosition);


        View vi = convertView;
        if (convertView == null) {
            inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.mos_view, null);
            holder = new ViewHolder();

            holder.tvRank = (TextView) vi.findViewById(R.id.rank); // city name
            holder.tvPay = (TextView) vi.findViewById(R.id.payscale); // city name
            holder.tvDetail = (TextView) vi.findViewById(R.id.rank_details); // city name
            holder.tvLink = (TextView) vi.findViewById(R.id.mos_link); // city name


            vi.setTag(holder);
        } else {

            holder = (ViewHolder) vi.getTag();
        }

        // Setting all values in listview

        if (position == 2) {
            holder.tvLabel = (TextView) vi.findViewById(R.id.mos_label);
            holder.tvLabel.setText("AFSC");
        }


        holder.tvRank.setText(mos.getMOS_NAME());
        holder.tvPay.setText(mos.getMOS_NUMBER());
        holder.tvDetail.setText(mos.getMOS_RANK());
        if (mos.getMOS_LINK() != null) {
            holder.tvLink.setText("Click here for more details");

        }
        //holder.tvRank.setTextColor(Color.WHITE);
        //holder.tvPay.setTextColor(Color.WHITE);


        return vi;


    }


    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition).getMOS_TITLES_TITLE())
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub


        return this._listDataHeader.get(groupPosition).getMOS_TITLES_TITLE();
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

        TextView tvRank;
        TextView tvPay;
        TextView tvDetail;
        TextView tvLink;
        TextView tvLabel;

    }
}