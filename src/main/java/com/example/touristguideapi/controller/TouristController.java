package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.repository.TouristRepository;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }
@GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
}
}
