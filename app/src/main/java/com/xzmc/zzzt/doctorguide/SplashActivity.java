package com.xzmc.zzzt.doctorguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.xzmc.zzzt.doctorguide.db.PreferenceMap;


/**
 * Created by zw on 17/5/8.
 */

public class SplashActivity extends BaseActivity{
    private static final int sleepTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lay_start_act);



        new Thread() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long costTime = System.currentTimeMillis();
                            if (sleepTime - costTime > 0) {
                                Thread.sleep(sleepTime - costTime);
                            } else {
                                Thread.sleep(sleepTime);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(new PreferenceMap(ctx).isLogin()){
                            startActivity(new Intent(SplashActivity.this,
                                    MainActivity.class));
                        }else{
                            startActivity(new Intent(SplashActivity.this,
                                    LoginActivity.class));
                        }
                        finish();
                    }
                }).start();
            }

        }.start();
    }
}
