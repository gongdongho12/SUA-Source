package angeloid.sopiane.suatest;

import android.os.Bundle;
import android.os.Handler;

import android.util.Log;

import android.app.Activity;
import android.app.ProgressDialog;

public class MainActivity extends Activity {

	Handler mHandler;
	ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
					SA.append("mount -o rw,remount /system;");
					SA.append("busybox touch /system/SuperAdapterTest;");
					SA.append("busybox chmod 777 /system/SuperAdapterTest;");
					try {
						SUAdapter.sucommand_receiver = SA.toString();
						try {
							SUAdapter.SUCommandReceiver();
						} catch (Exception e) {
							e.fillInStackTrace();
							Log.e("MainActivity.this", "Some Error(s) detected in SUAdapter!!");
						}
					} catch (Exception e) {
						e.fillInStackTrace();
						Log.e("MainActivity.this", "Some Error(s) detected in StringBuilder!");
					}
				}
			}, 20000);
		} else {
			dialog.dismiss();
		}
	}
}
