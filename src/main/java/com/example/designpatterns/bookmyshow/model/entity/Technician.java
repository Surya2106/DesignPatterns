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
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technicianId;
    private String name;
    private int age;

    @ManyToMany
    @JoinTable(
            name = "movie_technician",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "technician_id")
    )
    private List<Movie> movieList;

}
