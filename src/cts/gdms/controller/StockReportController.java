package cts.gdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cts.gdms.bo.DeliveryReportBO;
import cts.gdms.vo.StockReportvo;




public class StockReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		String url="";
		final DeliveryReportBO drboBo=new DeliveryReportBO();
		
	
		
		List<StockReportvo> strvo=null;
		strvo=drboBo.stockreport();
		
		if(strvo.isEmpty())
		{
		url="/jsp/drerrorpage.jsp";	
		}
		else
		{
		request.setAttribute("strvo", strvo);
		url="/jsp/drstockreportsuccess.jsp";
		
		}
		
		final RequestDispatcher rdDispatcher=request.getRequestDispatcher(url);
		rdDispatcher.forward(request,response);	
	}

	
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
