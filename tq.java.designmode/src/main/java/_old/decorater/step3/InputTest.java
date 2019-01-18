package _old.decorater.step3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputTest {
	public static void main(String[] args) {
		int c;
		try {
			InputStream in = new LowerCaseInputStream(
							 new BufferedInputStream(
							 new FileInputStream("src/main/java/data/nio-data.txt")));
			while((c = in.read()) >= 0 ){
				System.err.print((char)c);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
