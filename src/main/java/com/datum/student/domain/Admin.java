package com.datum.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name="user_details")
public class Admin {

    @Id
    private Long id;
    
    private String userName;

    private String password;
}
