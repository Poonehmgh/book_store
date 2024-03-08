package com.bookz.store;

import com.bookz.store.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<Userr, Long> {
}
