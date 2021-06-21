package com.example.template.repository;

import com.example.template.models.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssetsRepository  extends JpaRepository<Assets, UUID> {
}
