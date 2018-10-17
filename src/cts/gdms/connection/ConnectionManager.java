package cts.gdms.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cts.gdms.util.JdbcUtil;


public final class ConnectionManager {
	//public static final Logger LOG=Logger.getLogger(ConnectionManager.class); 
	private static Connection connection;
	
	private ConnectionManager()
	{
		
	}
	
	/**
	 * This method will be used to establish connection with database
	 * @return connection
	 */
	public static Connection getConnection(){
	System.out.println("Called to give connection");
		
		final String driver=JdbcUtil.getProperty("driver");
		final String url=JdbcUtil.getProperty("url");
		final String user=JdbcUtil.getProperty("user");
		final String password=JdbcUtil.getProperty("password");
		System.out.println(driver);
		try {
			
				Class.forName(driver);
				connection=DriverManager.getConnection(url, user, password);
				System.out.println(connection+"entered");
		
		}	
		 catch (SQLException e) 
		{
			System.out.println("failed to give connection");
			//LOG.error("fail to give connection");
		} catch (ClassNotFoundException e)
		{
			System.out.println("failed to find class");
			//LOG.error("fail to find the class");
		}
		return connection;
		}
	
	/**
	 * This method is used to close the connection variable
	 */
	public static void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//LOG.error("fail to close the Connection");
		}
	}
	/*public static void main(String[] args) throws SQLException {
		
		Connection con= ConnectionManager.getConnection();
		
	PreparedStatement stmt = con.prepareStatement("SELECT id,title FROM interntype");
	
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
			    int x = rs.getInt("id");
			    String s = rs.getString("title");
			    System.out.println(x+"----"+s);
			}
			System.out.println(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			stmt.close();
			con.close();
		}
	}*/
	
		
}
