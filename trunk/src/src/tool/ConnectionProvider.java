package src.tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * Cette classe intègre un pool de connexion et permet de récupérer des connexions de manière statique dans l'application
 * @author dyonysos
 *
 */
public class ConnectionProvider {
	private static PoolProperties poolProperties;
	private static DataSource dataSource;
	private static Log LOGGER = LogFactory.getLog(ConnectionProvider.class);
	private static String host;
	private static String db;
	private static String userName;
	private static String password;
	
	public static void initialise(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		poolProperties = new PoolProperties();
		poolProperties.setUrl("jdbc:mysql://"+host+"/"+db);
		poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
		poolProperties.setUsername(userName);
		poolProperties.setPassword(password);
		poolProperties.setValidationQuery("SELECT 1");
		dataSource = new DataSource(poolProperties);
	}
	
	/**
	 * Retourne une nouvelle Connection au serveur de base de données
	 * @return Connection
	 */
	public static Connection getConnection(){
		try {
			return ConnectionProvider.dataSource.getConnection();
		} catch (SQLException e) {
			LOGGER.error("Impossible d'obtenir une connexion",e);
			return null;			
		}
	}

	public static void setHost(String host) {
		ConnectionProvider.host = host;
	}

	public static void setDb(String db) {
		ConnectionProvider.db = db;
	}

	public static void setUserName(String userName) {
		ConnectionProvider.userName = userName;
	}


	public static void setPassword(String password) {
		ConnectionProvider.password = password;
	}
}
