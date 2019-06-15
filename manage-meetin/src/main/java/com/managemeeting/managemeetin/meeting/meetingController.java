package com.managemeeting.managemeetin.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.managemeeting.managemeetin.service.meetingsService;

@RestController
@RequestMapping("/rest/meetings")
public class meetingController {

    @Autowired(required=true)
    private meetingServiceImpl meetingServiceImpl;

    @PostMapping("/save")
    public Meetings save(@RequestBody Meetings meetings){
        return meetingServiceImpl.save(meetings);
    }

    @PutMapping("/update")
    public Meetings update(@RequestBody Meetings meetings){
        return meetingServiceImpl.update(meetings);
    }

    @GetMapping("/all")
    public List<Meetings> getAll(){
        return  meetingServiceImpl.getAllMeetings();
    }

    @GetMapping("/by/{mId}")
    public Meetings getMeeting(@PathVariable(name="mId") String mId){
        return meetingServiceImpl.getMeeting(mId);
    }

    @DeleteMapping("/delete/{mId}")
    public void deleteMeeting(@PathVariable(name = "mId") String mId){
        meetingServiceImpl.deleteMeeting(mId); }

    @DeleteMapping("/delete")
        public void deleteAllMeeting(){    //(@PathVariable(name = "mId")Integer mId){
         meetingServiceImpl.deleteAllMeeting();
    }

}
