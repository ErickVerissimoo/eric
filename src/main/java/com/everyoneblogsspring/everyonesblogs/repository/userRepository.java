package com.everyoneblogsspring.everyonesblogs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everyoneblogsspring.everyonesblogs.model.User;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, UUID> {
Optional <User>findByEmail(String email);
boolean existsByEmail(String email);
}
