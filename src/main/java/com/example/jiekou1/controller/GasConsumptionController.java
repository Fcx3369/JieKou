package com.example.jiekou1.controller;

import com.example.jiekou1.entiy.GasConsumption;
import com.example.jiekou1.service.GasConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Consumption")
public class GasConsumptionController {

    @Autowired
    private GasConsumptionService gasConsumptionService;

    @GetMapping("/All")
    public List<GasConsumption> getGasConsumption(){
        return gasConsumptionService.GasConsumptionAll();
    }
}
