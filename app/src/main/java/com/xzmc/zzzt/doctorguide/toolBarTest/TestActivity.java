package com.xzmc.zzzt.doctorguide.toolBarTest;


import android.view.View;
import android.widget.Button;

import com.xzmc.zzzt.doctorguide.BaseAppCompatActivity;
import com.xzmc.zzzt.doctorguide.R;
import com.xzmc.zzzt.doctorguide.Utils.Utils;

import junit.framework.Test;

/**
 * Created by zw on 17/6/13.
 */

public class TestActivity extends BaseAppCompatActivity {

    private Button btn;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;

    }


    @Override
    public void initView() {
        getToolbarTitle().setText("主页面");
        //不显示右侧按钮
        btn = (Button) findViewById(R.id.button);
    }

    //不显示返回按钮
    @Override
    protected boolean isShowBacking() {
        return false;
    }


    @Override
    public void initData() {

    }

    @Override
    public void initAction() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.goActivity(TestActivity.this,TextActivity2.class);
            }
        });
    }
}
