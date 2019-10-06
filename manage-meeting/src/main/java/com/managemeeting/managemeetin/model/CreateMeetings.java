package com.managemeeting.managemeetin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"meetingId"})
@Entity
public class CreateMeetings {
   @Id
    private String meetingId;
    private String venueId;
    private String subject;
    private Integer Time;
    private LocalDate date;
    private Integer duration;
    private List<Employee> employeeList;
}
