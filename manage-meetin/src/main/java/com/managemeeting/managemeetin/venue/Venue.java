package com.managemeeting.managemeetin.venue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;

@Entity
@Document
public class Venue {
    @Id
    private String vid;

    @Field(value = "seatLimit")
    private Integer capacity;

    @Field(value = "audioFacility")
    private String audioFacility;

    @Field(value = "videoFacility")
    private String videoFacility;

    public Venue() {

    }

    public Venue(String vid, Integer capacity, String audioFacility, String videoFacility) {
        this.vid = vid;
        this.capacity = capacity;
        this.audioFacility = audioFacility;
        this.videoFacility = videoFacility;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAudioFacility() {
        return audioFacility;
    }

    public void setAudioFacility(String audio_facility) {
        this.audioFacility = audio_facility;
    }

    public String getVideoFacility() {
        return videoFacility;
    }

    public void setVideo_facility(String video_facility) {
        this.videoFacility = video_facility;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "vid=" + vid +
                ", capacity=" + capacity +
                ", audio_facility='" + audioFacility + '\'' +
                ", video_facility='" + videoFacility + '\'' +
                '}';
    }
}
