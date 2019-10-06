package com.managemeeting.managemeetin.controller;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.CreateMeetings;
import com.managemeeting.managemeetin.service.CreateMeetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/createmeetings")
public class CreateMeetingController {

    private CreateMeetingService createMeetingService;

    public CreateMeetingController(CreateMeetingService createMeetingService) {
        this.createMeetingService = createMeetingService;
    }

    @GetMapping("")
    public ResponseEntity<List<CreateMeetings>> getCreateMeeting(){
        List<CreateMeetings> createMeetingList = createMeetingService.findAll();
        return ResponseEntity.ok(createMeetingList);
    }

    @GetMapping("/{meetingId}")
    public ResponseEntity<CreateMeetings> getCreateMeeting(@PathVariable String meetingId){
        try{
            CreateMeetings createMeeting = createMeetingService.findById(meetingId);
            return ResponseEntity.ok(createMeeting);}
        catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception f){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public  ResponseEntity<CreateMeetings> insertCreateMeeting(@RequestBody CreateMeetings createMeeting){
        try{
            CreateMeetings insertCreateMeeting = createMeetingService.insertCreateMeeting(createMeeting);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertCreateMeeting);}
        catch (ResourceAlreadyExistsException e) {return ResponseEntity.badRequest().body(null);}

    }

    @PutMapping("/{meetingId}")
    public  ResponseEntity<CreateMeetings> updateCreateMeeting(@PathVariable String meetingId, @RequestBody CreateMeetings createMeeting){
        try{
            CreateMeetings updateCreateMeeting = createMeetingService.updateCreateMeeting(meetingId, createMeeting);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateCreateMeeting);}
        catch (ResourceNotFoundException e) {return ResponseEntity.badRequest().body(null);}

    }

    @DeleteMapping("/{meetingId}")
    public ResponseEntity<String> deleteCreateMeeting(@PathVariable String meetingId){
        try{
            boolean deletedCreateMeeting = createMeetingService.deleteById(meetingId);
            return ResponseEntity.ok(meetingId);}
        catch (ResourceNotFoundException e){return ResponseEntity.notFound().build();}
    }

}
