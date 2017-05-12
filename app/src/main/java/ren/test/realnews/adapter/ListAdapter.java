package ren.test.realnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ren.test.realnews.R;
import ren.test.realnews.beans.Data;

/**
 * Created by Administrator on 2017/5/12
 */

public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Data> data;

    public ListAdapter(Context context, List<Data> data) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Data getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.thumImage = (ImageView) convertView.findViewById(R.id.image_thum);
            viewHolder.tittle = (TextView) convertView.findViewById(R.id.text_tittle);
            viewHolder.date = (TextView) convertView.findViewById(R.id.text_date);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        Glide.with(mContext).load(getItem(position).getThumbnail_pic_s()).error(R.mipmap.ic_launcher).into(viewHolder.thumImage);
        viewHolder.tittle.setText(getItem(position).getTitle());
        viewHolder.date.setText(getItem(position).getDate());
        return convertView;
    }

    private class ViewHolder {
        ImageView thumImage;
        TextView tittle, date;
    }
}
