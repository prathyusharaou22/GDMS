package cts.gdms.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import org.apache.log4j.Logger;

import cts.gdms.addgift.bo.AddingGiftBO;
import cts.gdms.connection.ConnectionManager;
import cts.gdms.constants.SQLConstants;

public final class GenerateID {
	
	

	public static final Logger LOG=Logger.getLogger(AddingGiftBO.class); 
	
	private static Connection dbConnection;
	private static String uniqID;
	private static Statement statement;
	//private static String sql;
	private static ResultSet resultSet;
	private static int sequence;
	
	private GenerateID()
	{
		
	}

	public static String getGiftID(final String giftType) {
		//int sequence = 1200;
		//int sequence = 0;
		LOG.info("Called for genarate new Gift id");
		dbConnection = ConnectionManager.getConnection();
		//sql = SQLUtill.getSqlProperty(SQLConstants.GENGIFTID);//sql7

		try {
			statement = dbConnection.createStatement();

			resultSet = statement.executeQuery(SQLUtill.getSqlProperty(SQLConstants.GENGIFTID));
			if(resultSet.next()) {

				sequence = resultSet.getInt(1);

			}

			//sequence += count;
			
			final String gtype = giftType.substring(0, 3);
			System.out.println("gifttype--"+gtype);
			final StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(gtype);
			stringBuffer.append(sequence);

			uniqID = stringBuffer.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.warn("failed to genarate Gift id");
		} finally {

			try {
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("new Gift type id is not genarated");
			}

		}
		System.out.println("uniqID---"+uniqID);
		return uniqID;
	}

	public static String getOccasionID(final String giftType) {
		//int sequence = 100;
		//int sequence = 0;
		LOG.info("Called for genarate new Ocassion id");
		dbConnection = ConnectionManager.getConnection();
		//sql = SQLUtill.getSqlProperty(SQLConstants.GENOCCASID);//sql8

		try {
			statement = dbConnection.createStatement();

			resultSet = statement.executeQuery(SQLUtill.getSqlProperty(SQLConstants.GENOCCASID));
			while (resultSet.next()) {

				sequence = resultSet.getInt(1);

			}

			

			final String gtype = giftType.substring(0, 5);
			//sequence =sequence+count;
			
			final StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(gtype).append(sequence);

			uniqID = stringBuffer.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("falied to generate");
		} 
		return uniqID;
	}

	public static String getGiftSubID() {
		//int sequence = 1000;
		//int count = 0;
		LOG.info("Called for genarate new Gift_sub_id");
		dbConnection = ConnectionManager.getConnection();
		//sql = SQLUtill.getSqlProperty(SQLConstants.GENGIFTSUBID);//sql9

		try {
			statement = dbConnection.createStatement();

			resultSet = statement.executeQuery(SQLUtill.getSqlProperty(SQLConstants.GENGIFTSUBID));
			while (resultSet.next()) {

				sequence = resultSet.getInt(1);

			}

			//sequence += count;

			uniqID = String.valueOf(sequence);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("failed to genarate gift sub id");
			
		} 

		

		return uniqID;
	}

	
	/* public static void main(String[] args) {
	 
	 System.out.println(GenerateID.getGiftID("schecking"));
	 
	 System.out.println(GenerateID.getOccasionID("schecking"));
	 
	 System.out.println(GenerateID.getGiftSubID()); }*/
	

}
