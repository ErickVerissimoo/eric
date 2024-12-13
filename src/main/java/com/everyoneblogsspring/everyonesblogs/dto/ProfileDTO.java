package com.everyoneblogsspring.everyonesblogs.dto;

import java.util.UUID;

import lombok.Data;
@Data
public class ProfileDTO  {
private UUID id;
private byte[] imagemPerfil;
private byte[] imagemFundo;

private String username;
private UserDTO user;
}
