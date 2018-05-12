package com.xzmc.zzzt.doctorguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xzmc.zzzt.doctorguide.SweetAlert.SweetAlertDialog;
import com.xzmc.zzzt.doctorguide.db.PreferenceMap;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by aiyang on 2017/6/1.
 */

public abstract class TopBarBaseActivity extends AppCompatActivity {
    TextView tvTitle;
    FrameLayout viewContent;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置不现实自带的title文字
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.back_whait);

        //将继承TopBarBaseActivity 的布局解析到 FrameLayout 里面
        viewContent= (FrameLayout) findViewById(R.id.viewContent);
        LayoutInflater.from(this).inflate(getConentView(),viewContent);
        tvTitle= (TextView) findViewById(R.id.tv_title);


        init(savedInstanceState);//放在以上方法的最后位置
        initView();
        initData();
        initAction();

    }

    protected void setTitle(String title){
        if (!TextUtils.isEmpty(title)){
            tvTitle.setText(title);
        }
    }
    protected abstract  int getConentView();

    protected abstract void init(Bundle savedInstanceState);

    protected void setTopRightButton(String menuStr,int menuResId,OnClickRightListener onClickListener){
        this.onClickRightListener = onClickListener;
        this.menuStr=menuStr;
        this.menuResId=menuResId;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        if (item.getItemId() == R.id.settings){
            Toast.makeText(this,"You Are Right",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.logout){
            new SweetAlertDialog(this).setTitleText("注销登录")
                    .setContentText("确定退出此帐号？").setCancelText("取消退出")
                    .setConfirmText("确定退出").showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(
                                SweetAlertDialog sweetAlertDialog) {

                            new PreferenceMap(getApplicationContext()).setIsLogin(false);
                            sweetAlertDialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(
                        SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismiss();
                }
            }).show();
        }
        return true;//告诉系统 我们自己处理事件
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuResId !=0|| !TextUtils.isEmpty(menuStr)){ //可以在这里做隐藏标题右菜单显示
           getMenuInflater().inflate(R.menu.toobar,menu);
        }else{
            getMenuInflater().inflate(R.menu.toobar,menu);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {//选择性显示 图标 或 文字
        if (menuResId != 0){
            menu.findItem(R.id.settings).setIcon(menuResId);
        }
        if (!TextUtils.isEmpty(menuStr)){
            menu.findItem(R.id.settings).setTitle(menuStr);
        }
        menu.findItem(R.id.settings).setVisible(false);   //设置是否显示menu
        return super.onPrepareOptionsMenu(menu);
    }
    String menuStr;
    int menuResId;
    OnClickRightListener onClickRightListener;
    public interface  OnClickRightListener{
        void onClick();
    }
    public abstract void initView();

    public abstract void initData();

    public abstract void initAction();

}
