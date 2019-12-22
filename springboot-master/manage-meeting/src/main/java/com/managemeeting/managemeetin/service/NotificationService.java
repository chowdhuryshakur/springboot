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
        Optional<Notification> optionalNotification = notificationRepository.findById(notification.getNotificationId());
        if(optionalNotification.isPresent()){
            throw new ResourceAlreadyExistsException(notification.getNotificationId() + "");
        }
        else{
            return notificationRepository.save(notification);
        }
    }

    public Notification updateNotification (String notificationId, Notification notification) throws ResourceNotFoundException {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        if(optionalNotification.isPresent()){
            notification.setNotificationId(notificationId);
            return notificationRepository.save(notification);
        }
        else throw new ResourceNotFoundException(notificationId + "");
    }

    public Notification findById(String notificationId) throws ResourceNotFoundException {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        if(optionalNotification.isPresent()){
            return optionalNotification.get();
        }else throw new ResourceNotFoundException(notificationId + "");
    }

    public List<Notification>findAll(){
        List<Notification>notificationList = new ArrayList<>();
        notificationRepository.findAll().forEach(notificationList::add);
        return notificationList;
    }

    public  boolean deleteById(String notificationId) throws ResourceNotFoundException{
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        optionalNotification.ifPresent(notification -> notificationRepository.deleteById(notificationId));
        optionalNotification.orElseThrow(() -> new ResourceNotFoundException(notificationId + ""));
        return true;
    }



}
