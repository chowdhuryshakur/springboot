package com.managemeeting.managemeetin.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.managemeeting.managemeetin.service.meetingsService;

@RestController
@RequestMapping("/rest/venue")
public class venueController {

    @Autowired(required=true)
    private venueServiceImpl venueServiceImpl;

    @PostMapping("/save")
    public Venue save(@RequestBody Venue venue){
        return venueServiceImpl.save(venue);
    }
    @PutMapping("/update")
    public Venue update(@RequestBody Venue venue){
        return venueServiceImpl.update(venue);
    }
    @GetMapping("/all")
    public List<Venue> getAll(){
        return  venueServiceImpl.getAllVenue();
    }
    @GetMapping("/by/{vid}")
    public Venue getVenue(@PathVariable(name="vid") String vid){
        return venueServiceImpl.getVenue(vid);
    }

    @DeleteMapping("/delete/{vId}")
    public void deleteVenue(@PathVariable(name = "vId") String vId){
        venueServiceImpl.deleteVenue(vId); }

   @DeleteMapping("/delete")
        public void deleteAllVenue(){    //(@PathVariable(name = "mId")Integer mId){
         venueServiceImpl.deleteAllVenue();
    }

}
