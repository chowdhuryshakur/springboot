package com.managemeeting.managemeetin.meeting;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingsRepository extends MongoRepository<Meetings,String> {

    public List<Meetings>findByVenueId(String venueId);
}
