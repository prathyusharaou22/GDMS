package cts.gdms.bo;


import java.util.List;
import org.apache.log4j.Logger;

import cts.gdms.dao.DeliveryreportDAO;
import cts.gdms.exception.DeliveryReportException;
import cts.gdms.vo.DeliveryReportvo;
import cts.gdms.vo.StockReportvo;



	
	public class DeliveryReportBO {
		public static final Logger LOG=Logger.getLogger(DeliveryReportBO.class);
			
		
		private transient final DeliveryreportDAO drdao=new DeliveryreportDAO();
		
		public final  List<String> giftsub(final DeliveryReportvo drvo) throws DeliveryReportException
		{
			
			LOG.info("giftsubid is called in bo to add giftsubid's ");
			return drdao.giftsubid(drvo);
		}
		public final  List<Integer> noofgiftsbooked(final DeliveryReportvo drvo) throws DeliveryReportException
		{
			LOG.info("noofgiftsbooked is called in bo to add no: of gifts booked ");
			return drdao.noofgiftsbooked(drvo);
			
		}
		public final List<Integer> noofgiftsdeliveredbeforeexpected(final DeliveryReportvo drvo) throws DeliveryReportException
		{
			LOG.info("noofgiftsdeliveredbeforeexpected is called in bo to add no: of gifts delivered before expected date ");
			return drdao.noofgiftsdeliveredbeforeexpecteddate(drvo);
			
		}
		public final List<Integer> noofgiftsdeliveredonexpected(final DeliveryReportvo drvo) throws DeliveryReportException
		{
			LOG.info("noofgiftsdeliveredonexpected is called in bo to add no: of gifts delivered on expected date ");
			return drdao.noofgiftsdeliveredonexpecteddate(drvo);
			
		}
		public List<Integer> noofgiftsdeliveredafterexpected(final DeliveryReportvo drvo) throws DeliveryReportException
		{
			LOG.info("noofgiftsdeliveredafterexpected is called in bo to add no: of gifts delivered after expected date ");
			return drdao.noofgiftsdeliveredafterexpecteddate(drvo);
			
		}
		
		
		public List<StockReportvo> stockreport() {
			LOG.info("StockReports tabulation");
			
			return drdao.stockreport();
		}
		
		
		}


