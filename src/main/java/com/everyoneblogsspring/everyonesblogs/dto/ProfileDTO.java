package com.everyoneblogsspring.everyonesblogs.dto;


import lombok.Data;
@Data
public class ProfileDTO  {
private byte[] imagemPerfil;
private byte[] imagemFundo;

private String username;
private UserDTO user;
}
