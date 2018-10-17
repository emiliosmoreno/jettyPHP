package com.examples.jetty.main;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.InstanceManager;
import org.apache.tomcat.SimpleInstanceManager;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
//import org.eclipse.jetty.util.thread.QueuedThreadPool;

/**
 * Hello world!
 *
 */
public class Main 
{
	
	
    public static void main( String[] args )
    		throws Exception {
    	
    	  
    	  Server server = new Server(9090);
    	  
    	  System.setProperty("org.apache.jasper.compiler.disablejsr199", "false");
    	  
//    	  QueuedThreadPool pool = new QueuedThreadPool();
//    	  pool.setMinThreads(10);
//    	  pool.setMaxThreads(10);
//    	  server.setThreadPool(pool);
//    	  SelectChannelConnector connector = new SelectChannelConnector();
//    	  connector.setPort(9090);
//    	  server.addConnector(connector);
//    	  HandlerList handlers = new HandlerList();
//    	  ResourceHandler resourceHandler = new ResourceHandler();
//    	  resourceHandler.setDirectoriesListed(true);
//    	  resourceHandler.setResourceBase("./webapp");
//    	  DefaultHandler defaultHandler = new DefaultHandler();
//    	  handlers.setHandlers(new Handler[]
//    	  {resourceHandler, defaultHandler});
//    	  server.setHandler(handlers);
    	  
    	  
    	  WebAppContext webapp = new WebAppContext();
    	  webapp.setContextPath("/");
    	  webapp.setWar("./webapp/test.war");
    	 server.setHandler(webapp);
    	 
 		
 		webapp.setParentLoaderPriority(true);
 				
 		server.setHandler(webapp); 		
    	 
    	 
    	 webapp.setAttribute("javax.servlet.context.tempdir","./webapp-temp");
    	 
//    	  WebAppContext context = new WebAppContext();
//    	  context.setDescriptor(webapp+"/WEB-INF/web.xml");
//    	  context.setResourceBase("./webapp");
//    	  context.setContextPath("/");
//    	  context.setParentLoaderPriority(true);
//    	 server.setHandler(context);
    	
//    	  context.setDescriptor(webapp+"/WEB-INF/web.xml");
//    	  context.setResourceBase("../test-jetty-webapp/src/main/webapp");
//    	  context.setContextPath("/");
//    	  context.setParentLoaderPriority(true);
//    	 server.setHandler(context);
    	 
    	 
    	  server.start();
    	  server.join();
    
    /*
    {
       
        int maxThreads = 100;
        int minThreads = 10;
        int idleTimeout = 120;
         
//        QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);
//        Server server = new Server(threadPool);
        Server server = new Server(9090);
       
        try {
        	
        	//////
        	////// For test: http://localhost:9090/context/blocking-service
        	ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/context", true, false);
            servletContextHandler.addServlet(BlockingServlet.class, "/blocking-service"); //blocking-service
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Hello World!" );
    }*/
    	  
    }
}
