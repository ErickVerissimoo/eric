package com.everyoneblogsspring.everyonesblogs.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class userDTO {
private String email;
private String password;
private String username;

}
