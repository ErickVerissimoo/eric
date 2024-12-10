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
    @Mapping(target = "profile", ignore = true)
    UserDTO toUserDTO(User user);

    @Mapping(target = "profile", source = "userDTO.profile") 
    @Mapping(target = "posts", ignore = true) 
    User toUser(UserDTO userDTO);

    @Mapping(target = "profile", source = "userDTO.profile") 
    @Mapping(target = "posts", ignore = true)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);

    @Mapping(target = "user", ignore = true) 
    Profile toProfile(ProfileDTO profileDTO);

    PostDTO toPostDTO(Post post);

    @Mapping(target = "user", ignore = true)
    Post toPost(PostDTO postDTO);

    List<PostDTO> toPostDTOs(List<Post> posts);

    List<Post> toPosts(List<PostDTO> postDTOs);
}