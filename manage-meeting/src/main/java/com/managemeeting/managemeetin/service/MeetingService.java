package com.managemeeting.managemeetin.service;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Meetings;
import com.managemeeting.managemeetin.repository.MeetingsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public  class MeetingService {


    private MeetingsRepository meetingRepository;

    public MeetingService(MeetingsRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Meetings insertMeeting(Meetings meeting) throws ResourceAlreadyExistsException {
        Optional<Meetings> optionalMeeting = meetingRepository.findById(meeting.getMeetingId());
        if(optionalMeeting.isPresent()){
            throw new ResourceAlreadyExistsException(meeting.getMeetingId() + "");
        }
        else{
            return meetingRepository.save(meeting);
        }
    }

    public Meetings updateMeeting (String meetingId, Meetings meeting) throws ResourceNotFoundException {
        Optional<Meetings> optionalMeeting = meetingRepository.findById(meetingId);
        if(optionalMeeting.isPresent()){
            meeting.setMeetingId(meetingId);
            return meetingRepository.save(meeting);
        }
        else throw new ResourceNotFoundException(meetingId + "");
    }

    public Meetings findById(String meetingId) throws ResourceNotFoundException {
        Optional<Meetings> optionalMeeting = meetingRepository.findById(meetingId);
        if(optionalMeeting.isPresent()){
            return optionalMeeting.get();
        }else throw new ResourceNotFoundException(meetingId + "");
    }

    public List<Meetings>findAll(){
        List<Meetings>meetingList = new ArrayList<>();
        meetingRepository.findAll().forEach(meetingList::add);
        return meetingList;
    }

    public  boolean deleteById(String meetingId) throws ResourceNotFoundException{
        Optional<Meetings> optionalMeeting = meetingRepository.findById(meetingId);
        optionalMeeting.ifPresent(meeting -> meetingRepository.deleteById(meetingId));
        optionalMeeting.orElseThrow(() -> new ResourceNotFoundException(meetingId + ""));
        return true;
    }



}
