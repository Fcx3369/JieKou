package com.example.jiekou1.controller;

import com.example.jiekou1.entiy.Station;
import com.example.jiekou1.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Station")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping
    public List<Station> getStation(){
        return stationService.StationAll();
    }
}
