package com.example.demo.repositories;

import com.example.demo.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u = :user")
    User getUserByInstance(@Param("user") User user);

    @Query("select u from User u where u.username = :name")
    User findUserByUsername(@Param("name") String username);


}
