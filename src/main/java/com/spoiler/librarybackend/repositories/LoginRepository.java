package com.spoiler.librarybackend.repositories;

import com.spoiler.librarybackend.model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("LoginRepository")
public interface LoginRepository extends MongoRepository<Login, Integer> {

    Optional<Login> findByUsernameAndPassword(String username, String password);

    Optional<Login> findByUsername(String username);
}
