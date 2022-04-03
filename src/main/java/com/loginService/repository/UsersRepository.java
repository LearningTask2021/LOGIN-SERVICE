package com.loginService.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.loginService.model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users,String>{

	Optional<Users> findByUserIdAndPassword(String userId,String password);
}
