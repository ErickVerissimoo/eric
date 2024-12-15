package com.everyoneblogsspring.everyonesblogs.dto;

import lombok.Data;
@Data
public class CommentDTO {
   
private String comentario;

private UserDTO user;

private PostDTO post;
}
