package com.aint.commerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="UserProfile")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;

    public UserProfile(){}
    public UserProfile(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public UserProfile(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.password = userPassword;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
