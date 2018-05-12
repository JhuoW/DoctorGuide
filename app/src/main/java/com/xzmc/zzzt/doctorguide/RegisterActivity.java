package com.xzmc.zzzt.doctorguide;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xzmc.zzzt.doctorguide.SweetAlert.SweetAlertDialog;
import com.xzmc.zzzt.doctorguide.bean.User;
import com.xzmc.zzzt.doctorguide.db.DBHelper;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by zw on 17/6/10.
 */

public class RegisterActivity extends TopBarBaseActivity {
    private Toolbar mToolbar;
    private EditText et_name;
    private RadioGroup sexGroup;
    private EditText et_phone;
    private EditText et_password;
    private EditText et_mail;
    private Button btn_register;
    private DBHelper dbHelper;
    String name,sex,phone,password,mail;
    ProgressDialog dialog;

    @Override
    protected int getConentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("注册");

    }

    @Override
    public void initView() {
        dbHelper = new DBHelper(this);
        dialog = new ProgressDialog(RegisterActivity.this);
        dialog.setCanceledOnTouchOutside(false);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);
        et_mail = (EditText) findViewById(R.id.et_mail);
        sexGroup = (RadioGroup) findViewById(R.id.sexGroup);
        btn_register = (Button) findViewById(R.id.btn_register);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initAction() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etToStr();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(sex)||
                        TextUtils.isEmpty(phone)||
                        TextUtils.isEmpty(password)||TextUtils.isEmpty(mail)){
                    Toast.makeText(RegisterActivity.this,"注册信息不全",Toast.LENGTH_SHORT).show();
                    return;
                }
                User user2 = new User();
                user2 = dbHelper.queryUser(phone);
                if(!TextUtils.isEmpty(user2.getPassword())){
                    Toast.makeText(RegisterActivity.this,"该号码已经注册",Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User();
                user.setName(name);
                user.setSex(sex);
                user.setPhone(phone);
                user.setPassword(password);
                user.setEmail(mail);
                dbHelper.insertUsers(user);
                new SweetAlertDialog(RegisterActivity.this,SweetAlertDialog.SUCCESS_TYPE).
                        showCancelButton(false).setConfirmText("确定").setTitleText("注册成功")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                                RegisterActivity.this.finish();
                            }
                        }).show();

            }
        });
    }

    private void etToStr(){
        name = et_name.getText().toString();
        phone = et_phone.getText().toString();
        password= et_password.getText().toString();
        mail=et_mail.getText().toString();
        int id = sexGroup.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)RegisterActivity.this.findViewById(id);
        sex=rb.getText().toString();

//        sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//
//                int radioButtonId = group.getCheckedRadioButtonId();
//                RadioButton rb = (RadioButton)RegisterActivity.this.findViewById(radioButtonId);
//                sex=rb.getText().toString();
//            }
//        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.settings).setVisible(false);
        menu.findItem(R.id.logout).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }
}

