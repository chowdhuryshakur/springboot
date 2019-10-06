package com.managemeeting.managemeetin.service;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Notification;
import com.managemeeting.managemeetin.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public  class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification insertNotification(Notification notification) throws ResourceAlreadyExistsException {
        Optional<Notification> optionalNotification = notificationRepository.findById(notification.getMessage());
        if(optionalNotification.isPresent()){
            throw new ResourceAlreadyExistsException(notification.getMessage() + "");
        }
        else{
            return notificationRepository.save(notification);
        }
    }

    public Notification updateNotification (String message, Notification notification) throws ResourceNotFoundException {
        Optional<Notification> optionalNotification = notificationRepository.findById(message);
        if(optionalNotification.isPresent()){
            notification.setMessage(message);
            return notificationRepository.save(notification);
        }
        else throw new ResourceNotFoundException(message + "");
    }

    public Notification findById(String message) throws ResourceNotFoundException {
        Optional<Notification> optionalNotification = notificationRepository.findById(message);
        if(optionalNotification.isPresent()){
            return optionalNotification.get();
        }else throw new ResourceNotFoundException(message + "");
    }

    public List<Notification>findAll(){
        List<Notification>notificationList = new ArrayList<>();
        notificationRepository.findAll().forEach(notificationList::add);
        return notificationList;
    }

    public  boolean deleteById(String message) throws ResourceNotFoundException{
        Optional<Notification> optionalNotification = notificationRepository.findById(message);
        optionalNotification.ifPresent(notification -> notificationRepository.deleteById(message));
        optionalNotification.orElseThrow(() -> new ResourceNotFoundException(message + ""));
        return true;
    }



}
