package com.jinxudong.magic;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener {

	private TextView j;
	private TextView q;
	private TextView k;
	private Intent intent;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		j = (TextView) findViewById(R.id.J);
		q = (TextView) findViewById(R.id.Q);
		k = (TextView) findViewById(R.id.K);

		mContext = this;
		intent = new Intent(mContext, HsActivity.class);

		j.setOnClickListener(this);
		q.setOnClickListener(this);
		k.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.J:
			intent.putExtra("num", 1);
			startActivity(intent);
			finish();
			break;
		case R.id.Q:
			intent.putExtra("num", 2);
			startActivity(intent);
			finish();
			break;
		case R.id.K:
			intent.putExtra("num", 3);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}
	}
}
