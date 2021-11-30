package com.example.template.repository;

import com.example.template.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
}
