package com.codecool.poster.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PersonResult {

    private long id;

    private String username;

    private String email;

    private LocalDate birthDate;

    private int followersCount;

    private int followedCount;

}
