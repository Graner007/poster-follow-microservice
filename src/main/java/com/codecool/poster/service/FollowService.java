package com.codecool.poster.service;

import com.codecool.poster.model.Follow;
import com.codecool.poster.model.FollowKey;
import com.codecool.poster.model.PersonResult;
import com.codecool.poster.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${person.service.url}")
    private String baseUrl;

    public void followPerson(long followedId, long followerId) {
        ResponseEntity<PersonResult> followedPersonResponse = restTemplate.getForEntity(baseUrl + "/" + String.valueOf(followedId), PersonResult.class);
        ResponseEntity<PersonResult> followerPersonResponse = restTemplate.getForEntity(baseUrl + "/" + String.valueOf(followerId), PersonResult.class);

        if (followedPersonResponse.getStatusCode().is2xxSuccessful() && followerPersonResponse.getStatusCode().is2xxSuccessful()) {
            PersonResult followedPerson = followedPersonResponse.getBody();
            PersonResult followerPerson = followerPersonResponse.getBody();

            if (!followRepository.existsById(new FollowKey(followedPerson.getId(), followerPerson.getId()))) {
                Follow follow = Follow.builder()
                        .followedPersonId(followedPerson.getId())
                        .followerPersonId(followerPerson.getId())
                        .followDate(LocalDateTime.now())
                        .build();

                followRepository.save(follow);
            }

            throw new IllegalArgumentException("User already followed");
        }

        throw new IllegalArgumentException("Username not found!");
    }
}
