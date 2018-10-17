package cts.gdms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import cts.gdms.connection.ConnectionManager;
import cts.gdms.constants.SQLConstants;
import cts.gdms.exception.DeliveryReportException;


import cts.gdms.util.*;
import cts.gdms.vo.DeliveryReportvo;
import cts.gdms.vo.StockReportvo;

public class DeliveryreportDAO {
	public String fromDate;
	public String toDate;
	private transient Connection con;

	private transient ResultSet result;
	public static final Logger LOG=Logger.getLogger(DeliveryreportDAO.class);
	public final List<String> giftsubid(final DeliveryReportvo reportvo) throws DeliveryReportException {
		PreparedStatement pstmt1;
		String sql1;
		
		final List<String> list1 = new ArrayList<String>();
		con = ConnectionManager.getConnection();
		

		
		sql1 = SQLUtill.getSqlProperty(SQLConstants.DR_GIFTSUBID);
		
		try {
			
			pstmt1 = con.prepareStatement(sql1);
			System.out.println("pstmy"+pstmt1);
			LOG.info("from date and todate setting");
			pstmt1.setString(1, getdate(reportvo.getFromDate()));
			pstmt1.setString(2, getdate(reportvo.getToDate()));
			result = pstmt1.executeQuery();
			while (result.next()) {
				LOG.info("adding fromdate and todate to get giftSubId");
				System.out.println("result.getString(1)--"+result.getString(1));
				list1.add(result.getString(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("failed to get fromdate and todate from database to get giftsubid");
			throw new DeliveryReportException("failed to get fromdate and todate from database ",e);
		}

		return list1;

	}

	public final List<Integer> noofgiftsbooked(final DeliveryReportvo reportvo) throws DeliveryReportException {
		PreparedStatement pstmt2;
		String sql2;
		con = ConnectionManager.getConnection();
		final List<Integer> list2 = new ArrayList<Integer>();
		LOG.info("method getdate is called for changing the date to proper format ");
		
		

		
		sql2 = SQLUtill.getSqlProperty(SQLConstants.DR_BOOKEDGIFTS);

		try {
			
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, getdate(reportvo.getFromDate()));
			pstmt2.setString(2, getdate(reportvo.getToDate()));
			result = pstmt2.executeQuery();

			while (result.next()) {
				LOG.info("adding fromdate and todate to get no: of gifts booked");
				list2.add(result.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("failed to get fromdate and todate to get noofgiftsbooked");
			throw new DeliveryReportException("fail to get fromdate and todate from database",e);
		}
	
		return list2;

	}

	final public List<Integer> noofgiftsdeliveredbeforeexpecteddate(final DeliveryReportvo reportvo) throws DeliveryReportException {
		PreparedStatement pstmt3;
		String sql3;
		con = ConnectionManager.getConnection();
	final List<Integer> list3 = new ArrayList<Integer>();
		LOG.info("method getdate is called ");
	
		sql3 = SQLUtill.getSqlProperty(SQLConstants.DR_BFOREEXPECTED);
		try {
			pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1, getdate(reportvo.getFromDate()));
			pstmt3.setString(2, getdate(reportvo.getToDate()));
			pstmt3.setString(3, getdate(reportvo.getFromDate()));
			pstmt3.setString(4,getdate(reportvo.getToDate()));
			
			
			result = pstmt3.executeQuery();

			while (result.next()) {
				LOG.info("adding fromdate and todate to get no: of gifts delivered before extected date");
				list3.add(result.getInt(1));
			}
		} catch (SQLException e) {
			
			LOG.error("failed to get fromdate and todate to get giftsdeliveredbeforeexpected");
			throw new DeliveryReportException("failed getting fromdate and todate from database",e);
		}

		return list3;

	}

	final public List<Integer> noofgiftsdeliveredonexpecteddate(final DeliveryReportvo reportvo) throws DeliveryReportException {
		PreparedStatement pstmt4;
		String sql4;
		con = ConnectionManager.getConnection();
		final List<Integer> list4 = new ArrayList<Integer>();
		
		sql4 = SQLUtill.getSqlProperty(SQLConstants.DR_ONEXPECTED);
		try {
			pstmt4 = con.prepareStatement(sql4);
			pstmt4.setString(1, getdate(reportvo.getFromDate()));
			pstmt4.setString(2, getdate(reportvo.getToDate()));
			pstmt4.setString(3, getdate(reportvo.getFromDate()));
			pstmt4.setString(4, getdate(reportvo.getToDate()));

			result = pstmt4.executeQuery();

			while (result.next()) {
				LOG.info("adding fromdate and todate to get no: of gifts delivered on extected date");
				list4.add(result.getInt(1));
			}
		} catch (SQLException e) {
			
			LOG.error("failed to get fromdate and todate to get giftsdeliveredonexpected");
			throw new DeliveryReportException("failed in getting fromdate and todate from database",e);
		}

		return list4;

	}

	final public List<Integer> noofgiftsdeliveredafterexpecteddate(final DeliveryReportvo reportvo) throws DeliveryReportException {
		PreparedStatement pstmt5;
		String sql5;
		con = ConnectionManager.getConnection();
		final List<Integer> list5 = new ArrayList<Integer>();
		LOG.info("method getdate is called for changing the date to proper format");
		
		sql5 = SQLUtill.getSqlProperty(SQLConstants.DR_AFTEREXPECTED);

		try {
			pstmt5 = con.prepareStatement(sql5);
			pstmt5.setString(1, getdate(reportvo.getFromDate()));
			pstmt5.setString(2, getdate(reportvo.getToDate()));
			pstmt5.setString(3, getdate(reportvo.getFromDate()));
			pstmt5.setString(4, getdate(reportvo.getToDate()));

			result = pstmt5.executeQuery();
			while (result.next()) {
				LOG.info("adding fromdate and todate to get no: of gifts delivered after extected date");
				list5.add(result.getInt(1));
			}
		} catch (SQLException e) {
			
			LOG.error("failed to get fromdate and todate to get giftsdeliveredafterexpected");
			throw new DeliveryReportException("fail to get from date and to date from database",e);
		} 
		return list5;

	}

	
	
	final private String getdate(final String date) {
		String rtdate = "";
		final String message[]=date.split("/");
		final String date1=message[1]+"/"+message[0]+"/"+message[2];
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date rdate;
		try {
			final String date2=date1.toString();
			rdate = sdf.parse(date2);
			rtdate=sdf.format(rdate);
		} catch (ParseException e) {
			
			
			LOG.error("date can't be parsed");
		}
		
		
	
		return rtdate;
	}

	final public List<StockReportvo> stockreport()
	{
		con = ConnectionManager.getConnection();
		 
		
		String sql6;
		 final List<StockReportvo> stockreport=new ArrayList<StockReportvo>();
		sql6=SQLUtill.getSqlProperty(SQLConstants.SR_REMAININGSTOCK);
		
		try {
			final PreparedStatement pstmt6=con.prepareStatement(sql6);
			
			result= pstmt6.executeQuery();
			while(result.next()){
				
				final StockReportvo  stockrvo1=new StockReportvo();
				
				stockrvo1.setGiftsubid(result.getString(1));
				stockrvo1.setGiftdescription(result.getString(2));
				stockrvo1.setQuantity(result.getInt(3));
				stockrvo1.setCost(result.getInt(4));
				
				stockreport.add(stockrvo1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("sql exception caught");
		}
		
		return stockreport;
		
	}	
	
	/*public static void main(String[] args) { 
		  DeliveryreportDAO dao=new DeliveryreportDAO(); 
	  List<StockReportvo> list=dao.stockreport(10);
	  {
		  for(StockReportvo s:list)
		System.out.println(s.giftdescription+" "+s.giftsubid+" "+s.quantity);
	  }
	  }*/
}
