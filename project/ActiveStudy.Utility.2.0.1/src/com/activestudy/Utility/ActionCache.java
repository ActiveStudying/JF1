/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.Utility;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author tanhai
 */
public class ActionCache<K,V> extends HashMap<K, V>{
    String filePath = "";
    String CacheName = "";
    
    public ActionCache(Map<? extends K, ? extends V> m){
        super(m);
    }
            
    ConcurrentHashMap<Object, Object> mCacheMap = new ConcurrentHashMap<Object, Object>();  
    
    public ActionCache(String CacheName){        
        this.CacheName = CacheName;
    }
    public ActionCache(String CacheName, String filePath){        
        this.CacheName = CacheName;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCacheName() {
        return CacheName;
    }

    public void setCacheName(String CacheName) {
        this.CacheName = CacheName;
    }
    
//    public Object get(Object key){
//        return mCacheMap.get(key);
//    }
//    public Object remove(Object key){
//        return mCacheMap.remove(key);
//    }
//    public Object put(Object key, Object value){
//        return mCacheMap.put(key,value);
//    }   
}
