package com.peini.backend.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable{
    private long UserID;
    private String Name;
}
