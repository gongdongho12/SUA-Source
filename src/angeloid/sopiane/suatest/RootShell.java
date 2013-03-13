/*package angeloid.sopiane.suatest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RootShell {

	public static String RunRootCommand = "";

	void RootShellClass(String Command) {
		String out = null;
		try {
			String[] sucommand = new String[] { "su", "-c" + RunRootCommand };
			Process p = Runtime.getRuntime().exec(sucommand);
			DataOutputStream stdin = new DataOutputStream(p.getOutputStream());
			stdin.writeBytes(Command + "\n");
			DataInputStream stdout = new DataInputStream(p.getInputStream());
			byte[] buffer = new byte[4096];
			int read = 0;
			out = new String();
			while (true) {
				read = stdout.read(buffer);
				out += new String(buffer, 0, read);
				if (read < 4096) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
} */
