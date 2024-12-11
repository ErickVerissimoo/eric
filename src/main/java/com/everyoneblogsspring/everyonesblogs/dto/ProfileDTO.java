package com.everyoneblogsspring.everyonesblogs.dto;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
public class ProfileDTO  {
private UUID id;
private byte[] imagemPerfil;
private byte[] imagemFundo;

private String username;
private UserDTO dto;
}
