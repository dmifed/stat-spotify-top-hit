package com.dmifed.statspotifytophit.service;

import com.dmifed.statspotifytophit.model.Song;
import com.dmifed.statspotifytophit.parser.Parser;
import com.dmifed.statspotifytophit.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by DIMA, on 09.06.2022
 */
@Service
public class CSVService {
    @Autowired
    SongRepository songRepository;

    private final Logger log = Logger.getLogger(CSVService.class.getName());

    public void save(Path path){
        Parser parser = new Parser();
        List<Song> songs = null;
        try {
            songs = parser.csvToList(path);
            songRepository.saveAll(songs);
        } catch (IOException e) {
            log.severe("error to save csv: " + e.getMessage());
        }
    }

    public List<Song> getSongs(Sort by){
        return songRepository.findAll();
    }

    public List<Song> getSongsByYear(int year){
        return songRepository.findByYear(year);
    }
}
