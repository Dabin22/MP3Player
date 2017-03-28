package com.mvp.lee.mvpplayer.view.musiclist.presenter;

import android.content.Context;
import android.os.Build;

import com.mvp.lee.mvpplayer.adapter.contract.MlAdapeterContract;
import com.mvp.lee.mvpplayer.data.MusicData;
import com.mvp.lee.mvpplayer.data.MusicItem;

import java.util.ArrayList;


/**
 * Created by Lee on 2017-03-28.
 */

public class MusicListPresenter implements MusicListContract.Presenter {
    private MusicListContract.View view;
    private final int REQUEST_CODE = 100;
    private MlAdapeterContract.View adapterView;
    private MlAdapeterContract.Model adapterModel;
    private MusicData musicData;

    @Override
    public void attachView(MusicListContract.View view) {
        this.view = view;


    }

    @Override
    public void detachView() {
        view = null;
    }


    @Override
    public void setMusicData(MusicData musicData) {
        this.musicData = musicData;
    }


    @Override
    public void setMlAdapterView(MlAdapeterContract.View adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setMlAdapterModel(MlAdapeterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void loadItems(Context context) {
        ArrayList<MusicItem> datas = musicData.getMusicInfo(context);
        adapterModel.addItems(datas);
        adapterView.notifyAdapter();
    }



}

