package com.dmifed.statspotifytophit.trash;

import com.dmifed.statspotifytophit.Response;
import com.dmifed.statspotifytophit.domain.Decile;

import java.util.stream.Collectors;

/**
 * Created by DIMA, on 07.06.2022
 */
public class JSONConverterImpl implements JSONConverter {
    private static final double EPSILON = 0.0001;

    @Override
    public String convertResponseToJSON(Response response){
        String deciles = response.getDeciles().stream()
                .map(this::convertDecileToJSON)
                .map((s) -> "\t" + s)
                .collect(Collectors.joining(",\r\n"));
        return "[\r\n" + deciles + "\r\n]";

    }

    @Override
    public String convertDecileToJSON(Decile decile){
        return "{\"min\" : " + doubleToString(decile.getMin())
                + ", \"max\" : " + doubleToString(decile.getMax())
                + ", \"count\" : " + decile.getCount() + "}";

    }

    private static String doubleToString(double d){
        int i = (int) d;
        if(Math.abs(i - d) < EPSILON){
            return String.valueOf(i);
        }
        return String.valueOf(d);
    }
}
