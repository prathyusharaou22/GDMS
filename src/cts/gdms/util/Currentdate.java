package cts.gdms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Currentdate {
	  public static String getdate()
	  {
	  Calendar cal=new GregorianCalendar();
	  Date d=cal.getTime();
      SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
      String curdate=sdf.format(d);
      return curdate;
	  }

}