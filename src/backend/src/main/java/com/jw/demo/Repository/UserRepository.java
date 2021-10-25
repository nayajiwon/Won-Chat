package com.jw.demo.Repository;

import com.jw.demo.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
//    @Query(value = "Select * from user U Where U.id = ?1 ", nativeQuery = true)
//    User findbyUserId(String id);

    @Query(value = "SELECT * FROM user U WHERE U.email = ?1", nativeQuery = true)
    Optional<User> findByUserEmail(String email);
}
