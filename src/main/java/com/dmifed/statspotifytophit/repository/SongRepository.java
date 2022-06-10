package com.dmifed.statspotifytophit.repository;

import com.dmifed.statspotifytophit.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DIMA, on 09.06.2022
 */
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByYear(double year);

}
