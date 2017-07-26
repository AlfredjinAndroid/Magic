package com.jinxudong.magic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HsActivity extends Activity implements OnClickListener {
	private TextView ht;
	private TextView fk;
	private TextView hx;
	private TextView mh;
	private int num;
	private Intent it;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_hs);
		Intent intent = getIntent();

		num = intent.getIntExtra("num", 0);
		it = new Intent(this, ResultActivity.class);
		it.putExtra("num", num);
		ht = (TextView) findViewById(R.id.ht);
		fk = (TextView) findViewById(R.id.fk);
		hx = (TextView) findViewById(R.id.hx);
		mh = (TextView) findViewById(R.id.mh);
		
		ht.setOnClickListener(this);
		fk.setOnClickListener(this);
		hx.setOnClickListener(this);
		mh.setOnClickListener(this);
		
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.hx:
			it.putExtra("hs", 1);
			switch (num) {
			case 1:
				ImageUtil.tempData = 1;
				break;
			case 2:
				ImageUtil.tempData = 2;
				break;
			case 3:
				ImageUtil.tempData = 3;
				break;
			}
			startActivity(it);
			finish();
			break;
		case R.id.fk:
			it.putExtra("hs", 2);
			switch (num) {
			case 1:
				ImageUtil.tempData = 4;
				break;
			case 2:
				ImageUtil.tempData = 5;
				break;
			case 3:
				ImageUtil.tempData = 6;
				break;
			}
			startActivity(it);
			finish();
			break;
		case R.id.ht:
			it.putExtra("hs", 3);
			switch (num) {
			case 1:
				ImageUtil.tempData = 7;
				break;
			case 2:
				ImageUtil.tempData = 8;
				break;
			case 3:
				ImageUtil.tempData = 9;
				break;
			}
			startActivity(it);
			finish();
			break;
		case R.id.mh:
			it.putExtra("hs", 4);
			switch (num) {
			case 1:
				ImageUtil.tempData = 10;
				break;
			case 2:
				ImageUtil.tempData = 11;
				break;
			case 3:
				ImageUtil.tempData = 12;
				break;
			}
			startActivity(it);
			finish();
			break;

		default:
			break;
		}
	}
}
