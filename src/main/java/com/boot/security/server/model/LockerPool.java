package com.boot.security.server.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 神画 根据唯一标识创建对象池，给不同业务逻辑单独上锁(实现单例)
 */
public class LockerPool { 
    Map<String,String> lockMap = new HashMap<>();
    private static volatile LockerPool lockerPool = null;
   
    public String getLocker(String id){
        if(lockMap.get(id)==null){
            lockMap.put(id,"Lock"+id);
        }
        return lockMap.get(id);
    }

    private LockerPool(){
    	
    }

    public static LockerPool getSingleton(){
        if(lockerPool == null){
            synchronized (LockerPool.class){
                if(lockerPool == null){
                    lockerPool = new LockerPool();
                }
            }
        }
        return lockerPool;
    }
}
