package angeloid.sopiane.suatest;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;

public class SUAdapter extends Activity {

	void SUAdapterMain() {
	final int SUPERUSER_REQUEST = 2323;
	Intent intent = new Intent("android.intent.action.superuser");
	intent.putExtra("name", "SUAdpaterTest");
	intent.putExtra("packagename", "angeloid.sopiane.suatest");
	startActivityForResult(intent, SUPERUSER_REQUEST); 
	}
	
	void SUCommandReceiver(String sucommand) throws IOException, InterruptedException {
		String sucommand_receiver = getIntent().getStringExtra("sucommand");
		Runtime.getRuntime().exec("su -c" + sucommand_receiver);
		Thread.sleep(4000);
		sucommand_receiver = "";
	}
}
