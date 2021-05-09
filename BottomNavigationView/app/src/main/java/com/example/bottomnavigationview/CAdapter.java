package com.example.bottomnavigationview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
    fragment3中ListView的适配器
 */
public class CAdapter extends BaseAdapter {

    private List<commodity> clist = new ArrayList<>();
    private CartFragment context;// 因为是显示在fragment中的，所以这边是CartFragment
    // 初始化
    public CAdapter(List<commodity> clist , CartFragment context) {
        this.clist = clist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clist.size();
    }

    @Override
    public Object getItem(int i) {
        return clist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        //为什么要写成下面这种形式 ， convertView的含义是什么
        if(convertView == null){
            viewHolder = new ViewHolder();
            //
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.commodity_layout,null);


            viewHolder.cListViewText = convertView.findViewById(R.id.cListViewText);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        // 获取commodity物体名，显示在控件上
        String name = clist.get(i).getCommodity_name();
        viewHolder.cListViewText.setText(name);


        return convertView;
    }

    // 这边展现的更清楚，ViewHolder有点类似配置
    public static class ViewHolder{
        public TextView cListViewText;
    }
}
