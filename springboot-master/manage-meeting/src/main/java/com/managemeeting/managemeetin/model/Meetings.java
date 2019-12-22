package com.managemeeting.managemeetin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"meetingId"})
@Entity
public class Meetings {
   @Id
    private String meetingId;
    private Venue venue;
    private String subject;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, HH:MM:SS")
    private LocalDateTime DateAndTime;
    private Integer duration;
    private List<Employee> employeeList;
}
