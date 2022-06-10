package com.dmifed.statspotifytophit.trash.cache;

import com.dmifed.statspotifytophit.Request;
import com.dmifed.statspotifytophit.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DIMA, on 08.06.2022
 */
public class Cache {
    private static final Map<Request, Response> cachedRequests = new HashMap<>();

    public static boolean addToCache(Request req, Response resp){
        if(cachedRequests.containsKey(req)) return false;
        cachedRequests.put(req, resp);
        return true;
    }

    public static void resetCache(){
        cachedRequests.clear();
    }
}
