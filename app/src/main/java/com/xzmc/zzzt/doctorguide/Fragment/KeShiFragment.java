package com.xzmc.zzzt.doctorguide.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xzmc.zzzt.doctorguide.MainActivity;
import com.xzmc.zzzt.doctorguide.R;
import com.xzmc.zzzt.doctorguide.Utils.Utils;
import com.xzmc.zzzt.doctorguide.adapter.KeShiAdapter;
import com.xzmc.zzzt.doctorguide.keshiActivity.Guke;
import com.xzmc.zzzt.doctorguide.keshiActivity.HuXiActivity;
import com.xzmc.zzzt.doctorguide.keshiActivity.MiNiaoActivity;
import com.xzmc.zzzt.doctorguide.keshiActivity.ShenjinActivity;
import com.xzmc.zzzt.doctorguide.keshiActivity.XiaoHuaActivity;
import com.xzmc.zzzt.doctorguide.keshiActivity.XinXueGuanActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 17/6/11.
 */

public class KeShiFragment extends Fragment{
    List<String> data  =new ArrayList<String>();
    String s1="消化内科";
    String s2="心血管内科";
    String s3="泌尿外科";
    String s4="呼吸内科";
    String s5="神经外科";
    String s6="骨科";
    KeShiAdapter adapter;
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,
                container, false);
        data.add(s1);
        data.add(s2);
        data.add(s3);
        data.add(s4);
        data.add(s5);
        data.add(s6);
        listView = (ListView) view.findViewById(R.id.listview);
        adapter =new KeShiAdapter(getActivity(),data,R.layout.item_keshi);
        listView.setAdapter(adapter);
        initAction();
        return view;
    }

    public void initAction() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Utils.goActivity(getActivity(), XiaoHuaActivity.class);
                }
                if(position ==1){
                    Utils.goActivity(getActivity(), XinXueGuanActivity.class);
                }
                if (position == 2) {
                    Utils.goActivity(getActivity(), MiNiaoActivity.class);
                }
                if(position == 3){
                    Utils.goActivity(getActivity(), HuXiActivity.class);
                }
                if(position == 4){
                    Utils.goActivity(getActivity(), ShenjinActivity.class);
                }
                if(position == 5){
                    Utils.goActivity(getActivity(), Guke.class);
                }
            }
        });
    }
}
