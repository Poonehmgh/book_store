package com.bookz.store.repo;

import com.bookz.store.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Userr, Long> {
    Optional<Userr> findByEmail(String username);
}
