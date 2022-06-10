package com.dmifed.statspotifytophit.parser;

import com.dmifed.statspotifytophit.exception.NotCSVFileException;
import com.dmifed.statspotifytophit.model.Song;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA, on 09.06.2022
 */
public class Parser {
    private static final String TYPE = "text/csv";

    public List<Song> csvToList(Path path) throws IOException {
        if(!isCSVFile(path)) throw new NotCSVFileException();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile().getAbsoluteFile()));
        CSVFormat.Builder csvBuilder = CSVFormat.Builder.create();
        csvBuilder.setDelimiter(", ");
        csvBuilder.setSkipHeaderRecord(true);
        CSVFormat csvFormat = csvBuilder.build();
        CSVParser csvParser = new CSVParser(bufferedReader, csvFormat);
        List<Song> songs = new ArrayList<>();
        List<CSVRecord> records = csvParser.getRecords();
        for(CSVRecord record : records){
            double duration_ms = Double.parseDouble(record.get("duration_ms"));
            double year = Double.parseDouble(record.get("year"));
            double popularity = Double.parseDouble(record.get("popularity"));
            double danceability = Double.parseDouble(record.get("danceability"));
            double energy = Double.parseDouble(record.get("energy"));
            double key = Double.parseDouble(record.get("key"));
            Song song = new Song(duration_ms, year, popularity, danceability, energy, key);
            songs.add(song);
        }
        bufferedReader.close();
        return songs;
    }

    private boolean isCSVFile(Path path) throws IOException {
        String fileType = Files.probeContentType(path);
        return fileType.equals(TYPE);
    }
}
