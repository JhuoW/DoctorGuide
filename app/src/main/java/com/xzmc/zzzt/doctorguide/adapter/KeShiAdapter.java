package com.xzmc.zzzt.doctorguide.adapter;

import android.content.Context;

import com.xzmc.zzzt.doctorguide.R;

import java.util.List;

/**
 * Created by zw on 17/6/11.
 */

public class KeShiAdapter extends BaseListAdapter<String>{
    List<String> datas;
    int layoutId;
    Context ctx;
    public KeShiAdapter(Context ctx, List<String> datas, int layoutId) {
        super(ctx, datas, layoutId);
        this.ctx=ctx;
        this.layoutId= layoutId;
        this.datas = datas;
    }

    @Override
    public void conver(ViewHolder holder, int position, String s) {
        holder.setText(R.id.keshi,s);

    }
}
