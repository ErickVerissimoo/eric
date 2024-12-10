package com.everyoneblogsspring.everyonesblogs.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
private UUID id;

private byte[] imagemPerfil;
private byte[] imagemFundo;
@OneToOne(mappedBy = "profile")
private User user;
private String username;


}
