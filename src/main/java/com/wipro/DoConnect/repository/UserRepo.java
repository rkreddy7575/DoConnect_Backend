package com.wipro.DoConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.DoConnect.entities.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

    User findByRole(Integer role);

    List<User> findAllByRole(int i);
}
