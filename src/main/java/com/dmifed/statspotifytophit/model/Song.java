package com.dmifed.statspotifytophit.model;

import com.dmifed.statspotifytophit.exception.ColumnNameNotAllowedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.NoSuchElementException;

/**
 * Created by DIMA, on 09.06.2022
 */
@Entity
@Getter
public class Song {
    private static long ids = 0;
    @Id
    private long id;

    private double duration_ms;
    private double year;
    private double popularity;
    private double danceability;
    private double energy;
    private double key;

    public Song(){
    }

    public Song(double duration_ms, double year, double popularity, double danceability, double energy, double key) {
        this.id = ++ids;
        this.duration_ms = duration_ms;
        this.year = year;
        this.popularity = popularity;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
    }

    public double getFieldByName(String name) throws ColumnNameNotAllowedException {
        switch (name){
            case "duration_ms" : return duration_ms;
            case "year" : return year;
            case "popularity" : return popularity;
            case "danceability" : return danceability;
            case "energy" : return energy;
            case "key" : return key;
            default: throw new ColumnNameNotAllowedException();
        }
    }


}
