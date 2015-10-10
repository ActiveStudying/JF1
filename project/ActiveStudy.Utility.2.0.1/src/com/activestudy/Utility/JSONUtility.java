/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.Utility;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
public class JSONUtility {

    public static JSONObject CreatJSONObject(Object data) {
        JSONObject mJSONObject = new JSONObject();
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.get(data) != null) {
                    if (MCommonUtils.isPrimitive(field.get(data).getClass())) {
                        mJSONObject.put(field.getName(), field.get(data));
                    } else {
                        mJSONObject.put(field.getName(), CreatJSONObject(field.get(data)));
                    }
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(JSONUtility.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(JSONUtility.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(JSONUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mJSONObject;
    }
    //-----------------------------------------------------------------------------------------------------

    //-------------------------------------------------------------------------------------------------------
    public static Object GetJSONData(String inData, Object Out) {
        if (inData.isEmpty() == false) {
            JSONObject mJSONObject;
            try {
                mJSONObject = new JSONObject(inData);
                return GetJSONData(mJSONObject, Out);
            } catch (JSONException ex) {
                Logger.getLogger(JSONUtility.class.getName()).log(Level.SEVERE, null, ex);
                return Out;
            }
        } else {
            return Out;
        }
    }

    public static Object GetJSONData(JSONObject inData, Object Out) {

        Field[] fields = Out.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.getType() == Integer.TYPE) {
                    int nVal = inData.getInt(field.getName());
                    field.set(Out, nVal);
                } else if (field.getType() == String.class) {
                    String strVal = inData.getString(field.getName());
                    if(strVal == null){
                        strVal = inData.getString(field.getName().toLowerCase());
                    }
                    if(strVal == null){
                        strVal = inData.getString(field.getName().toUpperCase());
                    }
                    if (strVal != null && strVal.isEmpty() != true) {
                        field.set(Out, strVal);
                    }
                } else if (field.getType() == Long.class) {
                    long lVal = inData.getLong(field.getName());
                    if(lVal == 0){
                        lVal = inData.getLong(field.getName().toLowerCase());
                    }
                    if(lVal == 0){
                        lVal = inData.getLong(field.getName().toUpperCase());
                    }
                    field.set(Out, lVal);
                } else if (field.getType() == Double.class) {
                    double dVal = inData.getDouble(field.getName());
                    if(dVal == 0){
                        dVal = inData.getDouble(field.getName().toLowerCase());
                    }
                    if(dVal == 0){
                        dVal = inData.getDouble(field.getName().toUpperCase());
                    }
                    field.set(Out, dVal);
                } else if (field.getType() == Boolean.class) {
                    boolean bVal = inData.getBoolean(field.getName());
                    if(bVal == false){
                        bVal = inData.getBoolean(field.getName().toLowerCase());
                    }
                    if(bVal == false){
                        bVal = inData.getBoolean(field.getName().toUpperCase());
                    }
                    field.set(Out, bVal);
                } else if (field.getType() == long.class) {
                    long lVal = inData.getLong(field.getName());
                    if(lVal == 0){
                        lVal = inData.getLong(field.getName().toLowerCase());
                    }
                    if(lVal == 0){
                        lVal = inData.getLong(field.getName().toUpperCase());
                    }
                    field.set(Out, lVal);
                } else if (field.getType() == java.util.ArrayList.class) {
                    JSONArray jsonArrData = inData.getJSONArray(field.getName());
                    if(jsonArrData != null){
                        for(int i = 0; i < jsonArrData.length(); i++){
                            ((java.util.ArrayList)field.get(Out)).add(jsonArrData.get(i));
                        }
                    }
                } else {
                    JSONObject jsonSubData = inData.getJSONObject(field.getName());
                    field.set(Out,GetJSONData(jsonSubData,field));
                }
            } catch (JSONException ex) {
                Logger.getLogger(JSONUtility.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(JSONUtility.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(JSONUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Out;
    }
}
