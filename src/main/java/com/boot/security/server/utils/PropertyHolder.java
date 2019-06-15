package com.boot.security.server.utils;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class PropertyHolder {
	private static PropertyHolder ph = new PropertyHolder();
	private boolean debug=false;
	private static String viewPath;	
	private static String staticPath="static";
	private static String workPath="wxbusiness";
	private static String serverPath;
	private String absoluteWorkPath;
	private String absoluteStaticPath;
	private String rootPath;
	private static final AtomicBoolean inited = new AtomicBoolean(true);
	public String getAbsoluteStaticPath(){
		return absoluteStaticPath;
	}
	public String getAbsoluteWorkPath(){
		return absoluteWorkPath;
	}
	public String getViewPath() {
		return viewPath;
	}
	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}
	public String getStaticPath() {
		return staticPath;
	}
	public static void setStaticPath(String path) {
		staticPath = path;
	}
	public String getWorkPath() {
		return workPath;
	}
	public static void setWorkPath(String path) {
		workPath = path;
	}
	
	public static String getServerPath() {
		return serverPath;
	}
	private static void getWorkspace(){
		if(inited.get()){
			synchronized (inited) {
				//String path = System.getProperty("user.dir");
				String debug=System.getProperty("debug");
				String path=System.getProperty("catalina.home");
				String base=System.getProperty("catalina.base");
				System.out.println("catalina.base ="+base);
				System.out.println("catalina.home ="+base);
				if("true".equals(debug)){
					ph.debug=true;
				}
				
				File file = new File(path);
				String server=file.getAbsolutePath();
				ph.serverPath=server+File.separator+"webapps";
				System.out.println(ph.serverPath);
				ph.absoluteStaticPath =ph.serverPath+File.separator+workPath+File.separator+staticPath;
				ph.absoluteWorkPath=ph.serverPath+File.separator+workPath;
				ph.rootPath=ph.serverPath+File.separator+"ROOT";
				inited.set(false);
			}
		}
			
		
	}
	
	public String getRootPath() {
		return rootPath;
	}
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	public boolean isDebug() {
		return debug;
	}
	public static PropertyHolder get() {
		if (inited.get()) {
			getWorkspace();
		}
		return ph;
	}
	
}