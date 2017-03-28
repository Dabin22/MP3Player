package com.mvp.lee.mvpplayer.view.musiclist;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.mvp.lee.mvpplayer.R;
import com.mvp.lee.mvpplayer.adapter.MusicListAdapter;
import com.mvp.lee.mvpplayer.data.MusicData;
import com.mvp.lee.mvpplayer.view.musiclist.presenter.MusicListContract;
import com.mvp.lee.mvpplayer.view.musiclist.presenter.MusicListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicList extends AppCompatActivity implements MusicListContract.View{
    private final int REQUEST_CODE = 100;
    private MusicListPresenter mlPresenter;

    @BindView(R.id.music_list)
    ListView music_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        ButterKnife.bind(this);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkPermission();
        }else{
            init();
        }
    }

    private void init(){
        mlPresenter = new MusicListPresenter();
        mlPresenter.attachView(this);
        MusicListAdapter mlAdapter = new MusicListAdapter(this);
        mlPresenter.setMusicData(MusicData.getInstance());
        mlPresenter.setMlAdapterModel(mlAdapter);
        mlPresenter.setMlAdapterView(mlAdapter);
        mlPresenter.loadItems(this);
        music_list.setAdapter(mlAdapter);

    }


    @TargetApi(Build.VERSION_CODES.M)
    public void checkPermission() {
        //런타임 권한 체크(디스크 읽기권한)
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //요청할 권한들을 배열로 만든다 이때에는 한개라 한개만 입력
            String permissionArray[] = {Manifest.permission.READ_EXTERNAL_STORAGE};
            //런타임 권한 요청을 위한 팝업창 출력
            requestPermissions(permissionArray,REQUEST_CODE);
        }else{
            init();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                //요청한 코드가 위의 팝업창에서 넘겨준 코드값가 같은면
                //팝업창에서 권한 수락시 데이터 세팅
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    init();
                    Toast.makeText(this,"permission success!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
