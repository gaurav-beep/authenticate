package com.spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserModel {
@Id
@Column(name="username",unique = true)
private String username;
@Column
private String password;
@Column
private String roles;
@Column
private String emailid;
}
