package com.yl.anim5;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;
    @BindView(R.id.bt4)
    Button bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         *  Flag for requesting that window content changes should be animated using a
         * TransitionManager.
         * 意思是:想在这个acitivity开启转场动画就要请求这个flag.注意:要用在setContentView之前
         */
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_transitions);
        ButterKnife.bind(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4})
    public void onClick(View view) {
        Transition transition = null;
        Intent intent = null;
        switch (view.getId()) {
            case R.id.bt1:
                transition = new Explode();
                intent = new Intent(MainActivity.this, ExplodeActivity.class);
                break;
            case R.id.bt2:
                transition = new Fade();
                intent = new Intent(MainActivity.this, FadeActivity.class);
                break;
            case R.id.bt3:
                transition = new Slide();
                intent = new Intent(MainActivity.this, SlideActivity.class);
                break;
            case R.id.bt4:
                break;
        }
        if (view.getId() != R.id.bt4) {
            transition.setDuration(400);
            getWindow().setEnterTransition(transition);
            getWindow().setExitTransition(transition);
            getWindow().setReenterTransition(transition);
            getWindow().setReturnTransition(transition);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
        } else {//share动画与上面的动画实现方式有一些差异
            TransitionSet set = new TransitionSet();
            set.addTransition(new Explode());
            set.addTransition(new Fade());
            set.setDuration(800);
            getWindow().setEnterTransition(set);
            getWindow().setExitTransition(set);
            getWindow().setReenterTransition(set);
            getWindow().setReturnTransition(set);

            bt4.setTransitionName("share");

            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(new ChangeTransform());
            transitionSet.addTransition(new ChangeBounds());
            transitionSet.setDuration(800);
            transitionSet.addTarget("share");
            getWindow().setSharedElementEnterTransition(transitionSet);
            getWindow().setSharedElementExitTransition(transitionSet);
            getWindow().setSharedElementReenterTransition(transitionSet);
            getWindow().setSharedElementReturnTransition(transitionSet);

            intent = new Intent(MainActivity.this, ShareActivity.class);
            ActivityOptions share = ActivityOptions.makeSceneTransitionAnimation(this, bt4, "share");
            startActivity(intent,share.toBundle());
        }
    }
}
