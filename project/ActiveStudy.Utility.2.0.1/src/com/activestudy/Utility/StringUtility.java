/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.Utility;



/**
 *
 * @author tanhai
 */
public class StringUtility {
    public static String bytetoHexText(byte[] array) {
        String strResult = "";
        for (int k = 0; k < array.length; k++) {
            strResult += Integer.toHexString(array[k]) + "";
            
        }
        return strResult;
    }
    
}
