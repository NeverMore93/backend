package com.peini.backend.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="role")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Role implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional=false)
    @Column(length=100)
    private String name;

    @Basic(optional=false)
    @Column(length=255)
    private String description;

    @ElementCollection(targetClass=String.class)
    @JoinTable(name="roles_permissions")
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    private Set<String> permissions;

}
