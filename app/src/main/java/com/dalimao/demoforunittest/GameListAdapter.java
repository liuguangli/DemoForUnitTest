package com.dalimao.demoforunittest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuguangli on 16/7/22.
 */
public class GameListAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData = new ArrayList<>();
    private OnResultItemClickListener mItemClickListener;
    private View.OnClickListener mClickListener;
    public GameListAdapter(Context mContext) {
        this.mContext = mContext;
        mClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    Holder holder = (Holder) v.getTag();
                    String item = mData.get(holder.pos);
                    mItemClickListener.onResultItemClick(item, holder.pos);
                }
            }
        };
    }

    public void setItemClickListener(OnResultItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        if (position >= getCount()) {
            return null;
        }
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
       return position;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.game_list_item,null);
            holder = new Holder();

            holder.name = (TextView) convertView.findViewById(R.id.tv_name);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        String item = getItem(position);
        if (item == null) {
            return convertView;
        }

        holder.name.setText(item);
        holder.pos = position;
        convertView.setOnClickListener(mClickListener);
        return convertView;
    }



    public void setData(List<String> data) {

        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }




    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }


    public static interface OnResultItemClickListener {
        public void onResultItemClick(String item, int pos);
    }

    class Holder {


        private TextView name;
        private int pos;

    }
}
