package com.example.designpatterns.bookmyshow.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cityId;

    private String name;

    private String pinCode;


    @JoinColumn(name = "city_id")
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Theatre> theatreList;
}
