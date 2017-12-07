package _path;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Path {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		File file = new File("");
		System.out.println(file.getPath()); 
		System.out.println(file.getAbsolutePath()); 
		System.out.println(file.getCanonicalPath());
		
		
		//相对于当前用户目录的相对路径
		//对于一般项目，这是项目的根路径。对于JavaEE服务器，这可能是服务器的某个路径。这个并没有统一的规范！
		System.err.println(System.getProperty("user.dir"));
		
		//得到的是当前类FileTest.class文件的URI目录。不包括自己！
		//FileTest.class.getResource("")
		System.err.println(Path.class.getResource(""));
		
		
		//FileTest.class.getResource("/")
		//得到的是当前的classpath的绝对URI路径。
		System.err.println(Path.class.getResource("/"));
		
//		Thread.currentThread().getContextClassLoader().getResource("")
//		得到的也是当前ClassPath的绝对URI路径。
		
		System.err.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.err.println(Thread.currentThread().getContextClassLoader().getResource("").getFile());
		System.err.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
		
//		FileTest.class.getClassLoader().getResource("")
//		得到的也是当前ClassPath的绝对URI路径。
		System.err.println(Path.class.getClassLoader().getResource(""));
		
		
		
		
	}

}
