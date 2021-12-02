package com.example.template.repository;

import com.example.template.models.Assets;
import com.example.template.models.Reviews;
import com.example.template.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findByAssets(Assets asset);
    List <Reviews> findBySentBy(User user);
}
