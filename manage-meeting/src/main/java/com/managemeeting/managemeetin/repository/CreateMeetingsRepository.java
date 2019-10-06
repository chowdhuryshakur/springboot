package com.managemeeting.managemeetin.repository;

import com.managemeeting.managemeetin.model.CreateMeetings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreateMeetingsRepository extends MongoRepository<CreateMeetings,String> {

}
