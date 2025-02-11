package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
//en RequestMapping til vores attraktioner http://localhost:8080/attractions
@RequestMapping("/attractions")
//Controller klasse
public class TouristController {
private final TouristService touristService;
//Controller constructor
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }
    //en GetMapping til alle attraktioner
@GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
}
//en GetMapping til en specifik attraktion, f.eks. http://localhost:8080/attractions/tivoli
    @GetMapping("/{name}")
public ResponseEntity<TouristAttraction> getAttractionName(@PathVariable String name) {
    TouristAttraction attraction = touristService.findAttractionByName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    //http://localhost:8080/attractions/add   substituer /add med f.eks. /havfrue
    //laver en PostMapping der tilføjer en attraktion til vores attraktionsliste
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction newAttraction = touristService.addAttraction(attraction);
        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    //http://localhost:8080/attractions/update/Tivoli
    //en PostMapping der opdaterer beskrivelsen på den skrevne attraktion i json
    @PostMapping("/update/{name}")
    public ResponseEntity<TouristAttraction> updateDescription(@PathVariable String name, @RequestBody TouristAttraction attraction) {
        TouristAttraction updateAttraction = touristService.updateDescription(name, attraction.getDescription());
        return new ResponseEntity<>(updateAttraction, HttpStatus.OK);
    }

    //http://localhost:8080/attractions/delete/Tivoli
    //DeleteMapping som fjerner en Attraktion
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> removeAttraction(@PathVariable String name) {
        TouristAttraction deleteAttraction = touristService.removeAttraction(name);
        return new ResponseEntity<>(deleteAttraction, HttpStatus.OK);
    }
}
