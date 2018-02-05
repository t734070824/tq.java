package _java_compiler;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class CompilerTest {
	   public static void main(String[] args) throws Exception {      
	      String source = "public class Main { public static void main(String[] args) {System.out.println(\"Hello World!\");} }";
	      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	      StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
	      StringSourceJavaObject sourceObject = new CompilerTest.StringSourceJavaObject("Main", source);
	      Iterable< ? extends JavaFileObject> fileObjects = Arrays.asList(sourceObject);
	      CompilationTask task = compiler.getTask(null, fileManager, null, null, null, fileObjects);
	      boolean result = task.call();
	      if (result) {
	         System.out.println("编译成功。");
	      }
	   }
	   


	   static class StringSourceJavaObject extends SimpleJavaFileObject {

	      private String content = null;
	      public StringSourceJavaObject(String name, String content) throws URISyntaxException {
	         super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
	         this.content = content;
	      }
	      public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
	         return content;
	      }
	   }
	}