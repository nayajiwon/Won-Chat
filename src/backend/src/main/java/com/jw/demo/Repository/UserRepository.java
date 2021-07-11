package com.jw.demo.Repository;

import com.jw.demo.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user U where U.email = ?1", nativeQuery = true)
    Optional<User> findByUserEmail(String email);
}
