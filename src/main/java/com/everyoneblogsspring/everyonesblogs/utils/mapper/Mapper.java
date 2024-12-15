package com.everyoneblogsspring.everyonesblogs.utils.mapper;

public interface Mapper<T, DTO> {
    T toEntity(DTO dto);
    DTO toDTO(T entity);

}
