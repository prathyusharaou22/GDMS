package cts.gdms.bo;

import org.apache.log4j.Logger;

import cts.gdms.dao.Checkstatusdao;
import cts.gdms.exception.CheckstatusBusinessException;
import cts.gdms.exception.CheckstatusException;
import cts.gdms.vo.Checkstatusvo;





public class Checkstatusbo {

	public static final Logger LOG = Logger.getLogger(Checkstatusbo.class);
	private static transient Checkstatusdao checkstatusdao;

	public Checkstatusvo checkstatus(final Checkstatusvo cvo)
			throws CheckstatusException, CheckstatusBusinessException {
		checkstatusdao = new Checkstatusdao();
		LOG.info("calling checkstatus method for checking id from dao class");
		return checkstatusdao.checkstatus(cvo);

	}

	public final boolean checkId(final String bookingId)
			throws CheckstatusException, CheckstatusBusinessException {
		checkstatusdao = new Checkstatusdao();
		LOG.info("returning CheckID is true or false");
		return checkstatusdao.checkid(bookingId);

	}

}
