package com.everyoneblogsspring.everyonesblogs.dto;

import org.springframework.beans.BeanUtils;

public interface EntityConverter <T> {
default T toEntity(Class<T> clazz){
    try{
       
    T instance = clazz.getDeclaredConstructor().newInstance();
    BeanUtils.copyProperties(this, instance);
    return instance;
    }
    catch(Exception e){
        e.printStackTrace();
        return null;
    }
}


}
