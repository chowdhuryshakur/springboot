package com.managemeeting.managemeetin.meeting;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingsRepository extends MongoRepository<Meetings,String> {

}
