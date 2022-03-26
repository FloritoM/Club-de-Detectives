package com.club.data;

import com.club.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface iUserDAO extends CrudRepository<User, String>{
    
}
