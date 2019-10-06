package com.managemeeting.managemeetin.service;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Venue;
import com.managemeeting.managemeetin.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public  class VenueService{


    private VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Venue insertVenue(Venue venue) throws ResourceAlreadyExistsException {
        Optional<Venue> optionalVenue = venueRepository.findById(venue.getVenueId());
        if(optionalVenue.isPresent()){
            throw new ResourceAlreadyExistsException(venue.getVenueId() + "");
        }
        else{
            return venueRepository.save(venue);
        }
    }

    public Venue updateVenue (String venueId, Venue venue) throws ResourceNotFoundException {
        Optional<Venue> optionalVenue = venueRepository.findById(venueId);
        if(optionalVenue.isPresent()){
            venue.setVenueId(venueId);
            return venueRepository.save(venue);
        }
        else throw new ResourceNotFoundException(venueId + "");
    }

    public Venue findById(String venueId) throws ResourceNotFoundException {
        Optional<Venue> optionalVenue = venueRepository.findById(venueId);
        if(optionalVenue.isPresent()){
            return optionalVenue.get();
        }else throw new ResourceNotFoundException(venueId + "");
    }

    public List<Venue>findAll(){
        List<Venue>venueList = new ArrayList<>();
        venueRepository.findAll().forEach(venueList::add);
        return venueList;
    }

    public  boolean deleteById(String venueId) throws ResourceNotFoundException{
        Optional<Venue> optionalVenue = venueRepository.findById(venueId);
        optionalVenue.ifPresent(venue -> venueRepository.deleteById(venueId));
        optionalVenue.orElseThrow(() -> new ResourceNotFoundException(venueId + ""));
        return true;
    }




}
