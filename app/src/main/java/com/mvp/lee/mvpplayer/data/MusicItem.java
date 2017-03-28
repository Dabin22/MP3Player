package com.mvp.lee.mvpplayer.data;

import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Created by Lee on 2017-03-28.
 */

public class MusicItem {

    private String music_id;
    private Bitmap album_id;
    private String title;
    private String singer;
    private Uri uri;


    public String getMusic_id() {
        return music_id;
    }

    public void setMusic_id(String music_id) {
        this.music_id = music_id;
    }

    public Bitmap getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Bitmap album_id) {
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }


}
