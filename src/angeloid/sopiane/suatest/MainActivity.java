package angeloid.sopiane.suatest;

import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.app.Activity;
import android.app.ProgressDialog;

public class MainActivity extends Activity {

	Handler mHandler;
	ProgressDialog dialog;
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO
				v.postDelayed(new Runnable() {
					public void run() {
						DialogProgress(false);
					}
				}, 10); // 0.01 °£°ÝÀ» Áà¼­ ¹öÆ° ÇØÁ¦ ½Ã°£À» ¹ú¾îÁÜ
			}
		});
	}

	private void DialogProgress(boolean close) {
		if (!close) {
			dialog = ProgressDialog.show(MainActivity.this, "", "Loading..",
					true);
			Handler mHandler = new Handler();
			mHandler.postDelayed(new Runnable() {
				@Override
				public void run() {
					DialogProgress(true);
					StringBuilder SA = new StringBuilder();
					SA.append("mount -o rw,remount /syGVstem;");
					SA.append("busybox touch /system/SuperAdapterTest;");
					SA.append("busybox chmod 777 /system/SuperAdapterTest;");
					try {
						SUAdapter.sucommand_receiver = SA.toString();
						try {
							SUAdapter.SUCommandReceiver();
							Log.i("Success", "Success to apply Script(s)!");
						} catch (Exception e) {
							e.fillInStackTrace();
							Log.e("MainActivity.this", "Some Error(s) detected in SUAdapter!!");
						}
					} catch (Exception e) {
						e.fillInStackTrace();
						Log.e("MainActivity.this", "Some Error(s) detected in StringBuilder!");
					}
				}
			}, 2000);
		} else {
			dialog.dismiss();
		}
	}
}
