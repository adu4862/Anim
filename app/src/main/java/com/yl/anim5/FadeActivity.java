package com.yl.anim5;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Window;


public class FadeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowEnterTransitionOverlap(true);

            getWindow().setAllowReturnTransitionOverlap(true);
            setContentView(R.layout.activity_animation);

            Fade fade = new Fade();
            fade.setDuration(500);
            //fade.addTarget(findViewById(R.id.view));
            getWindow().setEnterTransition(fade);
            getWindow().setExitTransition(fade);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
    }
}
