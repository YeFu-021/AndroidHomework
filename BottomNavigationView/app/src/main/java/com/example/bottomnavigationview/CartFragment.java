package com.example.bottomnavigationview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
/*
    要用到cart.xml 和 commodity_layout.xml
    cart.xml 是fragment的布局文件，设置成啥样，运行时就显现啥样
    commodity_layout.xml 是listview里的每行的布局
 */

public class CartFragment extends Fragment {

    private ListView cListView;
    private TextView contentText;
    private List<commodity> cList = new ArrayList<>();// 新建类commodity在这使用

    @Override
    public void onStart() {
        super.onStart();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart,container,false);
        // 初始化控件
        cListView = (ListView) view.findViewById(R.id.cListView);
        contentText = (TextView)view.findViewById(R.id.cText);
        // 向cList中添加数据
        for (int i = 0; i < 10; i++) {
            cList.add(new commodity("物品"+i,"这是物品"+i));
        }
        // 刚打开显示的是cList[0]的内容
        contentText.setText(cList.get(0).getCommodity_content());
        //设置配置器CAdapter  cList:是ListView中要显示的物体  context:是要显示在哪里
        cListView.setAdapter(new CAdapter(cList,this));

        //设置点击事件
        //思路 ： 根据点击的item不同 ，通过setText去改变右边文本框的内容
        cListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i参数 ，就表示你点击的是哪行
                String content = cList.get(i).getCommodity_content();
                contentText.setText(content);
            }
        });

        return view;
    }

//    private void initView(){
//        cListView = (ListView)getView().findViewById(R.id.cListView);
//        cFrame = (FrameLayout)getView().findViewById(R.id.cFrame);
//    }
//
//    private void initDate(){
//        //左边listView集合添加数据，适配器适配
//        listViewData();
//        //添加fragment,复用fragment
//        addFragment();
//        //默认选中ListView第一条item
//        replese(0);
//        //ListView第一条item的Select为true
//        cList.get(0).setSelect(true);
//        //listView点击事件
//        cListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //切换fragment
//                replese(i);
//                //在bean类里写的一个标记 boolean类型的isSelect是关键，默认无状态， 并设置get set方法
//                //集合里所有数据的Select设置为flase,position下标所对应的item的Select为true，刷新适配器。
//                for (int j = 0; j <cList.size() ; j++) {
//                    cList.get(j).setSelect(false);
//                }
//                cList.get(i).setSelect(true);
//                //在刷新一下适配器就ok
//                adapter.notifyDataSetChanged();
//            }
//        });
//
//    }
//
//    /*
//     * 方法名： listViewData()
//     * 功    能：左边listView集合添加数据
//     * 参    数：无
//     * 返回值：无
//     */
//    private void listViewData() {
//        for (int i = 0; i < 10; i++) {
//            cList.add(new commodity("物品"+i,"这是物品"+i));
//        }
//        //适配器适配
//        adapter = new CAdapter(cList, this);
//        cListView.setAdapter(adapter);
//    }
//    /*
//     * 方法名：addFragment()
//     * 功    能：添加fragment,复用fragment
//     * 参    数：无
//     * 返回值：无
//     */
//    private void addFragment() {
//        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
//        MultiplexingFragment multiplexingFragment = new MultiplexingFragment();
//        for (int i = 0; i < cList.size(); i++) {
//            Fragment multiplexing = multiplexingFragment.getMultiplexing(cList.get(i).getCommodity_name(), "");
//            cFragmentList.add(multiplexing);
//        }
//        //添加fragment
//        for (int i = 0; i < cFragmentList.size(); i++) {
//            transaction.add(R.id.cFrame, cFragmentList.get(i));
//        }
//        transaction.commit();
//    }
//
//
//    /*
//     * 方法名：replese(int position)
//     * 功    能：根据点击事件的下标切换fragment页面
//     * 参    数：int position
//     * 返回值：无
//     */
//    private void replese(int position) {
//        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
//        //所有的fragment隐藏，position对应的fragment显示，提交。
//        for (int i = 0; i < cFragmentList.size(); i++) {
//            Fragment fragment = cFragmentList.get(i);
//            transaction.hide(fragment);
//        }
//        transaction.show(cFragmentList.get(position)).commit();
//    }



}
