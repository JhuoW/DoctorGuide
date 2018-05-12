package com.xzmc.zzzt.doctorguide.keshiActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.xzmc.zzzt.doctorguide.R;
import com.xzmc.zzzt.doctorguide.SweetAlert.SweetAlertDialog;
import com.xzmc.zzzt.doctorguide.TopBarBaseActivity;

/**
 * Created by zw on 17/6/11.
 */

public class HuXiActivity extends TopBarBaseActivity implements View.OnClickListener{
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected int getConentView() {
        return R.layout.activity_huxi;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("呼吸内科");
    }

    @Override
    public void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAction() {

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
                            new SweetAlertDialog(HuXiActivity.this, SweetAlertDialog.SUCCESS_TYPE)
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
                            new SweetAlertDialog(HuXiActivity.this, SweetAlertDialog.SUCCESS_TYPE)
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
                            new SweetAlertDialog(HuXiActivity.this, SweetAlertDialog.SUCCESS_TYPE)
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
                            new SweetAlertDialog(HuXiActivity.this, SweetAlertDialog.SUCCESS_TYPE)
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
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.logout).setVisible(false);   //设置是否显示menu
        return super.onPrepareOptionsMenu(menu);
    }
}
