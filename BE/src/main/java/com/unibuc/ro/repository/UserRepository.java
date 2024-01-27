package com.unibuc.ro.repository;

import com.unibuc.ro.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByUsername(String username);

    Optional<UserDetails> findByUsernameAndPassword(String username, String password);
}
