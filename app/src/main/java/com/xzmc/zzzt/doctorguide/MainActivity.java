package com.xzmc.zzzt.doctorguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


import com.nineoldandroids.view.ViewPropertyAnimator;
import com.xzmc.zzzt.doctorguide.Fragment.KeShiFragment;
import com.xzmc.zzzt.doctorguide.Fragment.ZhenZhuangFragment;

import java.util.ArrayList;


public class MainActivity extends TopBarBaseActivity {
    private ArrayList<Fragment> fragments;

    private ViewPager viewPager;


    private TextView keshi;
    private TextView zhenzhaung;

    private int line_width;
    private View line;

    @Override
    protected int getConentView() {
        return R.layout.activity_one;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("挂号系统");
        toolbar.setNavigationIcon(null);

    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {//选择性显示 图标 或 文字
        menu.findItem(R.id.settings).setTitle("退出登录");

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void initView() {
        keshi = (TextView) findViewById(R.id.keshi);
        zhenzhaung = (TextView) findViewById(R.id.zhenzhaung);

        line = findViewById(R.id.line);

        ViewPropertyAnimator.animate(keshi).scaleX(1.2f).setDuration(0);
        ViewPropertyAnimator.animate(keshi).scaleY(1.2f).setDuration(0);
        fragments = new ArrayList<Fragment>();
        fragments.add(new KeShiFragment());
        fragments.add(new ZhenZhuangFragment());
        line_width = getWindowManager().getDefaultDisplay().getWidth()
                / fragments.size();
        line.getLayoutParams().width = line_width;
        line.requestLayout();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(
                getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragments.get(arg0);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                changeState(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                float tagerX = arg0 * line_width + arg2 / fragments.size();
                ViewPropertyAnimator.animate(line).translationX(tagerX)
                        .setDuration(0);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        zhenzhaung.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewPager.setCurrentItem(1);
            }
        });

        keshi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewPager.setCurrentItem(0);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAction() {

    }

    private void changeState(int arg0) {
        if (arg0 == 0) {
            keshi.setTextColor(getResources().getColor(R.color.theme));
            zhenzhaung.setTextColor(getResources().getColor(R.color.black));
            ViewPropertyAnimator.animate(keshi).scaleX(1.2f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(keshi).scaleY(1.2f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(zhenzhaung).scaleX(1.0f).setDuration(200);
            ViewPropertyAnimator.animate(zhenzhaung).scaleY(1.0f).setDuration(200);

        } else if(arg0==1){
            zhenzhaung.setTextColor(getResources().getColor(R.color.theme));
            keshi.setTextColor(getResources().getColor(R.color.black));
            ViewPropertyAnimator.animate(keshi).scaleX(1.0f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(keshi).scaleY(1.0f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(zhenzhaung).scaleX(1.2f).setDuration(200);
            ViewPropertyAnimator.animate(zhenzhaung).scaleY(1.2f).setDuration(200);

        }
    }
}
