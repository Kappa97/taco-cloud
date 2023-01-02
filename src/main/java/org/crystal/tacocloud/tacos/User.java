package org.crystal.tacocloud.tacos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 64)
    private String firstName;
    @Column(nullable = false, length = 64)
    private String lastName;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 64)
    private String password;
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

//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

}
