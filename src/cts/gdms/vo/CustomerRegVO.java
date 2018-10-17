package cts.gdms.vo;

public class CustomerRegVO {
	private String firstName;
	private String lastName;
	private String passWord;
	private String retypepassWord;
	private String contactNo;
	private String dateOfBirth;
	private String address;
	private String gender;
	private String emailId;
	private String loginType;
	private String custId;  

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(final String passWord) {
		this.passWord = passWord;
	}

	public String getRetypepassWord() {
		return retypepassWord;
	}

	public void setRetypepassWord(final String retypepassWord) {
		this.retypepassWord = retypepassWord;
	}

	

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(final String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(final String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(final String loginType) {
		this.loginType = loginType;
	}
}

