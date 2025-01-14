package com.everyoneblogsspring.everyonesblogs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.everyoneblogsspring.everyonesblogs.model.User;
import java.util.Optional;



@Repository
public interface userRepository extends JpaRepository<User, UUID> {
Optional <User>findByEmail(String email);
boolean existsByEmail(String email);
@Query("Select u.id from User u where u.email =:email")
UUID findIdByEmail(@Param("email")String email);
User findByUsername(String username);
@Query("Select u.sessionID from User u where u.id=:id")
String findSessionById(@Param("id")String id);
}
