package com.mvp.lee.mvpplayer.data;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;

import java.util.ArrayList;


/**
 * Created by Lee on 2017-03-28.
 */

public class MusicData {
    private MusicData() {

    }

    private static MusicData musicData;

    public static MusicData getInstance() {
        if (musicData == null) {
            musicData = new MusicData();
        }
        return musicData;
    }

    private MusicItem data;
    public ArrayList<MusicItem> getMusicInfo(Context context) {
        ArrayList<MusicItem> datas = new ArrayList<>();

        String projections[] = {
                MediaStore.Audio.Media._ID,         //노래 아이디
                MediaStore.Audio.Media.ALBUM_ID,    //앨범 아이디
                MediaStore.Audio.Media.TITLE,       //제목
                MediaStore.Audio.Media.ARTIST       //가수
        };

        //getContentResolver 파라메터
        //1번째 주소 2번째 검색해올 컬럼명들 3번째 조건절 4번째 조건절에 부합하는 값, 5번째 정렬기준
        //아래 주석 참고
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projections, null, null, null);

        /*
            - uri : content ://스키마 형태로 정해져 있는 곳의 데이터를 가져온다.
            - projection : 가져올 컬럼 이름들의 배열, null을 입력하면 모든값을 가져온다.
            - selection : 조건절(where)에 해당하는 내용
            - selectionArgs : 조건절이 Preparedstatement 형태일 때 ?에 매핑하는 되는값의 배열
            - sort order : 정렬 조건
         */




        if (cursor != null) {
            while (cursor.moveToNext()) {

                try {
                    data = new MusicItem();
                    //1. 가수 이름 컴럼의 인덱스 순서를 가져온다.
                    //2. 해당 index를 가진 컬럼의 실제값을 가져온다.
//
                    data.setSinger(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)));
                    data.setTitle(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
                    data.setMusic_id(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
                    Long album_id_idx = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                    Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");

                    Uri sAlbumArtUri = ContentUris.withAppendedId(sArtworkUri, album_id_idx);
                    data.setUri(sAlbumArtUri);


                    ParcelFileDescriptor fd = context.getContentResolver().openFileDescriptor(sAlbumArtUri, "r");
                    Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fd.getFileDescriptor(), null, null);
                    data.setAlbum_id(Bitmap.createScaledBitmap(bitmap, 500, 500, true));

//                    }

                } catch (Exception e) {
                    data.setAlbum_id(null);
                }
                datas.add(data);
            }
            cursor.close();
        }
        return datas;
    }
}
