package com.dmifed.statspotifytophit.controller;

import com.dmifed.statspotifytophit.Request;
import com.dmifed.statspotifytophit.domain.Decile;
import com.dmifed.statspotifytophit.exception.ColumnNameNotAllowedException;
import com.dmifed.statspotifytophit.model.Song;
import com.dmifed.statspotifytophit.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

/**
 * Created by DIMA, on 09.06.2022
 */
@Controller
public class CSVController {
    private Map<Request, Double> tableSumByColumn;

    public CSVController() {
        this.tableSumByColumn = new HashMap<>();
    }

    @Autowired
    CSVService csvService;

    @GetMapping("/deciles/{column}")
    public ResponseEntity<List<Decile>> getDeciles(@PathVariable String column) {
       column = column.trim().toLowerCase();
       Request req = new Request(column);
       List<Double> items = getItems(column);
       if(items.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       return new ResponseEntity<>(items, HttpStatus.OK);


    }

    private List<Double> getItems(String field){
        List<Double> items = new ArrayList<>();
        List<Song> songs = csvService.getSongs(Sort.by(field));
        for(Song s : songs){
            try {
                items.add(s.getFieldByName(field));
            } catch (ColumnNameNotAllowedException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
        items.sort(Comparator.naturalOrder());
        return items;
    }

    private Double getItemsSum(Request req, List<Double> items){
        if(tableSumByColumn.containsKey(req)) {
            return tableSumByColumn.get(req);
        }
        Double sum = items.stream().mapToDouble(Double::doubleValue).sum();
        tableSumByColumn.put(req, sum);
        return sum;
    }

    private List<Decile> calcDeciles(Request req, List<Double> items){
        double sum = getItemsSum(req, items);
        List<Double> deciles = new ArrayList<>();
        for(int i = 1; i < 10; i++){ //9 positions for 10 decile intervals
            double pos = i * (sum + 1) / 10; //positions of i-n decile
            int posInt = (int) pos;
            double belowNum = items.get(posInt);
            double upper = items.get(posInt + 1);
            double factor = upper - belowNum;
            double decile = 



        }

    }





}
