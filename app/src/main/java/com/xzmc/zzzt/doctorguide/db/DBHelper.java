package com.xzmc.zzzt.doctorguide.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.xzmc.zzzt.doctorguide.bean.User;

/**
 * Created by zw on 17/6/11.
 */

public class DBHelper extends SQLiteOpenHelper{
    private static SQLiteDatabase mSqLiteDatabase;
    private static final String DB_NAME = "users.db";
    private static final int VERSION = 1;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        mSqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String userList = "create table if not exists "
                + DBUser.TABLENAME
                + " ( _id integer primary key autoincrement , "
                + DBUser.NAME + " text , "
                + DBUser.SEX + " text , "
                + DBUser.PHONE + " text , "
                + DBUser.PASSWORD + " text , "
                + DBUser.EMAIL + " text ) ; ";
        db.execSQL(userList);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP TABLE " + DBUser.TABLENAME;
        db.execSQL(deleteTable);
        String userList = "create table if not exists "
                + DBUser.TABLENAME
                + " ( _id integer primary key autoincrement , "
                + DBUser.NAME + " text , "
                + DBUser.SEX + " text , "
                + DBUser.PHONE + " text , "
                + DBUser.PASSWORD + " text , "
                + DBUser.EMAIL + " text ) ; ";
        db.execSQL(userList);
    }

    public void insertUsers(User user){
        ContentValues cv = new ContentValues();
        cv.put(DBUser.NAME,user.getName());
        cv.put(DBUser.SEX,user.getSex());
        cv.put(DBUser.PHONE,user.getPhone());
        cv.put(DBUser.PASSWORD,user.getPassword());
        cv.put(DBUser.EMAIL,user.getEmail());
        mSqLiteDatabase.insert(DBUser.TABLENAME, null, cv);
    }
    public User queryUser(String phone){
        User user = new User();
        Cursor cursor = mSqLiteDatabase.query(DBUser.TABLENAME,null,DBUser.PHONE + " = ?" ,new String[]{phone},null,null,null);
        while(cursor.moveToNext()) {
            user.setName(cursor.getString(cursor.getColumnIndex(DBUser.NAME)));
            user.setSex(cursor.getString(cursor.getColumnIndex(DBUser.SEX)));
            user.setPhone(cursor.getString(cursor.getColumnIndex(DBUser.PHONE)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(DBUser.PASSWORD)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(DBUser.EMAIL)));
        }
        cursor.close();
        return user;
    }

    //判断手机号是否已经注册
    public boolean ifPhoneHasRegister(String phone){
        Cursor cursor = mSqLiteDatabase.rawQuery(
                "select * from  " +DBUser.TABLENAME+ " where   "+DBUser.PHONE +"=? ",
                new String[] { phone });
        while (cursor.moveToNext()) {
            cursor.close();
            return true;// //有城市在数据库已存在，返回true
        }
        cursor.close();
        return false;// //在数据库以前存在 false
    }
}
