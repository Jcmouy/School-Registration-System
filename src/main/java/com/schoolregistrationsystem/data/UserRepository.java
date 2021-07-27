package com.schoolregistrationsystem.data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolregistrationsystem.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
