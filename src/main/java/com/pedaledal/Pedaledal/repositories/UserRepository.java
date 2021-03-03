package com.pedaledal.Pedaledal.repositories;

import com.pedaledal.Pedaledal.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByEmail(String email);
}

