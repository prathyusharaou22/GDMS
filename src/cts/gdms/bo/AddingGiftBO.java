package cts.gdms.bo;

import java.util.List;

import org.apache.log4j.Logger;

import cts.gdms.dao.AddingGiftDAO;
import cts.gdms.exception.AddingGiftBusinessException;
import cts.gdms.exception.AddingGiftException;
import cts.gdms.vo.AddGiftVO;




public class AddingGiftBO {

	public static final Logger LOG=Logger.getLogger(AddingGiftBO.class); 
	private transient AddingGiftDAO addingGiftDAO;
 
 
 public String addingGift(final AddGiftVO addGiftVO) throws AddingGiftException,AddingGiftBusinessException
 {
	 LOG.info("addinggift method called  IN BO for adding gift details");
	 addingGiftDAO=new AddingGiftDAO();
	 return addingGiftDAO.addingGift(addGiftVO);
	 
 }
 
 public List<String> getGiftType() throws AddingGiftException,AddingGiftBusinessException
 {
	 LOG.info("getGifttype called IN BO for the autopapulate gift type from DB");
	 addingGiftDAO=new AddingGiftDAO();
	 
	 return addingGiftDAO.getGiftType();
	 
	 
	 
 }
	
 public List<String> getOccasionType()throws AddingGiftException,AddingGiftBusinessException
 {
	 LOG.info("getoccasiontype called IN BO for the autopapulate occasionId from DB");
	 addingGiftDAO=new AddingGiftDAO();
	 
	 return addingGiftDAO.getOccasionType();
	 
	 
	 
 }	
 

}
