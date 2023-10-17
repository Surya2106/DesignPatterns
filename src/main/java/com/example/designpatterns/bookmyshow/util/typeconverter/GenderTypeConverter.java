package com.example.designpatterns.bookmyshow.util.typeconverter;

import com.example.designpatterns.bookmyshow.enums.GenderType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderTypeConverter implements AttributeConverter<GenderType, String> {

    @Override
    public String convertToDatabaseColumn(GenderType attribute) {
        return null;
    }

    @Override
    public GenderType convertToEntityAttribute(String dbData) {
        return null;
    }
}
