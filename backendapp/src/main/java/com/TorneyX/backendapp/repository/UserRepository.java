package com.TorneyX.backendapp.repository;


import com.TorneyX.backendapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
