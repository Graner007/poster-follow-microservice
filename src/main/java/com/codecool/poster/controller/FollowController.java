package com.codecool.poster.controller;

import com.codecool.poster.service.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/profile")
public class FollowController {

    private final FollowService followService;

    @PostMapping("/{id}")
    public void follow(@PathVariable("id") long followedId,
                       @RequestHeader long followerId) {
        followService.followPerson(followedId, followerId);
    }
}
