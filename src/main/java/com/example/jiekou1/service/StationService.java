package com.example.jiekou1.service;

import com.example.jiekou1.Mapper.StationMapper;
import com.example.jiekou1.entiy.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationMapper stationMapper;

    public List<Station> StationAll(){
        return stationMapper.StationAll();
    }
}
