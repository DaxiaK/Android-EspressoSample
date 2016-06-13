package com.daxia.espressosample.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.daxia.espressosample.R;

import java.util.List;

/**
 * Created by daxia on 2016/6/8.
 */
public class SuperheroListAdapter extends BaseAdapter {


    private List<SuperheroListEntity> galleryList;
    private LayoutInflater mInflater;


    public SuperheroListAdapter(Context context, List galleryList) {
        this.galleryList = galleryList;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return galleryList.size();
    }

    @Override
    public Object getItem(int position) {
        return galleryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.listview_gallery_item, parent, false);
            holder.TV_gallery_name = (TextView) convertView.findViewById(R.id.TV_gallery_name);
            holder.TV_gallery_path = (TextView) convertView.findViewById(R.id.TV_gallery_path);
            holder.But_gallery_delete = (Button) convertView.findViewById(R.id.But_gallery_delete);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.TV_gallery_name.setText(galleryList.get(position).getName());
        holder.TV_gallery_path.setText(galleryList.get(position).getPath());
        holder.But_gallery_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryList.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    public class ViewHolder {
        private TextView TV_gallery_name, TV_gallery_path;
        private Button But_gallery_delete;
    }

}
