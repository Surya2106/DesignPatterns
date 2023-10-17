package com.example.designpatterns.bookmyshow.model.dto;

import com.example.designpatterns.bookmyshow.enums.GenderType;
import com.example.designpatterns.bookmyshow.util.typeconverter.GenderTypeConverter;
import jakarta.persistence.Convert;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    @Convert(converter = GenderTypeConverter.class)
    private String gender;
}
