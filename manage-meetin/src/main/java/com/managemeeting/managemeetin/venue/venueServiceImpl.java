package com.managemeeting.managemeetin.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.managemeeting.managemeetin.service.meetingsService;

@Service
@EnableMongoRepositories(basePackageClasses = VenueRepository.class)
public  class venueServiceImpl /*implements meetingsService */{

    @Autowired
    private VenueRepository venueRepository;


    public Venue save(Venue venue) {

        return venueRepository.save(venue);
    }


    public Venue update(Venue venue) {
        return venueRepository.save(venue);
    }


    public List<Venue> getAllVenue() {
        return venueRepository.findAll();
    }

    public void deleteVenue() {
        venueRepository.deleteAll();
    }

    public Venue getVenue(String vid) {
        return null;
    }

   /* @Override
    public Meetings getMeeting(Integer meetingId) {
        return meetingsRepository.findOne(meetingId);
    }*/

}
