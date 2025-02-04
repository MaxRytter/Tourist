package com.example.touristguideapi.service;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions(){
        return touristRepository.getAllAttractions();
    }
//    public TouristAttraction printSteder (String navn) {
//        TouristAttraction message = touristRepository.printSteder(navn);
//        if (touristRepository) {
//            return new TouristAttraction(navn, message.getDescription());
//        }
//        return message;
//    }
}
