package com.codecool.poster.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FollowKey implements Serializable {

    private long followerPersonId;

    private long followedPersonId;
}
