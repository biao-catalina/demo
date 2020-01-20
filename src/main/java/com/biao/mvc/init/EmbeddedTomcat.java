package com.biao.mvc.init;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class EmbeddedTomcat {

	private void startTomcat() throws Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8081);
		Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
		context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
		tomcat.start();
		tomcat.getServer().await();
	}

	public static void main(String[] args) {
		try {
			EmbeddedTomcat embeddedTomcat = new EmbeddedTomcat();
			embeddedTomcat.startTomcat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
