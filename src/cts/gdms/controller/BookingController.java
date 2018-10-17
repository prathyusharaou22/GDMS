package cts.gdms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cts.gdms.bo.GiftDetailsBO;
import cts.gdms.exception.SearchException;
import cts.gdms.vo.BookingVO;





/**
 * Servlet implementation class BookingController
 */
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final Logger LOG=Logger.getLogger(BookingController.class);  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GiftDetailsBO bo1=new GiftDetailsBO();
        HttpSession session=request.getSession();
        final BookingVO bookvo=(BookingVO)session.getAttribute("bookvo");
        String s=(String)session.getAttribute("custID");
      
        System.out.println(s+" ");
        bookvo.setCustId(s);
        String b1=null;
		try {
			b1 = bo1.insertDetails(bookvo);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RequestDispatcher r=null;
        if(b1!=null)
        {
        request.setAttribute("bookingid",b1);
        String temp1=(String)session.getAttribute("customer23");
        request.setAttribute("cust", temp1);
        session.removeAttribute("searchvo");
        r=request.getRequestDispatcher("/jsp/gbsuccess.jsp");
        r.forward(request,response);
        LOG.info("Success page called");
     
 		 }
        else
        {
        	r=request.getRequestDispatcher("/jsp/gbError.jsp");
        	r.forward(request,response);
        	LOG.info("Error page called");
        }
	}
}
