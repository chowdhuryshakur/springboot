package com.managemeeting.managemeetin.repository;

import com.managemeeting.managemeetin.model.Notification;
import com.managemeeting.managemeetin.model.Venue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
}
