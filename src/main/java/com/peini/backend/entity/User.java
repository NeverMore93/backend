package com.peini.backend.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userID;
    @NotBlank
    @Column(name = "user_name")
    private String userName;
    @Email
    @Column(name = "email")
    private String email;
}
