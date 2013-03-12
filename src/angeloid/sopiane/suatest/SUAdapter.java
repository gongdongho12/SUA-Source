package angeloid.sopiane.suatest;

// 버퍼(임시 메모리)를 쓰는 용도
// Buffer (temporary memory) writing purposes
import java.io.BufferedReader;

// 버퍼를 읽는 용도
// Buffer reading purposes
import java.io.InputStreamReader;

import android.app.Activity;

// 로그캣을 쓰는 용도
// Logcat writing purposes
import android.util.Log;

public class SUAdapter extends Activity {
	
	// SUAdapter Source(s)

	static String sucommand_receiver_fragment = "";
	static String sucommand_receiver = "";

	void SUCommandReceiver() {
		// MainActivity.java에서 받은 데이터를 불러온다
		// To bring up the data received from the MainActivity.java
		sucommand_receiver = getIntent().getStringExtra("sucommand");
		// Su권한을 사용하기 위해 선언한다
		// Su permission to use the declaration
		Runtime sucommand_runtime = Runtime.getRuntime();
		// 프로세스를 선언한다
		// Process to use the declaration
		Process processcommand;
		try {
			// SU권한을 얻기 위해 받은 데이터를 수정한다
			// SU permission to obtain the received data is modified
			String[] sucommand = new String[] { "su", "-c" + sucommand_receiver };
			// 수정한 데이터를 실행한다
			// Modify data, run
			processcommand = sucommand_runtime.exec(sucommand);
			// 버퍼를 사용한다
			// Use Buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(
					processcommand.getInputStream()));
			// 문구가 오류를 일으키거나 버퍼가 문제 있을 때 디버깅으로 알려준다.
			// Tells the error terms can cause debugging problems when the
			// buffer is.
			String line;
			while ((line = br.readLine()) != null) {
				Log.i("SUAdapter", line);
			}
			// 받은 데이터를 나중에 다시 사용하기 위해 지운다
			// Received data in order to use it again in the future, erase
			sucommand_receiver = "";
			// 오류가 일어났을 때 처리한다.
			// Processed when the error occurred.
		} catch (Exception e) {
			// 강종 메세지를 띄운다
			// Bring up the steel grade message
			e.fillInStackTrace();
			// 로그캣에 오류 메세지를 보여준다
			// Show an error message in the log Cat
			Log.e("SUAdapter",
					"SOME ERROR(S) Detected in SUAdapter in SUAdapter.java!");
		}

	}

	void SUAdapter_Fragment() {
		// MainActivity.java에서 받은 데이터를 불러온다
		// To bring up the data received from the MainActivity.java
		// Su권한을 사용하기 위해 선언한다
		// Su permission to use the declaration
		Runtime sucommand_runtime_fragment = Runtime.getRuntime();
		// 프로세스를 선언한다
		// Process to use the declaration
		Process processcommand_fragment;
		try {
			// SU권한을 얻기 위해 받은 데이터를 수정한다
			// SU permission to obtain the received data is modified
			String[] sucommand = new String[] { "su",
					"-c" + sucommand_receiver_fragment };
			// 수정한 데이터를 실행한다
			// Modify data, run
			processcommand_fragment = sucommand_runtime_fragment
					.exec(sucommand);
			// 버퍼를 사용한다
			// Use Buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(
					processcommand_fragment.getInputStream()));
			// 문구가 오류를 일으키거나 버퍼가 문제 있을 때 디버깅으로 알려준다.
			// Tells the error terms can cause debugging problems when the
			// buffer is.
			String line;
			while ((line = br.readLine()) != null) {
				Log.i("SUAdapter_Fragment", line);
			}
			// 받은 데이터를 나중에 다시 사용하기 위해 지운다
			// Received data in order to use it again in the future, erase
			sucommand_receiver_fragment = "";
			// 오류가 일어났을 때 처리한다.
			// Processed when the error occurred.
		} catch (Exception e) {
			// 강종 메세지를 띄운다
			// Bring up the steel grade message
			e.fillInStackTrace();
			// 로그캣에 오류 메세지를 보여준다
			// Show an error message in the log Cat
			Log.e("SUAdapter_Fragment",
					"SOME ERROR(S) Detected in SUAdapter in SUAdapter.java!");
		}
	}
}
