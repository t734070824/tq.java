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

	//	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "tq.java.how_tomcat_work\\target\\classes" + File.separator + "webroot";
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "tq.java.how_tomcat_work\\target\\classes" + File.separator;

	public String getInfo() {

		return null;
	}

	public Loader getLoader() {

		return null;
	}

	public void setLoader(Loader loader) {


	}

	public Logger getLogger() {

		return null;
	}

	public void setLogger(Logger logger) {


	}

	public Manager getManager() {

		return null;
	}

	public void setManager(Manager manager) {


	}

	public Cluster getCluster() {

		return null;
	}

	public void setCluster(Cluster cluster) {


	}

	public String getName() {

		return null;
	}

	public void setName(String name) {


	}

	public Container getParent() {

		return null;
	}

	public void setParent(Container container) {


	}

	public ClassLoader getParentClassLoader() {

		return null;
	}

	public void setParentClassLoader(ClassLoader parent) {


	}

	public Realm getRealm() {

		return null;
	}

	public void setRealm(Realm realm) {


	}

	public DirContext getResources() {

		return null;
	}

	public void setResources(DirContext resources) {


	}

	public void addChild(Container child) {


	}

	public void addContainerListener(ContainerListener listener) {


	}

	public void addMapper(Mapper mapper) {


	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {


	}

	public Container findChild(String name) {

		return null;
	}

	public Container[] findChildren() {

		return null;
	}

	public ContainerListener[] findContainerListeners() {

		return null;
	}

	public Mapper findMapper(String protocol) {

		return null;
	}

	public Mapper[] findMappers() {

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

		return null;
	}

	public void removeChild(Container child) {


	}

	public void removeContainerListener(ContainerListener listener) {


	}

	public void removeMapper(Mapper mapper) {


	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {


	}

}
