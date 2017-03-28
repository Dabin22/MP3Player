package com.mvp.lee.mvpplayer.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mvp.lee.mvpplayer.R;
import com.mvp.lee.mvpplayer.adapter.contract.MlAdapeterContract;
import com.mvp.lee.mvpplayer.data.MusicItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Lee on 2017-03-28.
 */

public class MusicListAdapter extends BaseAdapter implements MlAdapeterContract.Model,MlAdapeterContract.View {
    private LayoutInflater layoutInflater;
    private ArrayList<MusicItem> datas;
    public MusicListAdapter(Context context){
        datas = new ArrayList<>();
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private TextView tv_music_title;
    private TextView tv_singer;
    private ImageView iv_music;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_music_list,null);
        }
        tv_music_title = (TextView)convertView.findViewById(R.id.music_title);
        tv_singer = (TextView)convertView.findViewById(R.id.singer);
        iv_music = (ImageView)convertView.findViewById(R.id.music_img);

        tv_music_title.setText(datas.get(position).getTitle());
        tv_singer.setText(datas.get(position).getSinger());
        iv_music.setImageBitmap(datas.get(position).getAlbum_id());

        return convertView;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItems(ArrayList<MusicItem> imageItems) {
        datas.addAll(imageItems);
    }

    @Override
    public void clearItem() {
        datas.clear();
    }
}
