package com.codecool.poster.service;

import com.codecool.poster.model.Follow;
import com.codecool.poster.model.PersonResult;
import com.codecool.poster.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        PersonResult followedPerson = restTemplate.getForEntity(baseUrl + "/" + String.valueOf(followedId), PersonResult.class).getBody();
        PersonResult followerPerson = restTemplate.getForEntity(baseUrl + "/" + String.valueOf(followerId), PersonResult.class).getBody();

        if (personRepository.findById(Long.parseLong(followedId)).isPresent() && personRepository.findById(Long.parseLong(followerId)).isPresent()) {
            Person followedPerson = personRepository.findById(Long.parseLong(followedId)).get();
            Person followerPerson = personRepository.findById(Long.parseLong(followerId)).get();

            if (!followRepository.findByFollowerPerson_IdEqualsAndAndFollowedPerson_IdEquals(followerPerson.getId(), followedPerson.getId())) {
                Follow follow = Follow.builder()
                        .followerPerson(followerPerson)
                        .followedPerson(followedPerson)
                        .followDate(LocalDateTime.now())
                        .build();

                followRepository.save(follow);
            }

            throw new IllegalArgumentException("User already followed");
        }

        throw new UsernameNotFoundException("Username not found!");
    }
}
