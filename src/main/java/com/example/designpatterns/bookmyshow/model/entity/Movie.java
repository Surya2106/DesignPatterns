package com.example.designpatterns.bookmyshow.model.entity;

import com.example.designpatterns.bookmyshow.enums.LanguageType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "movieList")
    private List<Technician> technicianList;

    private LanguageType languageType;

}
