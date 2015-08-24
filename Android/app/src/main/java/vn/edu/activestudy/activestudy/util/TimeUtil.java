package vn.edu.activestudy.activestudy.util;

import android.content.Context;
import android.os.SystemClock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {

    public static final int TYPE_DATE_TIME = 0;
    public static final int TYPE_TIME_DATE = 1;

	public static String convertLongToString(long miliSeconds) {
		String currentTime = convertLongToDate(Calendar.getInstance().getTimeInMillis());
		String timeTemp = convertLongToDate(miliSeconds);
		String equal;
		if (currentTime.substring(0, 2).equals(timeTemp.substring(0, 2))) {
			equal = TimeUtil.convertLongToHourFormatted(miliSeconds);
		} else {
			equal = TimeUtil.convertLongToDate(miliSeconds);
		}
		return equal;
	}

    public static String convertLongToHour(Long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return new SimpleDateFormat("dd").format(calendar.getTime());
    }

    public static String convertLongToDate(Long milliSeconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		return new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
	}

    public static String convertLongToStartEndTime(Long milliSecond1, Long milliSecond2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(milliSecond1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(milliSecond2);

        String str = new SimpleDateFormat("HH:mm - ").format(calendar1.getTime());
        str += new SimpleDateFormat("HH:mm ").format(calendar2.getTime());
        str += new SimpleDateFormat("dd/MM/yyyy").format(calendar1.getTime());
        return str;
    }

	public static String convertLongToHourFormatted(Long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        SimpleDateFormat onlyHourFormat = new SimpleDateFormat("HH:mm");
//		SimpleDateFormat onlyHourFormatAM = new SimpleDateFormat("hh:mm aa");
        return onlyHourFormat.format(calendar.getTime());
	}

	public static String convertLongToFullDateTime(Long miliesSeconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(miliesSeconds);
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(calendar.getTime());
	}

	public static long convertDateToLong(String string) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("");
			return dateFormat.parse(string).getTime();
		} catch (ParseException e) {
			return 0;
		}
	}

	public static String convertCurrentTimeToString() {
		Calendar calendar = Calendar.getInstance();
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(calendar.getTime());
	}

}
