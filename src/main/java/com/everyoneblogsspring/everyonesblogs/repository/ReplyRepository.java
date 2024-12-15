package com.everyoneblogsspring.everyonesblogs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everyoneblogsspring.everyonesblogs.model.Reply;
@Repository
public interface ReplyRepository extends JpaRepository<Reply, UUID>{

}
