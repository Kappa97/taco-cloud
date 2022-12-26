package org.crystal.tacocloud.tacos;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String username;
    @Column(nullable = false, length = 64)
    private String password;
    @Column(nullable = false, length = 64)
    private String fullname;
    @Column(nullable = false, length = 64)
    private String street;
    @Column(nullable = false, length = 64)
    private String city;
    @Column(nullable = false, length = 64)
    private String state;
    @Column(nullable = false, length = 64)
    private String zip;
    @Column(nullable = false, length = 64)
    private String phone;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
