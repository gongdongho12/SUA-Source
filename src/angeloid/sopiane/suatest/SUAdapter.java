package angeloid.sopiane.suatest;

// ����(�ӽ� �޸�)�� ���� �뵵
// Buffer (temporary memory) writing purposes
import java.io.BufferedReader;

// ���۸� �д� �뵵
// Buffer reading purposes
import java.io.InputStreamReader;

import android.app.Activity;

// �α�Ĺ�� ���� �뵵
// Logcat writing purposes
import android.util.Log;

public class SUAdapter extends Activity {
	
	// SUAdapter Source(s)

	static String sucommand_receiver_fragment = "";
	static String sucommand_receiver = "";

	void SUCommandReceiver() {
		// MainActivity.java���� ���� �����͸� �ҷ��´�
		// To bring up the data received from the MainActivity.java
		sucommand_receiver = getIntent().getStringExtra("sucommand");
		// Su������ ����ϱ� ���� �����Ѵ�
		// Su permission to use the declaration
		Runtime sucommand_runtime = Runtime.getRuntime();
		// ���μ����� �����Ѵ�
		// Process to use the declaration
		Process processcommand;
		try {
			// SU������ ��� ���� ���� �����͸� �����Ѵ�
			// SU permission to obtain the received data is modified
			String[] sucommand = new String[] { "su", "-c" + sucommand_receiver };
			// ������ �����͸� �����Ѵ�
			// Modify data, run
			processcommand = sucommand_runtime.exec(sucommand);
			// ���۸� ����Ѵ�
			// Use Buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(
					processcommand.getInputStream()));
			// ������ ������ ����Ű�ų� ���۰� ���� ���� �� ��������� �˷��ش�.
			// Tells the error terms can cause debugging problems when the
			// buffer is.
			String line;
			while ((line = br.readLine()) != null) {
				Log.i("SUAdapter", line);
			}
			// ���� �����͸� ���߿� �ٽ� ����ϱ� ���� �����
			// Received data in order to use it again in the future, erase
			sucommand_receiver = "";
			// ������ �Ͼ�� �� ó���Ѵ�.
			// Processed when the error occurred.
		} catch (Exception e) {
			// ���� �޼����� ����
			// Bring up the steel grade message
			e.fillInStackTrace();
			// �α�Ĺ�� ���� �޼����� �����ش�
			// Show an error message in the log Cat
			Log.e("SUAdapter",
					"SOME ERROR(S) Detected in SUAdapter in SUAdapter.java!");
		}

	}

	void SUAdapter_Fragment() {
		// MainActivity.java���� ���� �����͸� �ҷ��´�
		// To bring up the data received from the MainActivity.java
		// Su������ ����ϱ� ���� �����Ѵ�
		// Su permission to use the declaration
		Runtime sucommand_runtime_fragment = Runtime.getRuntime();
		// ���μ����� �����Ѵ�
		// Process to use the declaration
		Process processcommand_fragment;
		try {
			// SU������ ��� ���� ���� �����͸� �����Ѵ�
			// SU permission to obtain the received data is modified
			String[] sucommand = new String[] { "su",
					"-c" + sucommand_receiver_fragment };
			// ������ �����͸� �����Ѵ�
			// Modify data, run
			processcommand_fragment = sucommand_runtime_fragment
					.exec(sucommand);
			// ���۸� ����Ѵ�
			// Use Buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(
					processcommand_fragment.getInputStream()));
			// ������ ������ ����Ű�ų� ���۰� ���� ���� �� ��������� �˷��ش�.
			// Tells the error terms can cause debugging problems when the
			// buffer is.
			String line;
			while ((line = br.readLine()) != null) {
				Log.i("SUAdapter_Fragment", line);
			}
			// ���� �����͸� ���߿� �ٽ� ����ϱ� ���� �����
			// Received data in order to use it again in the future, erase
			sucommand_receiver_fragment = "";
			// ������ �Ͼ�� �� ó���Ѵ�.
			// Processed when the error occurred.
		} catch (Exception e) {
			// ���� �޼����� ����
			// Bring up the steel grade message
			e.fillInStackTrace();
			// �α�Ĺ�� ���� �޼����� �����ش�
			// Show an error message in the log Cat
			Log.e("SUAdapter_Fragment",
					"SOME ERROR(S) Detected in SUAdapter in SUAdapter.java!");
		}
	}
}
