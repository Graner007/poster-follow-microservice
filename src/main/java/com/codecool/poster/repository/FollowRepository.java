package com.codecool.poster.repository;

import com.codecool.poster.model.Follow;
import com.codecool.poster.model.FollowKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, FollowKey> {
}
