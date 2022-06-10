package com.dmifed.statspotifytophit;

import com.dmifed.statspotifytophit.trash.Column;
import lombok.Getter;

import java.util.Objects;

/**
 * Created by DIMA, on 08.06.2022
 */
@Getter
public class Request {
    private final String column;
    private final String year;

    public Request(String column, String year) {
        this.column = column;
        this.year = year;
    }

    public Request(String column) {
        this(column, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return getColumn().equals(request.getColumn()) &&
                Objects.equals(getYear(), request.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn(), getYear());
    }
}
