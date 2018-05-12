package com.xzmc.zzzt.doctorguide.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xzmc.zzzt.doctorguide.R;
import com.xzmc.zzzt.doctorguide.ZhengZhuangDetailActivity;
import com.xzmc.zzzt.doctorguide.adapter.KeShiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 17/6/11.
 */

public class ZhenZhuangFragment extends Fragment{
    List<String> data  =new ArrayList<String>();
    String s1="肚子痛";
    String s2="腹肌抽搐";
    String s3="毛发增多";
    String s4="胸闷气短";
    String s5="扁桃体发炎";
    String s6="肾痛";
    String s7 = "腹泻";
    String s8 = "类风湿性关节炎";
    String s9 ="恶性贫血";
    String s10="感染性发热";
    String s11 = "关节扭伤";
    String s12="头晕呕吐";
    KeShiAdapter adapter;
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhenzhuang,
                container, false);
        data.add(s1);
        data.add(s2);
        data.add(s3);
        data.add(s4);
        data.add(s5);
        data.add(s6);
        data.add(s7);
        data.add(s8);
        data.add(s9);
        data.add(s10);
        data.add(s11);
        data.add(s12);
        listView = (ListView) view.findViewById(R.id.listview);
        adapter =new KeShiAdapter(getActivity(),data,R.layout.item_keshi);
        listView.setAdapter(adapter);
        initAction();
        return view;
    }

    private void initAction(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String str  = (String) parent.getAdapter().getItem(position);
                //Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ZhengZhuangDetailActivity.class);
                intent.putExtra("zz",str);
                startActivity(intent);
            }
        });
    }
}
