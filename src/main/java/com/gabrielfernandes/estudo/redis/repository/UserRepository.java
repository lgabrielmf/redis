package com.gabrielfernandes.estudo.redis.repository;


import com.gabrielfernandes.estudo.redis.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
