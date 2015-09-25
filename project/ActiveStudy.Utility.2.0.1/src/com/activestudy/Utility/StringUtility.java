/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tanhai
 */
public class StringUtility {

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String OTPCODE_PATTERN = ".*[^0-9].*";

    public static String bytetoHexText(byte[] array) {
        String strResult = "";
        for (int k = 0; k < array.length; k++) {
            strResult += Integer.toHexString(array[k]) + "";

        }
        return strResult;
    }

    public static boolean is_Email(String email) {

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // check otpcode 
    public static boolean is_OTPCODE(String otpCode) {

       Pattern pattern = Pattern.compile(OTPCODE_PATTERN);
        Matcher matcher = pattern.matcher(otpCode);
        return matcher.matches();
    }

}
