package cts.gdms.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import cts.gdms.bo.Checkstatusbo;
import cts.gdms.exception.CheckstatusBusinessException;
import cts.gdms.exception.CheckstatusException;
import cts.gdms.vo.Checkstatusvo;



/**
 * Servlet implementation class Checkstatuscontroller
 */
public class Checkstatuscontroller extends HttpServlet {

	public static final Logger LOG = Logger
			.getLogger(Checkstatuscontroller.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final Checkstatusvo cvo = new Checkstatusvo();
		cvo.setBookingid(request.getParameter("bookid"));
		final String bookingId = request.getParameter("bookid");
		final Checkstatusbo checkstatusbo = new Checkstatusbo();
		try {
			if (checkstatusbo.checkId(bookingId)) {
				LOG.info("checking id for valid id or not from database");
				final Checkstatusvo checkstatusvo = checkstatusbo
						.checkstatus(cvo);
				request.setAttribute("checkvo", checkstatusvo);
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher("/jsp/checkstatusuccess.jsp");
				dispatcher.forward(request, response);

			} else {
				System.out.println("error");
				LOG.info("User Entered InValid Booking ID");
				response.sendRedirect("jsp/checkstatuserror.jsp");

				LOG.info("error message sent to the jsp page");
			}
		} catch (CheckstatusException e) {
			LOG.warn("Exception occured due to geeting details of Booking ID");

		} catch (CheckstatusBusinessException e) {
			LOG.warn("Business Exception occured due to geeting details of Booking ID");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}

}
