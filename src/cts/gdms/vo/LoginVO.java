package cts.gdms.vo;

public class LoginVO {

	private String emailId;
	private String password;
	private String loginType;
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(final String loginType) {
		this.loginType = loginType;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
}