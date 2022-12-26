package org.crystal.tacocloud.tacos.security;


import org.crystal.tacocloud.tacos.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

//    public SecurityProperties.User toUser(PasswordEncoder passwordEncoder) {
//        return new User(username, password,
//                fullname, street, city, state, zip, phone);
//    }
}
