package com.example.test_two.repository;

import com.example.test_two.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.Size;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT nextval(pg_get_serial_sequence('t_user', 'id'))",
            nativeQuery = true)
    Long getNextId();

    User findByUsername(@Size(min = 2, message = "at least 5 characters") String username);
}
