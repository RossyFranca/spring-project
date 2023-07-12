package com.franca.hruser.repositories;

import com.franca.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
    User findByEmail(String email);

}
