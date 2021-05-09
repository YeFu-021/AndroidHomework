package com.example.bottomnavigationview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVadapter extends RecyclerView.Adapter<RVadapter.ViewHolder>{
    private List<item> classify_itemList;

    public RVadapter(List<item> itemList) {
        classify_itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 这里绑定的是classifyitem的layoutID，表示我RecyclerView的中的物体显示成classifyitem里面的样式
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classifyitem,parent,false);

        final ViewHolder holder = new ViewHolder(view);
        // 设置点击监听（可有可无）, 作业无要求，可删
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                item item = classify_itemList.get(position);
                Toast.makeText(view.getContext(),item.getName(),Toast.LENGTH_SHORT).show();            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                item item = classify_itemList.get(position);
                Toast.makeText(view.getContext(),item.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //将物体显示在RecyclerView上
        item classifyitem = classify_itemList.get(position);
        holder.image.setImageResource(classifyitem.getImage());
        holder.name.setText(classifyitem.getName());
    }

    @Override
    public int getItemCount() {
        return classify_itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        // 我感觉ViewHolder有点类似配置,声明出所要的几个属性,进行初始化
        ImageView image;
        TextView name;
        View clickView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clickView = itemView;
            image = (ImageView)itemView.findViewById(R.id.classify_item);
            name = (TextView)itemView.findViewById(R.id.classify_name);
        }
    }

//    private Context context;
//
//    public RVadapter(Context context) {
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//
//
//
//
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = View.inflate(context,R.layout.item,null);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        item item = itemList.get(position);
//        holder.itemImage.setImageDrawable(item.getDrawable());
//        holder.itemName.setText(item.getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemList.size();
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView itemImage;
//        TextView itemName;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            itemImage = itemView.findViewById(R.id.imageView);
//            itemName = itemView.findViewById(R.id.textView);
//        }
//    }

}
