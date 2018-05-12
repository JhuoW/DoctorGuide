package com.xzmc.zzzt.doctorguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.xzmc.zzzt.doctorguide.SweetAlert.SweetAlertDialog;
import com.xzmc.zzzt.doctorguide.keshiActivity.HuXiActivity;


/**
 * Created by zw on 17/6/12.
 */

public class ZhengZhuangDetailActivity extends TopBarBaseActivity implements View.OnClickListener{
    Intent intent;
    String str;
    String zz;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected int getConentView() {
        return R.layout.activity_zhuangzhaungdetail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("挂号");
    }

    @Override
    public void initView() {
        intent = getIntent();
        str = intent.getStringExtra("zz");
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
       // Toast.makeText(ZhengZhuangDetailActivity.this,str, Toast.LENGTH_SHORT).sh);
        if(str.equals("肚子痛")){
            zz="内科";
        }else
        if(str.equals("腹肌抽搐")){
            zz="神经内科";
        }else
        if(str.equals("毛发增多")){
            zz="内分泌科";
        }else
        if(str.equals("胸闷气短")){
            zz="心内科";
        }else
        if(str.equals("扁桃体发炎")){
            zz="呼吸内科";
        }else
        if(str.equals("肾痛")){
            zz="肾内科";
        }else
        if(str.equals("腹泻")){
            zz="消化内科";
        }
        if(str.equals("类风湿性关节炎")){
            zz="风湿免疫科";
        }else
        if(str.equals("恶性贫血")){
            zz="血液科";
        }else
        if(str.equals("感染性发热")){
            zz="感染科";
        }
        if(str.equals("关节扭伤")){
            zz="骨外科";
        }else
        if(str.equals("头晕呕吐")){
            zz="神经外科";
        }

        toolbar.setTitle(zz);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initAction() {

    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.logout).setVisible(false);   //设置是否显示menu
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn1) {
            new SweetAlertDialog(this).setTitleText("挂号")
                    .setContentText("是否挂号医生一？").setCancelText("取消")
                    .setConfirmText("确定").showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(
                                SweetAlertDialog sweetAlertDialog) {

                            sweetAlertDialog.dismiss();
                            new SweetAlertDialog(ZhengZhuangDetailActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                    .showCancelButton(false).setTitleText("挂号成功").setConfirmText("确定")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(
                        SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismiss();
                }
            }).show();
        }

        if (v.getId() == R.id.btn2) {
            new SweetAlertDialog(this).setTitleText("挂号")
                    .setContentText("是否挂号医生二？").setCancelText("取消")
                    .setConfirmText("确定").showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(
                                SweetAlertDialog sweetAlertDialog) {

                            sweetAlertDialog.dismiss();
                            new SweetAlertDialog(ZhengZhuangDetailActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                    .showCancelButton(false).setTitleText("挂号成功").setConfirmText("确定")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(
                        SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismiss();
                }
            }).show();
        }
        if (v.getId() == R.id.btn3) {
            new SweetAlertDialog(this).setTitleText("挂号")
                    .setContentText("是否挂号医生三？").setCancelText("取消")
                    .setConfirmText("确定").showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(
                                SweetAlertDialog sweetAlertDialog) {

                            sweetAlertDialog.dismiss();
                            new SweetAlertDialog(ZhengZhuangDetailActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                    .showCancelButton(false).setTitleText("挂号成功").setConfirmText("确定")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(
                        SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismiss();
                }
            }).show();
        }
        if (v.getId() == R.id.btn4) {
            new SweetAlertDialog(this).setTitleText("挂号")
                    .setContentText("是否挂号医生四？").setCancelText("取消")
                    .setConfirmText("确定").showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(
                                SweetAlertDialog sweetAlertDialog) {

                            sweetAlertDialog.dismiss();
                            new SweetAlertDialog(ZhengZhuangDetailActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                    .showCancelButton(false).setTitleText("挂号成功").setConfirmText("确定")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(
                        SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismiss();
                }
            }).show();
        }
    }
}
