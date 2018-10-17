package cts.gdms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import cts.gdms.connection.ConnectionManager;
import cts.gdms.constants.SQLConstants;
import cts.gdms.exception.CheckstatusException;
import cts.gdms.util.SQLUtill;
import cts.gdms.vo.Checkstatusvo;

public class Checkstatusdao {
	public static final Logger LOG = Logger.getLogger(Checkstatusdao.class);

	public Checkstatusvo checkstatus(final Checkstatusvo cvo)
			throws CheckstatusException {

		String sql;
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		final Connection connection = ConnectionManager.getConnection();
		sql = SQLUtill.getSqlProperty(SQLConstants.SELECT_USERDETAILS1);
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cvo.getBookingid());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				LOG.info("entered into Query Execution");
				cvo.setBookingid(resultSet.getString(1));
				cvo.setGiftsubid(resultSet.getString(4));
				cvo.setDeliverystatus(resultSet.getString(5));
				cvo.setExpecteddate(resultSet.getString(6));
			}

		} catch (SQLException e2) {
			LOG.warn("Failed to Get The Details from database");
			throw new CheckstatusException(
					"Failed to get details from database", e2);

		} finally {

			try {
				connection.close();
				resultSet.close();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				LOG.warn("Failed to close the Connection of connection object");
			}

		}

		return cvo;
	}

	public boolean checkid(final String bookinId) throws CheckstatusException {
		boolean msg = false;
		final Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql1;
		sql1 = SQLUtill.getSqlProperty(SQLConstants.SELECT_USERDETAILS);

		try {
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, bookinId);
			resultSet = preparedStatement.executeQuery();
			LOG.info("Query Executed");
			if (resultSet.next()) {
				LOG.info("Returning Method Is True Or False");
				msg = true;
			}
		} catch (SQLException e1) {

			LOG.warn("Failed to Get The Details Of The Booking ID");
			throw new CheckstatusException("Failed to get details", e1);
		} finally {

			try {
				connection.close();
				resultSet.close();
			} catch (SQLException e4) {

				LOG.warn("Failed To Close The Connection");
			}

		}

		return msg;

	}
}
