package com.codecool.poster.controller;

import com.codecool.poster.service.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "follow")
public class FollowRepositoryController {

    private final FollowService followService;

    @GetMapping(path = "/followers")
    public ResponseEntity followers(@PathVariable String personId) { return followService.getFollowersByPersonId(Long.parseLong(personId)); }
}
