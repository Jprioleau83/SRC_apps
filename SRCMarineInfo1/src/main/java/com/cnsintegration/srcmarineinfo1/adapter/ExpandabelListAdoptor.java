package com.cnsintegration.srcmarineinfo1.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsintegration.srcmarineinfo1.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jprioleau on 4/9/2014.
 */
public class ExpandabelListAdoptor extends BaseExpandableListAdapter
{

    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, List<HashMap<String, String>>> _listDataChild;
    List<HashMap<String, String>> branchesDataCollection;
    static final String KEY_TAG = "rankdata"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_PAY = "payscale";
    static final String KEY_NAME = "name";
    static final String KEY_ICON = "icon";
    static final String KEY_DETAILS = "details";
    ViewHolder holder;
    LayoutInflater inflater;


    public ExpandabelListAdoptor(Context con,List<String> listDataHeader ,HashMap<String, List<HashMap<String, String>>> listDataChild )
    {
        this._context=con;
        //branchesDataCollection = listDataChild;
        this._listDataChild=listDataChild;
        this._listDataHeader=listDataHeader;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
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

        final HashMap<String, String> branchDataCollection1 = (HashMap<String, String>) getChild(groupPosition, childPosition);



        View vi=convertView;
        if(convertView==null){
            inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.rank_view, null);
            holder = new ViewHolder();

            holder.tvRank = (TextView)vi.findViewById(R.id.rank); // city name
            holder.tvPay = (TextView)vi.findViewById(R.id.payscale); // city name
            holder.tvDetail = (TextView)vi.findViewById(R.id.rank_details); // city name

            holder.tvRankImage =(ImageView)vi.findViewById(R.id.rank_image); // thumb image

            vi.setTag(holder);
        }
        else{

            holder = (ViewHolder)vi.getTag();
        }

        // Setting all values in listview

        holder.tvRank.setText(branchDataCollection1.get(KEY_NAME));
        holder.tvPay.setText(branchDataCollection1.get(KEY_PAY));
        holder.tvDetail.setText(branchDataCollection1.get(KEY_DETAILS));
        //holder.tvRank.setTextColor(Color.WHITE);
        //holder.tvPay.setTextColor(Color.WHITE);


        //Setting an image
        String uri = "drawable/"+ branchDataCollection1.get(KEY_ICON);
        int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
        Drawable image = vi.getContext().getResources().getDrawable(imageResource);
        holder.tvRankImage.setImageDrawable(image);



        return vi;










    }



    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
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
    public static class ViewHolder{

        TextView tvRank;
        TextView tvPay;
        TextView tvDetail;
        ImageView tvRankImage;
    }
}