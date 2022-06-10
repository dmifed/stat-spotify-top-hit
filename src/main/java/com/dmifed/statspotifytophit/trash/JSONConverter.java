package com.dmifed.statspotifytophit.trash;

import com.dmifed.statspotifytophit.Response;
import com.dmifed.statspotifytophit.domain.Decile;

import java.util.List;

/**
 * Created by DIMA, on 08.06.2022
 */
public interface JSONConverter {
    String convertResponseToJSON(Response response);
    String convertDecileToJSON(Decile decile);

}
