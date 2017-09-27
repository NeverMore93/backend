package com.peini.backend.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Component
@ToString
@Table(name = "user")
@Embeddable
public class User implements Serializable{
    private static final long serialVersionUID = -1L;

    public enum Gender {
        MALE, FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "user_name")
    @Size(min = 3, max = 80)
    private String userName;

    @Email
    @Column(name = "email",unique = true)
    @Size(min = 5, max = 80)
    private String email;

    @Column(name = "password")
    @Size(min = 6, max = 20)
    private String password;

    @Column(name = "registered_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;

    @Column(name = "gender")
    private Gender gender;


}
