package cts.gdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import cts.gdms.bo.DeliveryReportBO;
import cts.gdms.exception.DeliveryReportException;
import cts.gdms.vo.DeliveryReportvo;
;


public class DeliveryReportController extends HttpServlet {
	public static final Logger LOG=Logger.getLogger(DeliveryReportController.class);
	private static final long serialVersionUID = 1L;

    
   

	
	protected void doGet(final HttpServletRequest request,final  HttpServletResponse response) throws ServletException, IOException {
		final DeliveryReportBO drboBo=new DeliveryReportBO();
		LOG.info("getting fromdate and to date from database");
		String url=null;
		final  String fdate=request.getParameter("fromDate");
		final String tdate=request.getParameter("toDate");
		final DeliveryReportvo deliveryvo=new DeliveryReportvo();
		LOG.info("setting fromdate and to date");
		
		deliveryvo.setFromDate(fdate);
		deliveryvo.setToDate(tdate);
		List<String> giftsubs = null;
		List<Integer> beforeexpected = null;
		List<Integer> onexpected = null;
		List<Integer> afterexpected = null;
		List<Integer> bkdgift = null;
		try {
			System.out.println("entered into try");
			giftsubs = drboBo.giftsub(deliveryvo);
			bkdgift=drboBo.noofgiftsbooked(deliveryvo);
			beforeexpected=drboBo.noofgiftsdeliveredbeforeexpected(deliveryvo);
			onexpected=drboBo.noofgiftsdeliveredonexpected(deliveryvo);
			afterexpected=drboBo.noofgiftsdeliveredafterexpected(deliveryvo);
			
		} catch (DeliveryReportException e) {
			// TODO Auto-generated catch block
			LOG.error("");
		}catch (NullPointerException e){
			LOG.error(e);
		}
		
		if(giftsubs.isEmpty())
		{
			LOG.info("if there are no reports between the time span");
			url="/jsp/drerrorpage.jsp";
		}
		else
		{
			LOG.info("setting the reports");
		request.setAttribute("giftsubs",giftsubs);
		request.setAttribute("bkdgift",bkdgift);
		request.setAttribute("beforeexpected", beforeexpected);
		request.setAttribute("onexpected", onexpected);
		request.setAttribute("afterexpected", afterexpected);
		url="/jsp/deliveryreportsuccess.jsp";
		}
		final RequestDispatcher rdDispatcher=request.getRequestDispatcher(url);
		rdDispatcher.forward(request,response);
	}

	
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
