package com.managemeeting.managemeetin.repository;

import com.managemeeting.managemeetin.model.Meetings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MeetingsRepository extends MongoRepository<Meetings,String> {

}
