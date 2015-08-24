package vn.edu.activestudy.activestudy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
