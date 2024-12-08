package com.everyoneblogsspring.everyonesblogs.dto;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.everyoneblogsspring.everyonesblogs.model.Profile;
import com.everyoneblogsspring.everyonesblogs.model.User;

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
public class userDTO implements EntityConverter<User> {
    @Email(message = "Email inválido")
private String email;
@Size(min = 7)
private String password;
private String username;
private UUID id;
private Profile profile;
private String sessionID;
}
