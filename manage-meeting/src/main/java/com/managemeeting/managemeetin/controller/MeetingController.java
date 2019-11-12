package com.managemeeting.managemeetin.controller;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Meetings;
import com.managemeeting.managemeetin.service.MeetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meetings")
public class MeetingController {

    private MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("")
    public ResponseEntity<List<Meetings>> getMeeting(){
        List<Meetings> meetingList = meetingService.findAll();
        return ResponseEntity.ok(meetingList);
    }

    @GetMapping("/{meetingId}")
    public ResponseEntity<Meetings> getMeeting(@PathVariable String meetingId){
        try{
            Meetings meeting = meetingService.findById(meetingId);
            return ResponseEntity.ok(meeting);}
        catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception f){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public  ResponseEntity<Meetings> insertMeeting(@RequestBody Meetings meeting){
        try{
            Meetings insertedMeeting = meetingService.insertMeeting(meeting);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertedMeeting);}
        catch (ResourceAlreadyExistsException e) {return ResponseEntity.badRequest().body(null);}

    }

    @PutMapping("/{meetingId}")
    public  ResponseEntity<Meetings> updateMeeting(@PathVariable String meetingId, @RequestBody Meetings meeting){
        try{
            Meetings updateMeeting = meetingService.updateMeeting(meetingId, meeting);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateMeeting);}
        catch (ResourceNotFoundException e) {return ResponseEntity.badRequest().body(null);}

    }

    @DeleteMapping("/{meetingId}")
    public ResponseEntity<String> deleteMeeting(@PathVariable String meetingId){
        try{
            boolean deletedMeeting = meetingService.deleteById(meetingId);
            return ResponseEntity.ok(meetingId);}
        catch (ResourceNotFoundException e){return ResponseEntity.notFound().build();}
    }

}
