package com.everyoneblogsspring.everyonesblogs.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
@Entity
@Builder
@Data
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
private String title;
private String body;
@Lob
private byte[] midia;
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
private List<Comment> comentarios;
private LocalDateTime time;
}
