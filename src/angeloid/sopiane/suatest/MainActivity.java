package angeloid.sopiane.suatest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// StartAdapter OpenSource
	// For SUPERAdapter , UnZipThread
	void StartAdapter (Context con, String command_adapter) throws InterruptedException{
		// 2013.03.12 연구주제 >>> 
		UnZipThread.StartThread(MainActivity.this);
		Thread.sleep(3000);
		StringBuilder SA = new StringBuilder();
		SA.append("mount -o rw,remount /system;");
		SA.append("busybox touch /system/SuperAdapterTest;");
		SA.append("busybox chmod 777 /system/SuperAdapterTest;");
		// Thread.sleep(Wait Device)
		Thread.sleep(4000);
		
		// if use Activity or etc, (Not a Fragment), use this String.
		String Command = SA.toString();
		Intent intent = new Intent(MainActivity.this, SUAdapter.class); 
		intent.putExtra("sucommand", Command); 
		startActivity(intent);
		
		// if use Fragment or v4.Fragment, Use this String.
		SUAdapter.sucommand_receiver_fragment = SA.toString();
	}
}
