package com.everyoneblogsspring.everyonesblogs.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@OneToMany(mappedBy = "primary", cascade = CascadeType.REMOVE, orphanRemoval = true)
private List<Reply> respostas;
@ManyToOne
@JoinColumn(name =  "primary_id")
private Reply primary;
@ManyToOne
@JoinColumn(name = "userReply_id")
private User userReply;
}
