package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;// 底部导航栏
    MenuItem menuItem;// 导航栏物体
    ViewPager2 pager2;// Viewpager2 的声明
    List<Fragment> list;// viewPager2 内部的Fragment的列表，表示viewpager要用到哪些Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化
        pager2 = (ViewPager2)findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.ButtomNavigationView);

        // 隐藏系统标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        //初始化列表list
        list = new ArrayList<Fragment>();
        list.add(new HomepageFragment());
        list.add(new ClassifyFragment());
        list.add(new CartFragment());
        list.add(new MyFragment());

        // 配置适配器
        pager2.setAdapter(Pager2Adapter.start(this,list));
        pager2.setOffscreenPageLimit(1);


        // 实现功能：点击BottomNavigationView按钮实现转界面转换
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.homepage:
                                pager2.setCurrentItem(0);
                                break;
                            case R.id.classify:
                                pager2.setCurrentItem(1);
                                break;
                            case R.id.cart:
                                pager2.setCurrentItem(2);
                                break;
                            case R.id.my:
                                pager2.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                }
        );

        // 实现功能：当前fragment和导航栏一致
        // viewpager2中用这个监听界面切换事件 registerOnPageChangeCallback
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(menuItem==null){
                    menuItem=bottomNavigationView.getMenu().getItem(0);
                }
                //将上次的选择设置为false，等待下次的选择
                menuItem.setChecked(false);
                menuItem=bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}