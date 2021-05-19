package com.jw.demo.Repository;

import com.jw.demo.DTO.RedisUserDto;
import org.springframework.data.repository.CrudRepository;

public interface RedisUserRepository extends CrudRepository<RedisUserDto, String> {
}
