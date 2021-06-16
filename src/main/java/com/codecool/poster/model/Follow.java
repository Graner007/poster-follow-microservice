package com.codecool.poster.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(FollowKey.class)
public class Follow {

    @Id
    private long followerPersonId;

    @Id
    private long followedPersonId;

    private LocalDateTime followDate;
}
