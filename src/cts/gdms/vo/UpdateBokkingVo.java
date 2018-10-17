package cts.gdms.vo;

public class UpdateBokkingVo {
	private String bookingId;
	private String toAddress;
	private String deliveryStatus;
	private String expectedDateOfDelivery;
	private String actualDateOfDelivery;
	
	private String phoneno;
	private String  bookingDate;
	
	
	public String getExpectedDateOfDelivery() {
		return expectedDateOfDelivery;
	}
	public void setExpectedDateOfDelivery(final String expectedDateOfDelivery) {
		this.expectedDateOfDelivery = expectedDateOfDelivery;
	}
	public String getActualDateOfDelivery() {
		return actualDateOfDelivery;
	}
	public void setActualDateOfDelivery(final String actualDateOfDelivery) {
		this.actualDateOfDelivery = actualDateOfDelivery;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(final String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(final String bookingId) {
		this.bookingId = bookingId;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(final String toAddress) {
		this.toAddress = toAddress;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(final String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	

}
