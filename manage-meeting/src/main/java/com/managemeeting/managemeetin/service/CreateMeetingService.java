package com.managemeeting.managemeetin.service;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.CreateMeetings;
import com.managemeeting.managemeetin.repository.CreateMeetingsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public  class CreateMeetingService {


    private CreateMeetingsRepository createMeetingRepository;

    public CreateMeetingService(CreateMeetingsRepository createMeetingRepository) {
        this.createMeetingRepository = createMeetingRepository;
    }

    public CreateMeetings insertCreateMeeting(CreateMeetings createMeeting) throws ResourceAlreadyExistsException {
        Optional<CreateMeetings> optionalCreateMeeting = createMeetingRepository.findById(createMeeting.getMeetingId());
        if(optionalCreateMeeting.isPresent()){
            throw new ResourceAlreadyExistsException(createMeeting.getMeetingId() + "");
        }
        else{
            return createMeetingRepository.save(createMeeting);
        }
    }

    public CreateMeetings updateCreateMeeting (String meetingId, CreateMeetings createMeeting) throws ResourceNotFoundException {
        Optional<CreateMeetings> optionalCreateMeeting = createMeetingRepository.findById(meetingId);
        if(optionalCreateMeeting.isPresent()){
            createMeeting.setMeetingId(meetingId);
            return createMeetingRepository.save(createMeeting);
        }
        else throw new ResourceNotFoundException(meetingId + "");
    }

    public CreateMeetings findById(String meetingId) throws ResourceNotFoundException {
        Optional<CreateMeetings> optionalCreateMeeting = createMeetingRepository.findById(meetingId);
        if(optionalCreateMeeting.isPresent()){
            return optionalCreateMeeting.get();
        }else throw new ResourceNotFoundException(meetingId + "");
    }

    public List<CreateMeetings>findAll(){
        List<CreateMeetings>createMeetingList = new ArrayList<>();
        createMeetingRepository.findAll().forEach(createMeetingList::add);
        return createMeetingList;
    }

    public  boolean deleteById(String meetingId) throws ResourceNotFoundException{
        Optional<CreateMeetings> optionalCreateMeeting = createMeetingRepository.findById(meetingId);
        optionalCreateMeeting.ifPresent(createMeeting -> createMeetingRepository.deleteById(meetingId));
        optionalCreateMeeting.orElseThrow(() -> new ResourceNotFoundException(meetingId + ""));
        return true;
    }



}
