package com.everyoneblogsspring.everyonesblogs.dto;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class ProfileDTO  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
@Lob
private byte[] imagemPerfil;
@Lob
private byte[] imagemFundo;

private String username;
private UserDTO dto;
}
