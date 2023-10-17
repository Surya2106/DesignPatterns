package com.example.designpatterns.bookmyshow.model.entity;

import com.example.designpatterns.bookmyshow.enums.GenderType;
import com.example.designpatterns.bookmyshow.util.typeconverter.GenderTypeConverter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    @Convert(converter = GenderTypeConverter.class)
    private GenderType genderType;

}
