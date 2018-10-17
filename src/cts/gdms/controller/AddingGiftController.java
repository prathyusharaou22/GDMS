package cts.gdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;

import cts.gdms.bo.AddingGiftBO;
import cts.gdms.exception.AddingGiftBusinessException;
import cts.gdms.exception.AddingGiftException;
import cts.gdms.vo.AddGiftVO;





public class AddingGiftController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG=Logger.getLogger(AddingGiftController.class);  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		if(request.getParameter("add")==null)
		{
			System.out.println("cam when null");
			
			LOG.info("Controller called for Autopapulate Gifttype and occasion type");
			final AddingGiftBO addingGiftBO=new AddingGiftBO();
			String url="";
			LOG.info("called BO method for auto papulation");
			List<String> giftTypeList;
			List<String> occasionList;
			try {
				giftTypeList = addingGiftBO.getGiftType();
				occasionList=addingGiftBO.getOccasionType();
				request.setAttribute("giftType", giftTypeList);
				request.setAttribute("occasionType", occasionList);
				url="/jsp/addgift.jsp";
			} catch (AddingGiftException e) {
				url="/jsp/addgifterror.jsp";
				LOG.error("autopopulation failed");
			} catch (AddingGiftBusinessException e) {
				url="/jsp/addgifterror.jsp";
				LOG.error("autopopulation failed");
			}
					
			LOG.info("forwording to addinfgift.jsp");
			final RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		
		
		}else
		{
			doPost(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
		
		String url="";
		LOG.info("Contadding gift details into the table");
		
		final HttpSession session=request.getSession();
		final String giftType=request.getParameter("giftType");
		final String otherType=request.getParameter("otherType");
		final String occasion=request.getParameter("occasion");
		final String otherOcasion=request.getParameter("otherOcasion");
		final String quantity=request.getParameter("quantity");
		final String cost=request.getParameter("cost");
		final String description=request.getParameter("giftDescription");
		
		System.out.println(giftType+" "+otherType+" "+occasion+" "+otherOcasion+" "+quantity+" "+cost+" "+ description+" ");
		LOG.info("request data set into VO object");
		final AddGiftVO addGiftVO=new AddGiftVO();
		addGiftVO.setGiftType(giftType);
		addGiftVO.setOccasion(occasion);
		
		if(occasion.equalsIgnoreCase("other")){
			addGiftVO.setOtherOcasion(otherOcasion);
		}
		
		
		if(giftType.equalsIgnoreCase("other")){
			addGiftVO.setOtherType(otherType);
		}
		
		addGiftVO.setQuantity(Integer.parseInt(quantity));
		addGiftVO.setCost(Integer.parseInt(cost));
		addGiftVO.setGiftDiscription(description);
		
		final AddingGiftBO addingGiftBO=new AddingGiftBO();
		
		LOG.info("BO method is called fro adding new gift details into DB");
		String status;
		try {
			status = addingGiftBO.addingGift(addGiftVO);
			final String message[]=status.split(" ");
			
			session.setAttribute("giftsubid", status);
			
			if("succes".equalsIgnoreCase(message[0]))
			{
				request.setAttribute("giftsubid", message[1]);
				LOG.info("Data added successfully");
				url="/jsp/agsuccess.jsp";
				
			}else if("fail".equalsIgnoreCase(message[0]))
			{
				LOG.error("Fail to add the data");			
				url="/jsp/agerrorpage.jsp";
			}
			
		} catch (AddingGiftException e) {
			// TODO Auto-generated catch block
			url="/jsp/addgifterror.jsp";
			LOG.error("addgift exception");
			
		} catch (AddingGiftBusinessException e) {
			// TODO Auto-generated catch block
			url="/jsp/addgifterror.jsp";
			LOG.error("addgiftbusiness exception");
		}
		
		
		
		final RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
		
	}

}
