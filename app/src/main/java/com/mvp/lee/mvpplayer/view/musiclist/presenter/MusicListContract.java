package com.mvp.lee.mvpplayer.view.musiclist.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mvp.lee.mvpplayer.adapter.contract.MlAdapeterContract;
import com.mvp.lee.mvpplayer.data.MusicData;

/**
 * Created by Lee on 2017-03-28.
 */

public class MusicListContract {
    public interface View{

    }

    public interface Presenter{
        void attachView(View view);
        void detachView();
        void setMlAdapterView(MlAdapeterContract.View adapterView);
        void setMlAdapterModel(MlAdapeterContract.Model adapterModel);
        void loadItems(Context context);
        void setMusicData(MusicData musicData);
    }
}
