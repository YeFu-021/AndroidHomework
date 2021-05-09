package com.example.bottomnavigationview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClassifyFragment extends Fragment {

    List<item> itemList = new ArrayList<>();

    // RecyclerView的初始化 要放在onStart中！！！！！！！！
    @Override
    public void onStart() {
        super.onStart();
        // 初始化item列表
        for (int i = 0 ;i<10 ;i++) {
            itemList.add(new item("待办事项", R.drawable.ic_daibanshixiang));
            itemList.add(new item("定期工作", R.drawable.ic_dingqigongzuo));
        }
        // 初始化recyclerView
        RecyclerView recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view);
        RVadapter rVadapter = new RVadapter(itemList);
        recyclerView.setAdapter(rVadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classify,container,false);//这里绑定的是原本fragment的layoutID，意味着要在这上面显示组件
        return view;
    }
}
