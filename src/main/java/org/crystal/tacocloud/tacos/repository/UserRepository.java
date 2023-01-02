package org.crystal.tacocloud.tacos.repository;

import org.crystal.tacocloud.tacos.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
