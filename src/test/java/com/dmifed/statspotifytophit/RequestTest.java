package com.dmifed.statspotifytophit;

import com.dmifed.statspotifytophit.trash.Column;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by DIMA, on 09.06.2022
 */
class RequestTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testEqualsSymmetrical() {
        Request req1 = new Request(Column.ENERGY, "2005");
        Request req2 = new Request(Column.ENERGY, "2005");
        assertTrue(req1.equals(req2) && req2.equals(req1));
        assertEquals(req1.hashCode(), req2.hashCode());

        req1 = new Request(Column.ENERGY, "2005");
        req2 = new Request(Column.ENERGY);
        assertTrue(!req1.equals(req2) && !req2.equals(req1));
        assertNotEquals(req1.hashCode(), req2.hashCode());

        req1 = new Request(Column.ENERGY, "2005");
        req2 = new Request(Column.POPULARITY, "2005");
        assertTrue(!req1.equals(req2) && !req2.equals(req1));
        assertNotEquals(req1.hashCode(), req2.hashCode());
    }


}
