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
        repositoryListe.add(new TouristAttraction("Tivoli", "Forlystelsespark"));
        repositoryListe.add(new TouristAttraction("ZoologiskHave", "Se på dyr"));
        repositoryListe.add(new TouristAttraction("Noerrebroparken", "En park hvor du kan se drugdeals"));
    }

    public List<TouristAttraction> getAllAttractions(){
        return repositoryListe;
    }
    public TouristAttraction findAttractionByName(String name){
        for(TouristAttraction attraction : repositoryListe){
        if (attraction.getName().equalsIgnoreCase(name)) {
            return attraction;
        }

    }
    return null;
    }
    public TouristAttraction addAttraction(TouristAttraction attraction) {
        if (attraction.getName() != null && !attraction.getName().isEmpty()) {
            repositoryListe.add(attraction);
            return attraction;
        }
        return null;
    }
    public TouristAttraction updateDescription(String name, String description) {
        for(TouristAttraction attraction : repositoryListe){
            if (attraction.getName().equalsIgnoreCase(name)) {
                attraction.setDescription(description);
                return attraction;
            }

        }
        return null;
    }
    public TouristAttraction removeAttraction(String name) {
        for (TouristAttraction attraction : repositoryListe) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                repositoryListe.remove(attraction);
                return attraction;
            }
        }
        return null;
    }


}