package com.everyoneblogsspring.everyonesblogs.dto;

import java.util.UUID;

import com.everyoneblogsspring.everyonesblogs.model.Profile;
import com.everyoneblogsspring.everyonesblogs.model.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
public class ProfileDTO implements EntityConverter<Profile> {
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
