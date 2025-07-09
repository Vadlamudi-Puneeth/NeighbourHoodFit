package com.example.demo.controller;

import com.example.demo.model.Neighbor;
import com.example.demo.service.NeighborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/neighbors")
public class NeighborController {

    @Autowired
    public NeighborService neighborService;

    @GetMapping
    public List<Neighbor> fetchAllneighbors(){
        return neighborService.getAllNeighbors();
    }


}
