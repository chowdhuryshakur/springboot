package com.managemeeting.managemeetin.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableMongoRepositories(basePackageClasses = MeetingsRepository.class)
public  class meetingServiceImpl {

    @Autowired
    private MeetingsRepository meetingsRepository;

    private Object Null;


    public Meetings save(Meetings meeting) {

        return meetingsRepository.save(meeting);
    }


    public Meetings update(Meetings meeting) {
        return meetingsRepository.save(meeting);
    }


    public List<Meetings> getAllMeetings() {
        return meetingsRepository.findAll();
    }

    public List<Meetings> getAllMeeting(String venueVid)
    {
        return meetingsRepository.findByVenueId(venueVid);
    }

    public void deleteAllMeeting() {
        meetingsRepository.deleteAll();
    }

    public void deleteMeeting(String id) {
        meetingsRepository.deleteById(id);
    }


    public Meetings getMeeting(String id) {
        return meetingsRepository.findById(id).orElse((Meetings) Null);
    }

}
