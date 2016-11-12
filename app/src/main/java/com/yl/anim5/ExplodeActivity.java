package com.yl.anim5;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

/**
 *爆炸动画
 */
public class ExplodeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设置允许进入动画重叠
            getWindow().setAllowEnterTransitionOverlap(true);
            //设置允许返回动画重叠
            getWindow().setAllowReturnTransitionOverlap(true);
            Explode explode = new Explode();
            explode.setDuration(300);
            getWindow().setEnterTransition(explode);
            getWindow().setExitTransition(explode);

        }
        setContentView(R.layout.activity_animation);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //设置动画播放完毕才执行finish();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
    }
}
