package com.yl.anim5;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.transition.Slide;
import android.view.Window;


public class SlideActivity extends Activity {
	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		getWindow().setAllowEnterTransitionOverlap(true);
		getWindow().setAllowReturnTransitionOverlap(true);
		Slide slide = new Slide();
		slide.setDuration(1000);
		getWindow().setEnterTransition(slide);
		getWindow().setExitTransition(slide);


		setContentView(R.layout.activity_animation);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finishAfterTransition();
	}
}
