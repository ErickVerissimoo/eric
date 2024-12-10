package com.everyoneblogsspring.everyonesblogs.dto;

import java.util.UUID;

import org.springframework.lang.Nullable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class PostDTO {
    private UUID id;
    @NotNull
private String title;
@Nullable
private String body;
private byte[] midia;
}
