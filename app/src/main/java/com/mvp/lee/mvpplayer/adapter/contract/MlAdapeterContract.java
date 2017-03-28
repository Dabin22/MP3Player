package com.mvp.lee.mvpplayer.adapter.contract;

import com.mvp.lee.mvpplayer.data.MusicItem;

import java.util.ArrayList;

/**
 * Created by Lee on 2017-03-28.
 */

public class MlAdapeterContract {
    public interface View{
        void notifyAdapter();
    }
    public interface Model{
        void addItems(ArrayList<MusicItem> imageItems);
        void clearItem();
    }
}
