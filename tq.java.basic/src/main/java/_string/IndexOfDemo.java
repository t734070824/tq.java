package _string;

import java.io.File;

public class IndexOfDemo {
	
	public static void main(String[] args) {
		String ss = "123##";
		
		int index_1 = ss.indexOf("##");
		System.err.println(index_1);
        System.err.println("d:\\ss");
        System.err.println("d:\\ss".replaceAll("\\\\",File.separator));
    }

}
