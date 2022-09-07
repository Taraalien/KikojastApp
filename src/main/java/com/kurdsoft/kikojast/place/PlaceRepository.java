package com.kurdsoft.kikojast.place;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.awt.print.Pageable;
import java.util.List;

public interface PlaceRepository extends PagingAndSortingRepository<Place,Long> {


    @Query("SELECT vl, distance(vl.location, ?1) as distance from Place vl order by distance")
    List<Tuple> findAllWithDistance(Point<G2D> refPnt);


    @Query("SELECT vl from Place vl where  distance(vl.location, ?1) < ?2")
    List<Place> findAllWithDistance3(Point<G2D> refPnt, double dist);


    @Query("SELECT vl, distance(vl.location, ?1) as distance from Place vl  order by distance" )
    List<Tuple> findNearest(Point<G2D> refPnt, Pageable page);


    @Query("SELECT v1 FROM Place AS v1 WHERE  within(v1.location, :filter)=TRUE ")
    List<Place> findWithin(@Param("filter") Geometry filter);
}
