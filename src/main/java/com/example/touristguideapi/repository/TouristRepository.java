package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> repositoryListe = new ArrayList<>();

    public TouristRepository() {
        steder();
    }

    private void steder() {
        TouristAttraction tivoli = new TouristAttraction("Tivoli", "Forlystelsespark");
        TouristAttraction zoo = new TouristAttraction("Zoologisk Have", "Se på dyr");
        TouristAttraction noerrebroparken = new TouristAttraction("Nørrebroparken", "En park hvor du kan se drugdeals");
        repositoryListe.add(tivoli);
        repositoryListe.add(zoo);
        repositoryListe.add(noerrebroparken);
    }
    public List<TouristAttraction> getAllAttractions(){
        return repositoryListe;
    }
}