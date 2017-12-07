package _io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundleDemo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		ResourceBundle rb = ResourceBundle.getBundle("c.properties");
		ResourceBundle rb = ResourceBundle.getBundle("c");
		System.err.println(rb.getString("con"));
		
		
		Properties p = new Properties();
		p.load(new FileInputStream(rb.getString("con")));
		System.err.println(p.getProperty("ss"));
	}

}
