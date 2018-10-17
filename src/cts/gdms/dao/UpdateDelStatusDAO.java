package cts.gdms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
//import java.util.Date;

import cts.gdms.connection.ConnectionManager;
import cts.gdms.constants.SQLConstants;
import cts.gdms.exception.DeliveryException;

import cts.gdms.util.SQLUtill;
import cts.gdms.vo.UpdateBokkingVo;

//import cts.gdms.uddelivery.vo.BookingVo;

public class UpdateDelStatusDAO{
	public static final Logger LOG = Logger.getLogger(UpdateDelStatusDAO.class);
	//private transient Connection connection;
	//private transient Statement statement;
	//private transient PreparedStatement preparedStatement;
	  
	  public final String setUpdateStatus(final UpdateBokkingVo  bookingVo)  throws DeliveryException {
		 //String query="UPDATE gms_booking_gift SET actual_date_of_delivery = ?,delivery_status=? WHERE booking_id = ?";
		  final String query=SQLUtill.getSqlProperty(SQLConstants.UPDATE_DELIVERY);
		  String message="";
		 
			final Connection connection= ConnectionManager.getConnection();
			
			java.sql.Date actual_date=null;
			String  actualDateOfDelivery=null;
			java.util.Date date=null;
			final String aDate=bookingVo.getActualDateOfDelivery();
			try{
				final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				
				try {
					date = sdf.parse(aDate);
				} catch (ParseException e1) {
					LOG.info("cannot parse the date");
					throw new DeliveryException("enter proper date", e1);
				}
				final Calendar c = Calendar.getInstance();
				c.setTime(date);
				actualDateOfDelivery = sdf.format(c.getTime());
				
				try {
				final java.util.Date dd1 = sdf.parse(actualDateOfDelivery);
				actual_date = new java.sql.Date(dd1.getTime());
				 
				} catch (ParseException e) {
					LOG.info("cannot parse the date");
					throw new DeliveryException("enter proper date", e);
				 
				}  
				
				final PreparedStatement prest=connection.prepareCall(query);
				prest.setDate(1, actual_date);
				prest.setString(2, bookingVo.getDeliveryStatus());
				prest.setString(3, bookingVo.getBookingId());
				
				final int status=prest.executeUpdate();
				if(status==1)
				{
					LOG.info("success");
					message="success";
				}
				else
				{
					LOG.info("fail");
					message="fail";
				}
				
			}catch(SQLException e){
				LOG.info("Not able to insert the data");
				throw new DeliveryException("check the date entered and try again", e);
			}finally{
				try {
					ConnectionManager.close();
				} catch (Exception e) {
					LOG.info("not able to close connection");
				}
			}
		
		  return message;
	  }
	  /*public static void main(String[] args) {
			
			
		  UpdateDelStatusDAO udao=new UpdateDelStatusDAO();
		  
			
			udao.setUpdateStatus("100323aug2003","09/02/2013","pending");
			 
			
			//System.out.println(booking.getBookingId());
		//	System.out.println(booking.getDeliveryStatus());
			//System.out.println(booking.getPhoneno());
			
		}*/
}
