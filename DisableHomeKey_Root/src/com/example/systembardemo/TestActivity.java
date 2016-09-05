package com.example.systembardemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.disablekey.R;

public class TestActivity extends Activity {

	String TAG = "andli";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_systembar);
		
		//监听Home键
		HomeListener mHomeWatcher = new HomeListener(this);
		mHomeWatcher.setOnHomePressedListener(new IHomePressedListener() {
			@Override
			public void onHomePressed() {
				Toast.makeText(TestActivity.this, "click home",
						Toast.LENGTH_SHORT).show();
				Log.e(TAG, "onHomePressed");

				Intent intent = new Intent(TestActivity.this,TestActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}

			@Override
			public void onHomeLongPressed() {
				Log.e(TAG, "onHomeLongPressed");
				Intent intent = new Intent(TestActivity.this,TestActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		mHomeWatcher.startWatch();
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		Log.e(TAG, "onUserLeaveHint");
		Intent intent = new Intent(this,TestActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
