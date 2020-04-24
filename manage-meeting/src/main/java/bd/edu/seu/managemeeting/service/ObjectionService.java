package bd.edu.seu.managemeeting.service;

import bd.edu.seu.managemeeting.exception.ResourceAlreadyExistsException;
import bd.edu.seu.managemeeting.exception.ResourceNotFoundException;
import bd.edu.seu.managemeeting.model.Objection;
import bd.edu.seu.managemeeting.model.Venue;
import bd.edu.seu.managemeeting.repository.ObjectionRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public  class ObjectionService {


    private ObjectionRepository objectionRepository;
    //private MeetingsRepository meetingRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ObjectionService(ObjectionRepository objectionRepository /*, MeetingsRepository meetingRepository*/) {
        this.objectionRepository = objectionRepository;
        //this.meetingRepository = meetingRepository;
    }

    public Objection insertObjection(Objection objection) throws ResourceAlreadyExistsException {
        Optional<Objection> optionalObjection = objectionRepository.findById(objection.get_id().toString());
        if(optionalObjection.isPresent()){
            logger.warn("Objection ID {} already exists", objection.get_id());
            throw new ResourceAlreadyExistsException(objection.get_id() + "");
        }
        else{
            return objectionRepository.save(objection);
            }
    }

    public Objection updateObjection (ObjectId objectionId, Objection objection) throws ResourceNotFoundException {
        Optional<Objection> optionalObjection = objectionRepository.findById(objectionId.toString());
        if(optionalObjection.isPresent()){
            objection.set_id(objectionId);
            return objectionRepository.save(objection);
        }
        else {logger.warn("Objection ID {} doesn't exist", objection.get_id());
            throw new ResourceNotFoundException(objectionId + "");}
    }

    public Objection findById(String objectionId) throws ResourceNotFoundException {
        Optional<Objection> optionalObjection = objectionRepository.findById(objectionId);
        if(optionalObjection.isPresent()){
            return optionalObjection.get();
        }else {
            logger.warn("Objection ID {} doesn't exist", objectionId);
            throw new ResourceNotFoundException(objectionId + "");
        }
        }

    public List<Objection>findAll(){
        List<Objection>objectionList = new ArrayList<>();
        objectionRepository.findAll().forEach(objectionList::add);
        return objectionList;
    }

    public  boolean deleteById(String objectionId) throws ResourceNotFoundException{
        Optional<Objection> optionalObjection = objectionRepository.findById(objectionId);
        optionalObjection.ifPresent(objection -> objectionRepository.deleteById(objectionId));
        logger.info("Objection id {} is deleted", objectionId);
        optionalObjection.orElseThrow(() -> new ResourceNotFoundException(objectionId + ""));
        return true;
    }




}
