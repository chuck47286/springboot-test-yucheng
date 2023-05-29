package com.example.myapplication.controller;

import com.example.myapplication.service.MapIteratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MapController {

    @Autowired
    private MapIteratorService mapIteratorService;

    @GetMapping("/map")
    public String getListFromMap() {
        return mapIteratorService.getList();
    }

}
