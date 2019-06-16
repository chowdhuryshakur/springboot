package com.managemeeting.managemeetin.meeting;

import com.managemeeting.managemeetin.venue.Venue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Document(collection = "meeting")
public class Meetings {

   @Id
    private String MId;

   @Field(value = "venueName")
    private String venueId;

    @Field(value = "MeetingSubject")
    private String subject;

    @Field(value = "Time")
    private Integer Time;

    @Field(value = "Date")
    private String date;

    @Field(value = "Duration")
    private Integer duration;


    @OneToMany
    private Venue venues;


    public Meetings() {
    }

    public Meetings(String MId, String venueId, String subject, Integer Time, String date,Integer duration) {
        this.MId = MId;
        this.venueId = venueId;
        this.subject = subject;
        this.Time = Time;
        this.date = date;
        this.duration=duration;
    }

    public String getMId() {
        return MId;
    }

    public void setMId(String MId) {
        this.MId = MId;
    }



    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venue) {
        this.venueId = venue;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "Meetings{" +
                "MId=" + MId +
                ", Venue='" + venueId + '\'' +
                ", subject='" + subject + '\'' +
                ", Time=" + Time +
                ", date=" + date +
                ", duration=" + duration +
                '}';
    }
}
