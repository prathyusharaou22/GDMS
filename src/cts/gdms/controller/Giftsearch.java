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

import cts.gdms.bo.GiftDetailsBO;
import cts.gdms.dao.GiftDAO;
import cts.gdms.exception.SearchException;
import cts.gdms.vo.BookVO;
import cts.gdms.vo.SearchGiftVO;






/**
 * Servlet implementation class Giftsearch
 */
public class Giftsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  final Logger LOG=Logger.getLogger(Giftsearch.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Giftsearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stud
		RequestDispatcher rdispatcher;
		String subid=request.getParameter("req");
	    GiftDetailsBO bo=new GiftDetailsBO();
		if(subid!=null)
		{
			  RequestDispatcher rdispatcherr;
		      BookVO bvo=null;
			try {
				bvo = bo.getGiftDetail(subid);
			} catch (SearchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      request.setAttribute("bvo", bvo);
		      request.setAttribute("subid", subid);
		      rdispatcherr=request.getRequestDispatcher("/jsp/bookgift.jsp");
		      
		      LOG.info("called jsp of for booking gift");
		      rdispatcherr.forward(request, response);
		}
		GiftDAO dao=new GiftDAO();
		HttpSession session=request.getSession();
		SearchGiftVO searchvo=(SearchGiftVO)session.getAttribute("searchvo");
		List<String> giftTypes=null;
		try {
			giftTypes = bo.giftTypes();
		} catch (SearchException e) {
			LOG.info("exception occured while populating giftTypes");
		}
		List<String> occassionTypes=null;
		try {
			occassionTypes = bo.occassionTypes();
		
		} catch (SearchException e) {
			             LOG.info("exception occured while populating occassionTypes");	
			             LOG.info("exception occured while populating productIDs");
		                 rdispatcher=request.getRequestDispatcher("/jsp/gbError.jsp");
		   			  rdispatcher.forward(request,response);
			             
		     }
		if(searchvo==null)
		{
		session.setAttribute("gifttypes", giftTypes);
		session.setAttribute("occasiontypes",occassionTypes);
		rdispatcher=request.getRequestDispatcher("/jsp/searchgift.jsp");
		
		rdispatcher.forward(request, response);
		}
		else if(searchvo!=null && subid==null)
		{
	
		List<String> listsubid=null;
		try {
			listsubid = dao.getGiftSubIds(searchvo);
		    } catch (SearchException e) {
		                 LOG.info("exception occured while populating productIDs");
		                 rdispatcher=request.getRequestDispatcher("/jsp/gbError.jsp");
		   			  rdispatcher.forward(request,response);
			
	        	}
		  if(listsubid!=null)
		  {
		session.setAttribute("listsub", listsubid);
		rdispatcher=request.getRequestDispatcher("/jsp/giftsort.jsp");
		rdispatcher.forward(request, response);
		LOG.info("sorting gift jsp page called");
		  }else
		  {
			  rdispatcher=request.getRequestDispatcher("/jsp/gbError.jsp");
			  rdispatcher.forward(request,response);
			  LOG.info("error page while searching has been called");
		  }
		  
		}
	
	}

}
