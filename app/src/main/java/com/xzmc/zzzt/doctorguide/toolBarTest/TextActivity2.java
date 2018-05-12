package com.xzmc.zzzt.doctorguide.toolBarTest;

import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.xzmc.zzzt.doctorguide.BaseAppCompatActivity;
import com.xzmc.zzzt.doctorguide.R;

/**
 * Created by zw on 17/6/13.
 */

public class TextActivity2 extends BaseAppCompatActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {
        getToolbarTitle().setText("测试页面2");
        getSubTitle().setVisibility(View.VISIBLE);
        getSubTitle().setText("菜单");
        getSubTitle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TextActivity2.this, "菜单", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAction() {

    }
}
