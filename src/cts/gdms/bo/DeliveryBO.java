package cts.gdms.bo;

import org.apache.log4j.Logger;

import cts.gdms.dao.BookingidFetchDAO;
import cts.gdms.dao.UpdateDelStatusDAO;
import cts.gdms.exception.DeliveryBusinessException;
import cts.gdms.exception.DeliveryException;
import cts.gdms.vo.UpdateBokkingVo;



public class DeliveryBO  {
	public static final Logger LOG=Logger.getLogger(DeliveryBO.class);
	
	private transient final BookingidFetchDAO bidfdao=new BookingidFetchDAO();
	
	public UpdateBokkingVo getBooking(final String bookingId) throws DeliveryException,DeliveryBusinessException {
		
		return  bidfdao.getBooking(bookingId);
	}
	
	public String setUpdateStatus(final UpdateBokkingVo bookingVo)throws DeliveryException,DeliveryBusinessException{
		
		final UpdateDelStatusDAO udao=new UpdateDelStatusDAO();
		return udao.setUpdateStatus(bookingVo);
	}
	public final boolean checkId(final String bookingId) throws DeliveryException,DeliveryBusinessException {
		LOG.info("returning CheckID is true or false");
		return bidfdao.checkid(bookingId);

	}
	
	
	/*public static void main(String[] args) {
		
		DeliveryBO bo=new DeliveryBO();
		BookingVo booking =bo.getBooking("100323aug2003");
		UpdateDelStatusDAO udao1=new UpdateDelStatusDAO();
		udao1.setUpdateStatus(booking);
		
		
		//bo.getBooking("100323aug2003");
		System.out.println(booking.getBookingId());
		System.out.println(booking.getDeliveryStatus());
		System.out.println(booking.getPhoneno());
	}*/

}

