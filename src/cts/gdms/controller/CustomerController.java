package cts.gdms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cts.gdms.bo.CustomerRegBO;
import cts.gdms.exception.CustomerBusinessException;
import cts.gdms.exception.CustomerException;
import cts.gdms.vo.CustomerRegVO;
import cts.gdms.vo.LoginVO;



/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {
		
		final CustomerRegBO cbo = new CustomerRegBO();
		final HttpSession session = request.getSession();
		RequestDispatcher rDispatcher;
		final CustomerRegVO cvo = (CustomerRegVO) session.getAttribute("customer");
		String url = "";

		String temp;
		try {
			System.out.println("customer reg cont try");
			temp = cbo.insertDataBO(cvo);
			final String data[] = temp.split(" ");
			System.out.println(data[1]+"hello ");
			session.setAttribute("custID", data[1]);   
			if ("succes".equalsIgnoreCase(data[0])) {
				url = "/jsp/crsuccess.jsp";
				rDispatcher = request.getRequestDispatcher(url);
				rDispatcher.forward(request, response);
			} 
			else if("email exists".equalsIgnoreCase(temp))
			{
				url = "/jsp/CustomerReg.jsp";
				rDispatcher = request.getRequestDispatcher(url);
				request.setAttribute("message","Email already exists,please enter new one");
				rDispatcher.forward(request, response);
			}
			else
			{
			doPost(request, response)	;
			}
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			url="/jsp/crerror.jsp";
		} catch (CustomerBusinessException e) {
			
			// TODO Auto-generated catch block
			url="/jsp/gdmshome.jsp";
		}
	}

	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		String url="";
		HttpSession session=request.getSession();
		final LoginVO loginVO=new LoginVO();
		System.out.println(request.getParameter("userName")+"---user");
		loginVO.setEmailId(request.getParameter("userName"));
		loginVO.setPassword(request.getParameter("passWord"));
		final CustomerRegBO customerRegBO=new CustomerRegBO();
		String type;
		try {
			System.out.println("entered to try");
			type = customerRegBO.loginCheck(loginVO);
			System.out.println("type--"+type);
			String fname[]=type.split("");
			System.out.println("cont"+fname[0]);
			
			
			if("C".equalsIgnoreCase(fname[0].trim()))
			{
				url="/jsp/crcustbook.jsp";
				session.setAttribute("type",fname[2]);
				//session.setAttribute("custID", fname[3]);
				rDispatcher=request.getRequestDispatcher(url);
				rDispatcher.forward(request, response);
			}
			else if("A".equalsIgnoreCase(fname[0].trim()))
			{
				System.out.println("entered into admin");
				session.setAttribute("type","Admin");
				url="/jsp/cradminpage.jsp";
				rDispatcher=request.getRequestDispatcher(url);
				rDispatcher.forward(request, response);
			}
			else
			{
				url="/jsp/crerror.jsp";
				rDispatcher=request.getRequestDispatcher(url);
				rDispatcher.forward(request, response);
			}
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			url="/jsp/crerror.jsp";
		} catch (CustomerBusinessException e) {
			// TODO Auto-generated catch block
			url="/jsp/gdmshome.jsp";
		}
	}
}