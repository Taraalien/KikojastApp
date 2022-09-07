package com.kurdsoft.kikojast.place;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceService implements IPlaceService {

    private final PlaceRepository repository;

    @Override
    public Place save(Place place) {
        return repository.save(place);
    }

    @Override
    public Place update(Place place) {
        Place lastItem=getById(place.getId());
        lastItem.setAddress(place.getAddress());
        lastItem.setLocation(place.getLocation());
        lastItem.setStartService(place.getStartService());
        lastItem.setEndService(place.getEndService());
        lastItem.setTitle(place.getTitle());
        lastItem.setType(place.getType());

        return repository.save(lastItem);
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);

    }

    @Override
    public Place getById(Long id) {

        Optional<Place> optionalPlace=repository.findById(id);
        if(!optionalPlace.isPresent()){
            throw new NotFoundException("Not Found");
        }

        return optionalPlace.get();
    }

    @Override
    public List<Place> getAll() {
        return (List<Place>)repository.findAll() ;
    }
}
