package com.codecool.poster.repository;

import com.codecool.poster.model.follow.Follow;
import com.codecool.poster.model.follow.FollowKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FollowRepository extends JpaRepository<Follow, FollowKey> {

    Collection<Follow> findAllByFollowerPersonId(long personId);

}
