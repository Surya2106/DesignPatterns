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
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallId;

    private int hallNumber;

    @Column(name = "theatre_id")
    private long theatreId;

    @JoinColumn(name = "hall_id")
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Seat> seatList;

}
