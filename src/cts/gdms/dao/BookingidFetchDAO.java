package cts.gdms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
//import java.sql.Statement;

import org.apache.log4j.Logger;
//import java.util.ArrayList;
//import java.util.List;
import cts.gdms.connection.ConnectionManager;
import cts.gdms.constants.SQLConstants;
import cts.gdms.exception.DeliveryException;


import cts.gdms.util.SQLUtill;
import cts.gdms.vo.UpdateBokkingVo;

public class BookingidFetchDAO {
	public static final Logger LOG = Logger.getLogger(BookingidFetchDAO.class);
	
	
	 //private transient PreparedStatement preparedStatement;
	
	
	
	public UpdateBokkingVo getBooking(final String bookingId) throws DeliveryException {
		//String query="SELECT BOOKING_ID,To_Address,Delivery_STATUS,ACTUAL_DATE_OF_DELIVERY,EXPECTED_DATE_OF_DELIVERY,phone_no,booking_date FROM gms_booking_gift WHERE booking_id=?";
		final String query=SQLUtill.getSqlProperty(SQLConstants.FETCH_BOOKING);
		
		ResultSet rs=null;
		final UpdateBokkingVo booking=new UpdateBokkingVo();
		 final Connection connection= ConnectionManager.getConnection();
		try{
			 
			final PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, bookingId);
			rs=preparedStatement.executeQuery();
			if (rs.next()) {               
				booking.setBookingId(rs.getString("BOOKING_ID"));
				booking.setToAddress(rs.getString("To_Address"));
				booking.setDeliveryStatus(rs.getString("Delivery_STATUS"));
				//System.out.println(rs.getString("Delivery_STATUS"));
				//booking.setActualDateOfDelivery(rs.getDate("ACTUAL_DATE_OF_DELIVERY").toString());
				//booking.setExpectedDateOfDelivery(rs.getDate("EXPECTED_DATE_OF_DELIVERY").toString());
				booking.setActualDateOfDelivery(rs.getString("ACTUAL_DATE_OF_DELIVERY"));
				booking.setExpectedDateOfDelivery(rs.getString("EXPECTED_DATE_OF_DELIVERY"));
				
				booking.setPhoneno(rs.getString("phone_no"));
				//booking.setBookingDate(rs.getDate("Booking_date").toString());
				booking.setBookingDate(rs.getString("Booking_date"));
				System.out.println("setting done");
				}
			
		}catch(SQLException s)
		{
			LOG.error("Details does not exist");
			throw new DeliveryException("Failed to get details", s);
		}
		finally{
			try{
			rs.close();
			ConnectionManager.close();
			
			
			}catch (SQLException s1){
				LOG.error("Failed To Close The Connection");
			}
		
		}
		
		return booking;
		
	}
	public boolean checkid(final String bookinId) throws DeliveryException {
		boolean msg = false;
		final Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet=null;
		//String sql1;
		//sql1="select * from gms_booking_gift where booking_id=?";
		final String sql1=SQLUtill.getSqlProperty(SQLConstants.CHECK_BOOKID);
		try {
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, bookinId);
			resultSet = preparedStatement.executeQuery();
			LOG.info("Query Executed");
			if (resultSet.next()) {
				LOG.info("Returning Method Is True Or False");
				System.out.println("query executed and entered if");
				msg = true;
			}
		} catch (SQLException e1) {

			LOG.error("Failed to Get The Details Of The Booking ID");
			throw new DeliveryException("Failed to get details", e1);
		} finally {

			try {
				connection.close();
				resultSet.close();
			} catch (SQLException e4) {

				LOG.error("Failed To Close The Connection");
			}

		}

		return msg;

	}
	
	/*public static void main(String[] args) {
		
		
		BookingidFetchDAO dao=new BookingidFetchDAO();
		
		Booking booking=dao.getBooking("100323aug2003");
		
		System.out.println(booking.getBookingId());
		System.out.println(booking.getDeliveryStatus());
		System.out.println(booking.getPhoneno());
		
	}*/
	

}

