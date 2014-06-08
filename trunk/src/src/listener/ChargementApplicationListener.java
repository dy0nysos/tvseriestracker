package src.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import src.tool.BeanProvider;
import src.tool.ConnectionProvider;

public class ChargementApplicationListener implements ServletContextListener {

	private static final Log LOGGER = LogFactory.getLog(ChargementApplicationListener.class);
	private Properties prop;

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.info("Démarrage du context");
		initProperties();
		BeanProvider.applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		try{
			BeanProvider.getBean("monBean");
		}catch(Exception e){
			LOGGER.error(e);
		}
		initDB();
		LOGGER.info("Context démarré");
	}
	
	private void initDB(){
		LOGGER.info("Démarrage du pool de connexion");
		if(prop != null && !prop.isEmpty()){
			String host = prop.getProperty("dbhost");
			String db = prop.getProperty("db");
			String username = prop.getProperty("dbuser");
			String password= prop.getProperty("dbpasswd");
			ConnectionProvider.setHost(host);
			ConnectionProvider.setDb(db);
			ConnectionProvider.setUserName(username);
			ConnectionProvider.setPassword(password);
			ConnectionProvider.getConnection();
		}
		LOGGER.info("Pool démarré");
	}
	private void initProperties(){
		LOGGER.info("Lecture du fichier de parametrage");
		InputStream is = null;
		prop = new Properties();
		try {
			//Le contextClassLoader nous fait démarrer de WEB-INF/classes. Le fichier de config est au dessus dans WEB-INF => ../application.properties
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream("../application.properties");
			prop.load(is);
		} catch (FileNotFoundException fnfe) {
			LOGGER.warn("Impossible de trouver le fichier de config",fnfe);
		} catch (IOException ioe) {
			LOGGER.warn("Impossible de lire le fichier de config",ioe);
		}
	}

}
