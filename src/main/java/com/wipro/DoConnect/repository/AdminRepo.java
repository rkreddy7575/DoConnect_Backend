package com.wipro.DoConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.DoConnect.entities.Admin;
import com.wipro.DoConnect.entities.User;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    Admin findFirstByEmail(String email);

    Optional<Admin> findByEmail(String email);
}
