package com.managemeeting.managemeetin.controller;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Venue;
import com.managemeeting.managemeetin.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {

    private VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("")
    public ResponseEntity<List<Venue>> getVenue(){
        List<Venue> VenueList = venueService.findAll();
        return ResponseEntity.ok(VenueList);
    }

    @GetMapping("/{venueId}")
    public ResponseEntity<Venue> getVenue(@PathVariable String venueId){
        try{
            Venue venue = venueService.findById(venueId);
            return ResponseEntity.ok(venue);}
        catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception f){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public  ResponseEntity<Venue> insertVenue(@RequestBody Venue venue){
        try{
            Venue insertVenue = venueService.insertVenue(venue);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertVenue);}
        catch (ResourceAlreadyExistsException e) {return ResponseEntity.badRequest().body(null);}
    }

    @PutMapping("/{venueId}")
    public  ResponseEntity<Venue> updateVenue(@PathVariable String venueId, @RequestBody Venue venue){
        try{
            Venue updateVenue = venueService.updateVenue(venueId, venue);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVenue);}
        catch (ResourceNotFoundException e) {return ResponseEntity.badRequest().body(null);}

    }

    @DeleteMapping("/{venueId}")
    public ResponseEntity<String> deleteVenue(@PathVariable String venueId){
        try{
            boolean deletedVenue = venueService.deleteById(venueId);
            return ResponseEntity.ok(venueId);}
        catch (ResourceNotFoundException e){return ResponseEntity.notFound().build();}
    }

}
