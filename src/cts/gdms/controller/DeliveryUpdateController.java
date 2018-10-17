package cts.gdms.controller;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cts.gdms.bo.DeliveryBO;
import cts.gdms.exception.DeliveryBusinessException;
import cts.gdms.exception.DeliveryException;
import cts.gdms.vo.UpdateBokkingVo;




public class DeliveryUpdateController extends HttpServlet {
	public static final Logger LOG=Logger.getLogger(DeliveryUpdateController.class);
	private static final long serialVersionUID = 1L;

    
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
	}

	
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		final HttpSession session=request.getSession();
		String url="";
		if(request.getParameter("book")!=null){
			System.out.println("enter if");
			final DeliveryBO deliveryBO=new DeliveryBO();
			final String bookingId=request.getParameter("bookid");
			UpdateBokkingVo bookingVo;
			try {
				System.out.println("entered try......");
				if(deliveryBO.checkId(bookingId)){
				bookingVo = deliveryBO.getBooking(bookingId);
				session.setAttribute("bookvo", bookingVo);
				url="/jsp/upsdisplay.jsp";
				}else{
					url="/jsp/upsdeliveryfailure.jsp";
				}
			} catch (DeliveryException e) {
				// TODO Auto-generated catch block
				LOG.info("page does not exist");
			} catch (DeliveryBusinessException e) {
				// TODO Auto-generated catch block
				LOG.info("page does not exist");
			}
			//session.setAttribute("bookvo", bookingVo);
			//url="/jsp/display.jsp";
			}else if(request.getParameter("update")!=null){
			
			final String bookingId=request.getParameter("bookingId");
			final String toaddress=request.getParameter("toAddress");
			final String status=request.getParameter("deliveryStatus");
			final String edd=request.getParameter("expectedDateOfDelivery");
			final String phoneNo=request.getParameter("phoneno");
			final String bdate=request.getParameter("bookingDate");
			final String add=request.getParameter("actualDateOfDelivery");
			
			final UpdateBokkingVo bookingVo=new UpdateBokkingVo();
			bookingVo.setBookingId(bookingId);
			bookingVo.setToAddress(toaddress);
			bookingVo.setDeliveryStatus(status);
			bookingVo.setBookingDate(bdate);
			bookingVo.setExpectedDateOfDelivery(edd);
			bookingVo.setActualDateOfDelivery(add);
			bookingVo.setPhoneno(phoneNo);
			
						
			final DeliveryBO deliveryBO=new DeliveryBO();
			
			String message;
			try {
				message = deliveryBO.setUpdateStatus(bookingVo);
				System.out.println(message);
				LOG.info(message);
				if("success".equalsIgnoreCase(message)){
					url="/jsp/upsdeliverysuccess.jsp";
				}else{
					url="/jsp/upsupdatefailure.jsp";
				}
			} catch (DeliveryException e) {
				LOG.info("Not able to insert the data");
			} catch (DeliveryBusinessException e) {
				
				LOG.info("business validation check");
			}
			
		//	LOG.info(message);
			}
		final RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		}
}

