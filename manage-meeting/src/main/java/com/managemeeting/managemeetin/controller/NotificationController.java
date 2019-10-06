package com.managemeeting.managemeetin.controller;

import com.managemeeting.managemeetin.CustomizeException.ResourceAlreadyExistsException;
import com.managemeeting.managemeetin.CustomizeException.ResourceNotFoundException;
import com.managemeeting.managemeetin.model.Notification;
import com.managemeeting.managemeetin.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("")
    public ResponseEntity<List<Notification>> getNotification(){
        List<Notification> notificationList = notificationService.findAll();
        return ResponseEntity.ok(notificationList);
    }

    @GetMapping("/{message}")
    public ResponseEntity<Notification> getNotification(@PathVariable String message){
        try{
            Notification notification = notificationService.findById(message);
            return ResponseEntity.ok(notification);}
        catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception f){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public  ResponseEntity<Notification> insertNotification(@RequestBody Notification notification){
        try{
            Notification insertNotification = notificationService.insertNotification(notification);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertNotification);}
        catch (ResourceAlreadyExistsException e) {return ResponseEntity.badRequest().body(null);}
    }

    @PutMapping("/{message}")
    public  ResponseEntity<Notification> updateNotification(@PathVariable String message, @RequestBody Notification notification){
        try{
            Notification updateNotification = notificationService.updateNotification(message, notification);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateNotification);}
        catch (ResourceNotFoundException e) {return ResponseEntity.badRequest().body(null);}

    }

    @DeleteMapping("/{message}")
    public ResponseEntity<String> deleteNotification(@PathVariable String message){
        try{
            boolean deletedNotification = notificationService.deleteById(message);
            return ResponseEntity.ok(message);}
        catch (ResourceNotFoundException e){return ResponseEntity.notFound().build();}
    }

}
