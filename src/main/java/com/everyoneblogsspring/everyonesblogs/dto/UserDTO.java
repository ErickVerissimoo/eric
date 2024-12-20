package com.everyoneblogsspring.everyonesblogs.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserDTO{
    @Email(message = "Email inválido")
private String email;
@Size(min = 7)
private String password;
private String username;
private ProfileDTO profile;
private String sessionID;
private List<PostDTO> posts;
private List<CommentDTO>comments;
}
