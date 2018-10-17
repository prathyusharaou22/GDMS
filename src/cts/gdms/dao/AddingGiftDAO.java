package cts.gdms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;



import cts.gdms.connection.ConnectionManager;
import cts.gdms.constants.SQLConstants;
import cts.gdms.exception.AddingGiftException;
import cts.gdms.util.GenerateID;
import cts.gdms.util.SQLUtill;
import cts.gdms.vo.AddGiftVO;

public class AddingGiftDAO {

	public static final Logger LOG=Logger.getLogger(AddingGiftDAO.class); 
	
	private transient Connection dbconnection;
	private transient PreparedStatement preparedStatement;
	private transient String sql;
	private transient ResultSet resultSet;

	public String addingGift(final AddGiftVO addGiftVO) throws AddingGiftException {

		
		String giftType="";
		String occasionType="";
		String gift_id="";
		String occasion_id="";
		String status="";
		
		if(addGiftVO.getOtherType()==null){
			
			LOG.info("selected already existing gift type");
			giftType=addGiftVO.getGiftType();
			
			gift_id=giftID(giftType);
			LOG.info("got gift id from DB");
			
			
		}else
		{
			

			LOG.info("to add new gift type called addnewGift( )");
			gift_id = addnewGIft(addGiftVO);
			
		}
		if(addGiftVO.getOtherOcasion()==null){
			
			LOG.info("selects already existing Occasion type");
			occasionType=addGiftVO.getOccasion();
			occasion_id=getOccasion(occasionType);
			
			LOG.info("got occasion id from DB");
			
			
			
		}else
		{
			LOG.info("to add new occassion type called addnewOccasion( )");
			occasion_id = addnewOccasion(addGiftVO);
			
		}
		System.out.println("came near query ");
		sql = SQLUtill.getSqlProperty(SQLConstants.INSERTGIFTSUBINFO);//SQL1
		System.out.println("sql--"+sql);
		final String gift_sub_id = GenerateID.getGiftSubID();
		LOG.info("gift sub id generated");

		try {
			dbconnection = ConnectionManager.getConnection();
			preparedStatement = dbconnection.prepareStatement(sql);

			preparedStatement.setString(1, gift_sub_id);
			preparedStatement.setInt(2, addGiftVO.getQuantity());
			preparedStatement.setInt(3, addGiftVO.getCost());
			preparedStatement.setString(4, gift_id);
			preparedStatement.setString(5, addGiftVO.getGiftDiscription());
			preparedStatement.setString(6, occasion_id);

			final int flag=preparedStatement.executeUpdate();
			if(flag==1)
			{
				status="succes"+" "+gift_sub_id;
				LOG.info("New gift is update success fully in DB");
			}else
			{
				status="fail"+" ";
				LOG.info("New gift is updatation failed");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("new Gift upadtion failed with gift su id");
			throw new AddingGiftException("new gift Updation failed",e);
			
		}

		finally
		{
			try {
				dbconnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("fail to close the connection");
			}
		}
		
		
		return status;
	}

	private String addnewOccasion(final AddGiftVO addGiftVO) {
		 //String occasionType="";
		//final String occasion_id;
		LOG.info("New Occasion Entered in the from");
		
		final String occasion_id= GenerateID.getOccasionID(addGiftVO.getOtherOcasion());
		//occasionType=addGiftVO.getOtherOcasion();
		LOG.info("new occasionId genarated");
		//final String sql2 = SQLUtill.getSqlProperty(SQLConstants.NEW_OCCASION_TYPE); //SQL2
		
		
		try {
			
			preparedStatement = dbconnection.prepareStatement(SQLUtill.getSqlProperty(SQLConstants.NEW_OCCASION_TYPE));
			preparedStatement.setString(1, occasion_id);
			preparedStatement.setString(2, addGiftVO.getOtherOcasion());

			final int flag=preparedStatement.executeUpdate();
			
			if(flag>0){
				LOG.info("new Occasion type is updated success fully");
				}else{
					LOG.error("new Occasion type is not addedd");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("new occasion type updation failed");
		}
		return occasion_id;
	}

	private String addnewGIft(final AddGiftVO addGiftVO) throws AddingGiftException {
		//final String giftType;
		//final String gift_id;
		LOG.info("New Gift type Entered in the from");
		
		
		//giftType = addGiftVO.getOtherType();
		
		final String gift_id = GenerateID.getGiftID(addGiftVO.getOtherType());
		
		LOG.info("new gift_id genarated");

		//final String sql1 = SQLUtill.getSqlProperty(SQLConstants.NEW_GIFT_TYPE);//SQL3

		try {
			dbconnection = ConnectionManager.getConnection();
			preparedStatement = dbconnection.prepareStatement(SQLUtill.getSqlProperty(SQLConstants.NEW_GIFT_TYPE));
			preparedStatement.setString(1, gift_id);
			preparedStatement.setString(2, addGiftVO.getOtherType());

			final int flag=preparedStatement.executeUpdate();
			
			if(flag>0){
			LOG.info("new gift Type is updated success fully");
			}else{
				LOG.error("new gift type is not addedd");
			}

		} catch (SQLException e) {
			
			LOG.error("new type of gift updation failed");
			throw new AddingGiftException("new gift updation failed", e);
		}
		return gift_id;
	}

	private String giftID(final String giftType) throws AddingGiftException {
		
		String giftId = null;
		
		LOG.info("called for get existing giftid");
		sql = SQLUtill.getSqlProperty(SQLConstants.GET_GIFT_ID);//SQL4

		try {
			dbconnection = ConnectionManager.getConnection();
			preparedStatement = dbconnection.prepareStatement(sql);

			preparedStatement.setString(1, giftType);

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {

				giftId = resultSet.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("failed to return gift id");
			throw new AddingGiftException("fail to return gift id", e);
		}

		
		return giftId;
	}

	private String getOccasion(final String occasion) throws AddingGiftException {
		String occasionId = null;

		
		LOG.info("called for get existing OccasionID");
		//final String sql = SQLUtill.getSqlProperty(SQLConstants.GET_OCASION_ID);//SQL5

		try {
			dbconnection = ConnectionManager.getConnection();
			preparedStatement = dbconnection.prepareStatement(SQLUtill.getSqlProperty(SQLConstants.GET_OCASION_ID));

			preparedStatement.setString(1, occasion);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				occasionId = resultSet.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("failed to rtuen occasion id");
			throw new AddingGiftException("fail to return occasion id", e);
		}

		
		return occasionId;	
	}

	public List<String> getGiftType() throws AddingGiftException{
		
		
		
		LOG.info("Called for Gift type auto papulation");
		
		sql=SQLUtill.getSqlProperty(SQLConstants.POPULATEGIFT);//SQL6
		
		
		return getTypeList(sql);
		
	}

	private List<String> getTypeList(final String sql) throws AddingGiftException 
	{
		
		final ArrayList<String> typeList=new  ArrayList<String>();
		
		try {
			dbconnection=ConnectionManager.getConnection();
			preparedStatement=dbconnection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				typeList.add(resultSet.getString(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("autopapulation og gift id failed");
			throw new AddingGiftException("gift type auto population failed", e);
		}
		
		finally
		{
			try {
				dbconnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("failed to close connection");
			}
		}
		return typeList;
	}
	
public List<String> getOccasionType() throws AddingGiftException{
		
		
		
		LOG.info("Called for Occasion type auto papulation");
		
		sql=SQLUtill.getSqlProperty(SQLConstants.POPULATEOCCASION);//SQL1
		
		return getTypeList(sql);
		
	}
	
	
	 

}






