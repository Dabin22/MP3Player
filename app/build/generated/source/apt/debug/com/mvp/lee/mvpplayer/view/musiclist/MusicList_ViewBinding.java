// Generated code from Butter Knife. Do not modify!
package com.mvp.lee.mvpplayer.view.musiclist;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mvp.lee.mvpplayer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MusicList_ViewBinding implements Unbinder {
  private MusicList target;

  @UiThread
  public MusicList_ViewBinding(MusicList target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MusicList_ViewBinding(MusicList target, View source) {
    this.target = target;

    target.music_list = Utils.findRequiredViewAsType(source, R.id.music_list, "field 'music_list'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MusicList target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.music_list = null;
  }
}
