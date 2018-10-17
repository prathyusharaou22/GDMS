package cts.gdms.bo;

import java.util.List;

import org.apache.log4j.Logger;

import cts.gdms.dao.CustomerRegDAO;
import cts.gdms.exception.CustomerBusinessException;
import cts.gdms.exception.CustomerException;
import cts.gdms.vo.CustomerRegVO;
import cts.gdms.vo.LoginVO;


public class CustomerRegBO {
	public static final Logger LOG=Logger.getLogger(CustomerRegBO.class);
	public static CustomerRegDAO cdao = new CustomerRegDAO();

	public String insertDataBO(final CustomerRegVO cvo) throws CustomerException, CustomerBusinessException {
		String message;
		System.out.println("came to customer registration bo");
		final List<String> email = cdao.emailValidation(cvo);
		if (email.contains(cvo.getEmailId())) {

			System.out.println("email exist");
			message = "email exists";
		} else {
			System.out.println("email does not exist");
			message = cdao.insertCustomerDetails(cvo);  
		}
		return message;
	}
	
	public String loginCheck(final LoginVO loginVO) throws CustomerException, CustomerBusinessException {
		System.out.println(cdao.loginType(loginVO));
		return cdao.loginType(loginVO);
	}
}
