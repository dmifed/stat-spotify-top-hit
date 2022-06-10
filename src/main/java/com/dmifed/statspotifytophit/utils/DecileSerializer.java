package com.dmifed.statspotifytophit.utils;

import com.dmifed.statspotifytophit.domain.Decile;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * Created by DIMA, on 08.06.2022
 */
public class DecileSerializer extends StdSerializer<Decile> {
    private static final double EPSILON = 0.0001;

    protected DecileSerializer(Class<Decile> t) {
        super(t);
    }


    @Override
    public void serialize(Decile value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeRaw("\"min\" : " + doubleToString(value.getMin()) + ", ");
        gen.writeRaw("\"max\" : " + doubleToString(value.getMax()) + ", ");
        gen.writeRaw("\"count\" : " + doubleToString(value.getCount()));
        gen.writeEndObject();
        gen.flush();
    }

    private static String doubleToString(double d){
        int i = (int) d;
        if(Math.abs(i - d) < EPSILON){
            return String.valueOf(i);
        }
        return String.valueOf(d);
    }
}
