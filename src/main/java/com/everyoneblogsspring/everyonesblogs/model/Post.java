package com.everyoneblogsspring.everyonesblogs.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;
@Entity
@Builder
@Data
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
private String title;
private String body;
@Lob
private byte[] midia;

}