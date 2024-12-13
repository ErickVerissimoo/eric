package com.everyoneblogsspring.everyonesblogs.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
private String comentario;
@ManyToOne
@JoinColumn(name = "usuario_id")
private User user;
}
