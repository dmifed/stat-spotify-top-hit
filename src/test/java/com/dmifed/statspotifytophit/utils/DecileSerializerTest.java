package com.dmifed.statspotifytophit.utils;

import com.dmifed.statspotifytophit.domain.Decile;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by DIMA, on 09.06.2022
 */
class DecileSerializerTest {
    DecileSerializer decileSerializer;
    StringWriter stringWriter;
    JsonGenerator jsonGenerator;

    @BeforeEach
    void setUpDecileSerializer() throws IOException {
        decileSerializer = new DecileSerializer(Decile.class);
        stringWriter = new StringWriter();
        jsonGenerator = new JsonFactory().createGenerator(stringWriter);
    }

    @Test
    void serialize() throws IOException {
        Decile testDecile = new Decile(0.0, 100.5, 10);
        String expected = "{\"min\" : 0, \"max\" : 100.5, \"count\" : 10}";
        decileSerializer.serialize(testDecile, jsonGenerator, null);
        String actual = stringWriter.toString();
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
