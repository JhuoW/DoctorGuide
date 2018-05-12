package com.xzmc.zzzt.doctorguide.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.xzmc.zzzt.doctorguide.bean.User;

import static android.os.Build.ID;


/**
 * Created by zw on 17/6/11.
 */

public class PreferenceMap {
    public static final String NAME = "name";
    public static final String SEX = "sex";
    public static final String PHONE="phone";
    public static final String PASSWORD="password";
    public static final String EMAIL="email";
    public static final String ISLOGIN = "islogin";

    Context ctx;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    public static PreferenceMap currentUserPreferenceMap;
    public PreferenceMap(Context ctx) {
        this.ctx = ctx;
        pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();
    }

    public PreferenceMap(Context ctx, String prefName) {
        this.ctx = ctx;
        pref = ctx.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setUser(User user) {
        editor.putString(NAME, user.getName()).commit();
        editor.putString(SEX, user.getSex()).commit();
        editor.putString(PHONE, user.getPhone()).commit();
        editor.putString(PASSWORD, user.getPassword()).commit();
        editor.putString(EMAIL, user.getEmail()).commit();
    }

    public User getUser() {
        User user = new User();
        user.setName(pref.getString(NAME, ""));
        user.setSex(pref.getString(SEX, ""));
        user.setPhone(pref.getString(PHONE, ""));
        user.setPassword(pref.getString(PASSWORD, ""));
        user.setEmail(pref.getString(EMAIL, ""));
        return user;
    }

    public boolean isLogin() {
        return pref.getBoolean(ISLOGIN, false);
    }

    public void setIsLogin(Boolean flag) {
        editor.putBoolean(ISLOGIN, flag).commit();
    }
}
