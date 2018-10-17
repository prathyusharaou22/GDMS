package cts.gdms.bo;

import java.util.List;

import org.apache.log4j.Logger;

import cts.gdms.dao.GiftDAO;
import cts.gdms.exception.SearchException;
import cts.gdms.vo.BookVO;
import cts.gdms.vo.BookingVO;





public class GiftDetailsBO {
	
	public static final Logger LOG=Logger.getLogger(GiftDetailsBO.class);
    public BookVO getGiftDetail(String giftsubId) throws SearchException
       {   
    	 final GiftDAO dao=new GiftDAO();
    	 final  BookVO bvo=dao.getGiftDetails(giftsubId);
    	 LOG.info("called method to generate Product IDs based on GiftType and OccassionType");
    	   return bvo;
       }
      public List<String> giftTypes() throws SearchException
      {
    	final GiftDAO dao1=new GiftDAO();
        final List<String>  giftTypess=dao1.populateGiftTypes();
        LOG.info("called method to populate giftTypes from database");
         return giftTypess;
      }
      public List<String> occassionTypes() throws SearchException
      {
    	  GiftDAO dao2=new GiftDAO();
         List<String>  occassionTypess=dao2.populateOccassionTypes();
         LOG.info("called method to populate OccassionTypes from database");
         return occassionTypess;
      }
      public String insertDetails(BookingVO bookvo) throws SearchException 
      {
    	  GiftDAO dao3=new GiftDAO();
         String bookingid=dao3.insertBookingDetails(bookvo);
         LOG.info("called method to insert booking details");
         return bookingid;
      }

}

