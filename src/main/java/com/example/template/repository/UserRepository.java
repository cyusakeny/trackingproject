package com.example.template.repository;

import com.example.template.enums.EStatus;
import com.example.template.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailOrMobile(String email, String mobile);
    List<User> findByStatus(EStatus eStatus);
    Boolean existsByMobile(String mobile);
}
