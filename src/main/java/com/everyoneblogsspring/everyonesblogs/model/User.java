package com.everyoneblogsspring.everyonesblogs.model;

import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint (columnNames = {"email", "username", "session_id"})})
@NoArgsConstructor
@AllArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    @Email(message = "Email inválido")
    private String email;
    @Column( name = "session_id")
    private String sessionID;
    private String password;
    @OneToOne
    private Profile profile;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true)
    private List <Post> posts;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List <Comment> comments;
    @OneToMany(mappedBy = "userReply", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Reply> replys;
}
