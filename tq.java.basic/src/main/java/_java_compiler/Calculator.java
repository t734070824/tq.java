package _java_compiler;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Calculator {
	public static void main(String[] args) throws URISyntaxException {
		System.err.println(calculate("3*45"));
	}
	
	   private static double calculate(String expr) throws URISyntaxException {
		   String className = "CalculatorMain";
		   String methodName = "calculate";
		   String source = "public class " + className 
		      + " { public static double " + methodName + "() { return " + expr + "; } }";
		   JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	      StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
	      CompilerTest.StringSourceJavaObject sourceObject = new CompilerTest.StringSourceJavaObject("Main", source);
	      Iterable< ? extends JavaFileObject> fileObjects = Arrays.asList(sourceObject);
	      CompilationTask task = compiler.getTask(null, fileManager, null, null, null, fileObjects);
		   boolean result = task.call();
		   if (result) {
		      ClassLoader loader = Calculator.class.getClassLoader(); 
		      try {
		    	  Class<?> clazz = loader.loadClass(className);
		    	  Method method = clazz.getMethod(methodName, new Class<?>[] {});
		    	  Object value = method.invoke(null, new Object[] {});
		    	  return (Double) value;
			} catch (Exception e) {
				e.printStackTrace();
			}
		      }
		return 0;
	   }
}
