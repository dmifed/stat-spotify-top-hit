package com.dmifed.statspotifytophit.trash;

import com.dmifed.statspotifytophit.domain.Decile;
import com.dmifed.statspotifytophit.trash.JSONConverter;
import com.dmifed.statspotifytophit.trash.JSONConverterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by DIMA, on 07.06.2022
 */
class JSONConverterImplTest {
    private JSONConverter jsonConverter;

    @BeforeEach
    void setUp() {
        jsonConverter = new JSONConverterImpl();
    }

    @Test
    void convertDecileToJSON(){
        Decile testDecile = new Decile(0, 100, 10);
        String expected = "{\"min\" : 0, \"max\" : 100, \"count\" : 10}";
        String actual = jsonConverter.convertDecileToJSON(testDecile);
        assertNotNull(actual);
        assertEquals(expected, actual);


    }
}
