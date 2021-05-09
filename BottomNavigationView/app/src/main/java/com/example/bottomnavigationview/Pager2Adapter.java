package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class Pager2Adapter extends FragmentStateAdapter {
    List<Fragment> list;
    // 初始化
    public Pager2Adapter(@NonNull FragmentActivity fragmentActivity,List<Fragment> fragmentList) {
        super(fragmentActivity);
        this.list = fragmentList;
    }
    // Viewpager2 的新用法 ， 不是很懂
    public static Pager2Adapter start(FragmentActivity fragmentActivity, List<Fragment> fragments) {
        return new Pager2Adapter(fragmentActivity, fragments);
    }


    @NonNull
    @Override
    // 返回要返回(Fragment)list.get(position) ， 作用不是很懂
    public Fragment createFragment(int position) {
        return (Fragment)list.get(position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
