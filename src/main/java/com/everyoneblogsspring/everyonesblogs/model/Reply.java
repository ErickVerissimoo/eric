package com.everyoneblogsspring.everyonesblogs.model;

import java.util.List;
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
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
private String resposta;
@ManyToOne
@JoinColumn(name = "comentario_id")
private Comment comment;
private List<Reply> respostas;
}
