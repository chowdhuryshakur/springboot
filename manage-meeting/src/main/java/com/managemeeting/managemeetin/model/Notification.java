package com.managemeeting.managemeetin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = {"employeeId","message"})
@Entity
public class Notification {
    private String employeeId;
    @Id
    private String message;

}
