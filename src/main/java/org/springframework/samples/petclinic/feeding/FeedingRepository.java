package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding, Integer>{
    List<Feeding> findAll();
    @Query("SELECT ftype FROM FeedingType ftype")
    List<FeedingType> findAllFeedingTypes();
    Optional<Feeding> findById(int id);
    Feeding save(Feeding p);
    @Query("SELECT ftype FROM FeedingType ftype WHERE ftype.name =:typeName")
    FeedingType findFeedingType(String typeName);
}
