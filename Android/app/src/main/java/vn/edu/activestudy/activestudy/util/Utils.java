package vn.edu.activestudy.activestudy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.edu.activestudy.activestudy.ASApplication;
import vn.edu.activestudy.activestudy.common.Constants;

/**
 * Created by dell123 on 8/18/2015.
 */
public class Utils {
    public static boolean checkEmailValidator(String email) {
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkSessionId() {
        String sessionId = PreferenceUtil.getString(ASApplication.getContext(), Constants.PREFERENCE_SESSION_ID, "");
        if ("".equals(sessionId)) {
            return false;
        }
        //TODO:
        return true;
    }

    public static String getSessionID() {
        String sessionId = PreferenceUtil.getString(ASApplication.getContext(), Constants.PREFERENCE_SESSION_ID, "");
        return sessionId;
    }

    public static String getAccountID() {
        String accountId = PreferenceUtil.getString(ASApplication.getContext(), Constants.PREFERENCE_ACCOUNT_ID, "");
        return accountId;
    }

    public static String getDeviceID() {
        String deviceId = PreferenceUtil.getString(ASApplication.getContext(), Constants.PREFERENCE_DEVICE_ID, "");
        return deviceId;
    }

    public static String getAuthenId() {
        String authenId = PreferenceUtil.getString(ASApplication.getContext(), Constants.PREFERENCE_AUTHEN_ID, "");
        return authenId;
    }

    public static String getCloudKey() {
        String cloudKey = PreferenceUtil.getString(ASApplication.getContext(), Constants.PREFERENCE_CLOUD_KEY, "");
        return cloudKey;
    }
}
