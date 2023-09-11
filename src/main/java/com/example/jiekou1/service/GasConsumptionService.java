package com.example.jiekou1.service;

import com.example.jiekou1.Mapper.GasConsumptionMapper;
import com.example.jiekou1.entiy.GasConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasConsumptionService {

    @Autowired
    private GasConsumptionMapper gasConsumptionMapper;

    public List<GasConsumption> GasConsumptionAll(){
        return gasConsumptionMapper.GasConsumptionAll();
    }
}
