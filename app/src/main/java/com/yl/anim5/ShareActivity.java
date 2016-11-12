package com.yl.anim5;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.Window;

/**
 * Created by Administrator on 2016/11/12 0012.
 */
public class ShareActivity extends Activity{
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //通过反射获取目标activity动画
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);
        getWindow().setSharedElementsUseOverlay(true);

        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new Fade());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTarget("bt4");
        transitionSet.setDuration(800);
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);
        getWindow().setSharedElementReturnTransition(transitionSet);
        getWindow().setSharedElementReenterTransition(transitionSet);

        setContentView(R.layout.activity_share);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
