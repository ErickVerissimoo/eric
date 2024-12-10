package com.everyoneblogsspring.everyonesblogs.utils;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.everyoneblogsspring.everyonesblogs.dto.PostDTO;
import com.everyoneblogsspring.everyonesblogs.dto.ProfileDTO;
import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.model.Profile;
import com.everyoneblogsspring.everyonesblogs.model.User;
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "profile", target = "profile") 
    @Mapping(source = "posts", target = "posts")    
    UserDTO toUserDTO(User user);

    @Mapping(target = "profile", ignore = true) 
    @Mapping(target = "posts", ignore = true)  
    User toUser(UserDTO userDTO);

    @Mapping(target = "profile", ignore = true)
    @Mapping(target = "posts", ignore = true)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);

    @Mapping(source = "user.id", target = "dto.id")
    @Mapping(source = "user.email", target = "dto.email")
    @Mapping(source = "user.username", target = "dto.username")
    ProfileDTO toProfileDTO(Profile profile);

    @Mapping(target = "user", ignore = true)
    Profile toProfile(ProfileDTO profileDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "body", source = "body")
    @Mapping(target = "midia", source = "midia")
    PostDTO toPostDTO(Post post);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "body", source = "body")
    @Mapping(target = "midia", source = "midia")
    @Mapping(target = "user", ignore = true)
    Post toPost(PostDTO postDTO);

    List<PostDTO> toPostDTOs(List<Post> posts);

    List<Post> toPosts(List<PostDTO> postDTOs);
}
