package cts.gdms.vo;



public class AddGiftVO {

	private String giftType;
	private String otherType;
	private String giftDiscription;
	private String occasion;
	private String otherOcasion;
	private int cost;
	private int quantity;

	

	public String getGiftDiscription() {
		return giftDiscription;
	}

	public void setGiftDiscription(final String giftDiscription) {
		this.giftDiscription = giftDiscription;
	}

	public String getGiftType() {
		return giftType;
	}

	public void setGiftType(final String giftType) {
		this.giftType = giftType;
	}

	public String getOtherType() {
		return otherType;
	}

	public void setOtherType(final String otherType) {
		this.otherType = otherType;
	}

	public String getOtherOcasion() {
		return otherOcasion;
	}

	public void setOtherOcasion(final String otherOcasion) {
		this.otherOcasion = otherOcasion;
	}

	
	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(final String occasion) {
		this.occasion = occasion;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(final int cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

}
