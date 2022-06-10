package com.dmifed.statspotifytophit.trash.cache;

import com.dmifed.statspotifytophit.trash.Column;
import com.dmifed.statspotifytophit.Request;
import com.dmifed.statspotifytophit.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by DIMA, on 09.06.2022
 */
class CacheTest {
    private Response resp;

    @BeforeEach
    void setUp(){
        resp = new Response(null);
    }

    @Test
    void addToCache() {
        Request req1 = new Request(Column.ENERGY, "2005");
        assertTrue(Cache.addToCache(req1, resp));
        Request req2 = new Request(Column.ENERGY, "2005");
        assertFalse(Cache.addToCache(req2, resp));
    }

    @AfterEach
    void clear(){
        Cache.resetCache();
    }
}
