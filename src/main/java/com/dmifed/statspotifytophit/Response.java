package com.dmifed.statspotifytophit;

import com.dmifed.statspotifytophit.domain.Decile;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Created by DIMA, on 08.06.2022
 */
@Getter
@AllArgsConstructor
public class Response {
    private final List<Decile> deciles;
}
