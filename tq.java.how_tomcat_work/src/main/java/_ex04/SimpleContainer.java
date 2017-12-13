package _ex04;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.Arrays;

import javax.naming.directory.DirContext;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Cluster;
import org.apache.catalina.Container;
import org.apache.catalina.ContainerListener;
import org.apache.catalina.Loader;
import org.apache.catalina.Logger;
import org.apache.catalina.Manager;
import org.apache.catalina.Mapper;
import org.apache.catalina.Realm;
import org.apache.catalina.Request;
import org.apache.catalina.Response;

public class SimpleContainer implements Container{
	
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Loader getLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLoader(Loader loader) {
		// TODO Auto-generated method stub
		
	}

	public Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLogger(Logger logger) {
		// TODO Auto-generated method stub
		
	}

	public Manager getManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setManager(Manager manager) {
		// TODO Auto-generated method stub
		
	}

	public Cluster getCluster() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCluster(Cluster cluster) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	public Container getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setParent(Container container) {
		// TODO Auto-generated method stub
		
	}

	public ClassLoader getParentClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setParentClassLoader(ClassLoader parent) {
		// TODO Auto-generated method stub
		
	}

	public Realm getRealm() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRealm(Realm realm) {
		// TODO Auto-generated method stub
		
	}

	public DirContext getResources() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setResources(DirContext resources) {
		// TODO Auto-generated method stub
		
	}

	public void addChild(Container child) {
		// TODO Auto-generated method stub
		
	}

	public void addContainerListener(ContainerListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addMapper(Mapper mapper) {
		// TODO Auto-generated method stub
		
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	public Container findChild(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Container[] findChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	public ContainerListener[] findContainerListeners() {
		// TODO Auto-generated method stub
		return null;
	}

	public Mapper findMapper(String protocol) {
		// TODO Auto-generated method stub
		return null;
	}

	public Mapper[] findMappers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void invoke(Request request, Response response) throws IOException, ServletException {
		String servletName = ((HttpServletRequest)request).getRequestURI();
		servletName = servletName.substring(servletName.lastIndexOf("/") + 1);
		URLClassLoader loader = null;
        try {
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classpath = new File(WEB_ROOT);
			String respository = (new URL("file", null, classpath.getCanonicalPath() + File.separator).toString());
			urls[0] = new URL(null, respository, streamHandler);
			loader = new URLClassLoader(urls);
			System.err.println(Arrays.toString(urls));
			
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		Class<?> myClass = null;
		
		try {
			myClass = loader.loadClass(servletName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			e.printStackTrace();;
		}
		
		Servlet servlet = null;
		try {
			servlet = (Servlet) myClass.newInstance();
			servlet.service((HttpServletRequest)request, (HttpServletResponse)response);
		} catch (InstantiationException e) {
			e.printStackTrace();;
		} catch (IllegalAccessException e) {
			e.printStackTrace();;
		}
	}

	public Container map(Request request, boolean update) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeChild(Container child) {
		// TODO Auto-generated method stub
		
	}

	public void removeContainerListener(ContainerListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeMapper(Mapper mapper) {
		// TODO Auto-generated method stub
		
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
