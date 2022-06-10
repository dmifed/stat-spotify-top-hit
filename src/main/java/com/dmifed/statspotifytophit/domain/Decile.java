package com.dmifed.statspotifytophit.domain;

import com.dmifed.statspotifytophit.utils.DecileSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by DIMA, on 07.06.2022
 */
@AllArgsConstructor
@Getter
@JsonSerialize(using = DecileSerializer.class)
public class Decile {
    private final double min;
    private final double max;
    private final int count;








}
