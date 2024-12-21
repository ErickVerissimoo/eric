package com.everyoneblogsspring.everyonesblogs.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.everyoneblogsspring.everyonesblogs.model.Post;
@Repository
public interface postRepository extends JpaRepository<Post, UUID> {
    @Query("SELECT p FROM Post p WHERE p.time >= CURRENT_TIMESTAMP - 1 DAY ORDER BY p.time DESC")
    List<Post> lastPosts();
}
