package cts.gdms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Logger;
import cts.gdms.connection.ConnectionManager;
import cts.gdms.constants.SQLConstants;
import cts.gdms.exception.SearchException;

import cts.gdms.util.Currentdate;
import cts.gdms.util.SQLUtill;
import cts.gdms.vo.BookVO;
import cts.gdms.vo.BookingVO;
import cts.gdms.vo.SearchGiftVO;




public class GiftDAO {
          public static final Logger LOG=Logger.getLogger(GiftDAO.class);
	transient private Connection con;
	private List<String> list;
	private List<String> list2;
	private List<String> list3;
	private ResultSet rs4;
    ResultSet rs5;
	 public List<String> populateGiftTypes() throws SearchException
	 {
	
		 list2=new ArrayList<String>();
		 con=ConnectionManager.getConnection();
		 String sql1=SQLUtill.getSqlProperty(SQLConstants.GIFTTYPES);
		 try {
			Statement st=con.createStatement();
		    rs4=st.executeQuery(sql1);
		    LOG.info("gift types query executed");
		    while(rs4.next())
		    {
		    	list2.add(rs4.getString(1));
		    }	
		  
		} catch (SQLException e) {
			 throw new SearchException("Some exception occured while populating",e);
		}
		
		  return list2;
	 }
	 
	 
	 public List<String> populateOccassionTypes() throws SearchException
	 {
		 list3=new ArrayList<String>();
		 con=ConnectionManager.getConnection();
		 final String sql2=SQLUtill.getSqlProperty(SQLConstants.OCCASSIONTYPES);
		 try {
			Statement st=con.createStatement();
		    rs5=st.executeQuery(sql2);
		    LOG.info("occassion types query executed");
		    while(rs5.next())
		    {
		    	list3.add(rs5.getString(1));
		    	
		    }
		    
		} catch (SQLException e) {
			 throw new SearchException("Some exception occured while populating",e);
			 
		}
		  return list3;
	 }
	 public List<String> getGiftSubIds(SearchGiftVO searchvo) throws SearchException
	 {
	 con=ConnectionManager.getConnection();
	String giftType=searchvo.getGiftType();
	String Occassion=searchvo.getOccassionType();
    String sql1=SQLUtill.getSqlProperty(SQLConstants.GIFTID);
    String sql2=SQLUtill.getSqlProperty(SQLConstants.OCCASSIONID);
    String giftId=null;
    String occassionId=null;
    PreparedStatement pst1=null;
    PreparedStatement pst2=null;
    list=new ArrayList<String>();  
    
	  con=ConnectionManager.getConnection();
	try {
	    pst1=con.prepareStatement(sql1);
	    pst1.setString(1, giftType);
	    ResultSet rs1=pst1.executeQuery();
	    while(rs1.next())
	    {
	    giftId=rs1.getString(1);
	    }
	    pst2=con.prepareStatement(sql2);
	    pst2.setString(1,Occassion);
	    ResultSet rs2=pst2.executeQuery();
	    while(rs2.next())
	    {
	    occassionId=rs2.getString(1);
	    }
	    String sql3=SQLUtill.getSqlProperty(SQLConstants.GIFTSUBID);
	    PreparedStatement pst3=con.prepareStatement(sql3);
	    pst3.setString(1, giftId);
	    pst3.setString(2,occassionId);
	    ResultSet rs3=pst3.executeQuery();
	 
	     while(rs3.next())
	    {
	      list.add(rs3.getString(1));
	     }
	  } catch (SQLException e) {
		throw new SearchException("some exception occured while searching",e);
	}
	
	return list;
	 }
	 
	 public BookVO getGiftDetails(String giftsubId) throws SearchException
	 {
		BookVO bvo=new BookVO();
		con=ConnectionManager.getConnection();
		try {
			
			String sql4=SQLUtill.getSqlProperty(SQLConstants.QUANTITYCOSTGIFTID);
			PreparedStatement pst4=con.prepareStatement(sql4);
			pst4.setString(1, giftsubId);
			ResultSet rs4=pst4.executeQuery();    
			rs4.next();
			bvo.setAmount(rs4.getInt(1));
			bvo.setCost(rs4.getInt(2));
	    	bvo.setGiftId(rs4.getString(3));
			
		} catch (SQLException e) {
			 throw new SearchException("Some exception occured while fetching details",e);
		}
		
		 return bvo;
	}
	public String insertBookingDetails(BookingVO bookvo) throws SearchException
	{
	//	CustomerRegVO cus=new CustomerRegVO();
		
        Calendar call=new GregorianCalendar();
        Date d1=call.getTime();
        int onlyDate=call.get(Calendar.DATE);
        SimpleDateFormat sdff=new SimpleDateFormat("MMM");
        String onlyMonth=sdff.format(d1);
        String Booking_id=""+bookvo.getSubid()+""+onlyDate+onlyMonth;
		Connection con=ConnectionManager.getConnection();
		
		String sql1="select test302.nextval from dual";
		ResultSet rs=null;
		Integer p=null;
		try {
			Statement  st=con.createStatement();
		   	 rs=st.executeQuery(sql1);
		   	 rs.next();
		     p=rs.getInt(1);
		} catch (SQLException e) {
			throw new SearchException("Some exception occured while insertion",e);
		}
		String sql=SQLUtill.getSqlProperty(SQLConstants.INSERTBOOKDETAILS);
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			 pst.setString(1, Booking_id+p);
			 
			 pst.setString(2, bookvo.getToAddress());
			
			 pst.setString(3, bookvo.getPhoneNo());
			
			 pst.setString(4, bookvo.getSubid());
			
			 pst.setString(5, "ORDER IS BOOKED");
			 pst.setString(6, bookvo.getExpDateofDel());
			 pst.setString(7, "01-Jan-1970");
			 pst.setString(8, Currentdate.getdate());
			 pst.setInt(9, Integer.valueOf(bookvo.getNoofQuant()));
			 pst.setString(10, bookvo.getCustId());
			 pst.executeUpdate();
			 
			 String sql3=SQLUtill.getSqlProperty(SQLConstants.GIFTQUANTITY);
			 PreparedStatement st1=con.prepareStatement(sql3);
			 st1.setString(1, bookvo.getSubid());
			 ResultSet rs1=st1.executeQuery();
			 rs1.next();
			 int dquantity=rs1.getInt(1);

			int rquantity=Integer.parseInt(bookvo.getNoofQuant());
			 int squantity=(dquantity-rquantity);
			              
			          
			 String sql4=SQLUtill.getSqlProperty(SQLConstants.GIFTUPDQUANTITY);
			 PreparedStatement st2=con.prepareStatement(sql4);
			 st2.setInt(1,squantity);
			 st2.setString(2,bookvo.getSubid());
			 int i1=st2.executeUpdate();
			 
			   
			 
		
		} catch (SQLException e) {
			
			throw new SearchException("Some exception occured while insertion",e);
		}
		
		
	    return Booking_id+p;
		
		
		
	}

}


