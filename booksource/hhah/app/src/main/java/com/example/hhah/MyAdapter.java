package com.example.hhah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Bean> list = new ArrayList<Bean>();
    private LayoutInflater inflator;
    private int resore;
    private TextView t_name;
    private TextView t_place;
    private TextView time;

    public MyAdapter(Context context, ArrayList<Bean> list, int resore) {

        this.context = context;
        this.list = list;
        this.resore = resore;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(resore, null);
            t_name = (TextView) convertView.findViewById(R.id.tv_name);
            t_place = (TextView) convertView.findViewById(R.id.tv_place);
            time = (TextView) convertView.findViewById(R.id.tv_time);
        }
        Bean bean = list.get(position);
        t_name.setText(bean.getT_name());
        t_place.setText(bean.getT_place());
        time.setText(bean.getTime());
        return convertView;
    }

}