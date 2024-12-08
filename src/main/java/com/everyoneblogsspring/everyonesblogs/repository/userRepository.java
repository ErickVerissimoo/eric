package com.everyoneblogsspring.everyonesblogs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everyoneblogsspring.everyonesblogs.model.User;
@Repository
public interface userRepository extends JpaRepository<User, UUID> {

}
