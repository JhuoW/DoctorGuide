package com.xzmc.zzzt.doctorguide;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xzmc.zzzt.doctorguide.Utils.Utils;
import com.xzmc.zzzt.doctorguide.bean.User;
import com.xzmc.zzzt.doctorguide.db.DBHelper;
import com.xzmc.zzzt.doctorguide.db.PreferenceMap;

/**
 * Created by zw on 17/6/10.
 */

public class LoginActivity extends Activity{
    private EditText usernameEdit, passwordEdit;
    private Button loginBtn;
    private TextView registerBtn;
    ProgressDialog dialog;
    private String account, password;
    DBHelper dbHelpler;
    User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initAction();
    }


    private void initView(){
        dbHelpler =new DBHelper(this);
        dialog = new ProgressDialog(LoginActivity.this);
        dialog.setCanceledOnTouchOutside(false);
        usernameEdit = (EditText) findViewById(R.id.et_username);
        passwordEdit = (EditText) findViewById(R.id.et_password);
        loginBtn = (Button) findViewById(R.id.btn_login);
        registerBtn = (TextView) findViewById(R.id.btn_register);
    }

    private void initAction(){
        // 如果用户名改变，清空密码
        usernameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                passwordEdit.setText(null);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.goActivity(LoginActivity.this,RegisterActivity.class);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = usernameEdit.getText().toString().trim();
                password = passwordEdit.getText().toString().trim();
                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }


                user = dbHelpler.queryUser(account);
                if(!dbHelpler.ifPhoneHasRegister(account)){
                    Toast.makeText(LoginActivity.this,"该号码尚未注册",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.equals(user.getPassword())){
                    new PreferenceMap(LoginActivity.this).setUser(user);
                    new PreferenceMap(LoginActivity.this).setIsLogin(true);
                    Utils.goActivity(LoginActivity.this,MainActivity.class);
                }else
                {
                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
