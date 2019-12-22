package com.managemeeting.managemeetin.repository;

import com.managemeeting.managemeetin.model.Venue;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@JaversSpringDataAuditable
@Repository
public interface VenueRepository extends MongoRepository<Venue,String> {
}
