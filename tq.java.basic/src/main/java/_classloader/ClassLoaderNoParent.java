package _classloader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ClassLoaderNoParent {
	
	public final static Map<Integer, Integer> map = new HashMap<>();
	
	static{
		map.put(1, 1);
	}
	
	
	public Map<Integer, Integer> test(){
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		return map;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader myLoader = new ClassLoader() {
			
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				
				try {
					
					String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream resourceAsStream = getClass().getResourceAsStream(filename);
					return super.loadClass(name);
//					if(resourceAsStream == null){
//					}
//					
//					byte[] b= new byte[resourceAsStream.available()];
//					resourceAsStream.read(b);
//					return defineClass(name, b, 0, b.length);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		};
		
//		Object o = myLoader.loadClass("com.classloader.DaoImpl").newInstance();
//		System.err.println(o.getClass());
//		System.err.println(o instanceof ClassLoaderNoParent);
//		System.err.println();
		//TODO 错误
		
	}

}


