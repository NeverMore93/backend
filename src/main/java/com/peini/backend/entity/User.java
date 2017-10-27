package com.peini.backend.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Component
@ToString
@Table(name = "user")
@Embeddable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
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

    private String salt;//加密密码的盐

    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    
    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private Set<Role> roles = new HashSet<Role>();// 一个用户具有多个角色



}
