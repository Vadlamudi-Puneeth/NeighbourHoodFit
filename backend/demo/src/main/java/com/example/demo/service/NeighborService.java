package com.example.demo.service;
import com.example.demo.model.Neighbor;
import com.example.demo.repository.NeighborRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NeighborService {

    @Autowired
    public NeighborRepo neighborRepo;

    public List<Neighbor> getAllNeighbors(){
        return neighborRepo.findAll();
    }

}
