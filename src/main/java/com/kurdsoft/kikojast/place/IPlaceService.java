package com.kurdsoft.kikojast.place;


import java.util.List;

public interface IPlaceService {

    Place save(Place place);
    Place update(Place place);
    void delete(Long id);
    Place getById(Long id);
    List<Place> getAll();

}
