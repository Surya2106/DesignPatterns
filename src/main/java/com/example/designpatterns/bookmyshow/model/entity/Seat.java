package com.example.designpatterns.bookmyshow.model.entity;

import com.example.designpatterns.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long seatId;

    private SeatType seatType;

    private String seatNumber;

    @Column(name = "hall_id")
    private Long hallId;
}
