package com.aint.commerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="UserProfile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPassword")
    private String userPassword;

}
