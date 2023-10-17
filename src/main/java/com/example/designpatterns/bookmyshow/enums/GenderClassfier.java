package com.example.designpatterns.bookmyshow.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GenderClassfier {

    enum GenderType {
        MALE(() -> "Male"),
        FEMALE(() -> "Female"),
        TRANSGENDER(() -> "Transgender");

        private final Supplier<String> genderProcessor;

        GenderType(final Supplier<String> genderProcessor) {
            this.genderProcessor = genderProcessor;
        }

        private static final Map<String, GenderType> genderTypeMap = Arrays.stream(GenderType.values())
                .collect(Collectors.toMap(GenderType::name, Function.identity()));

        public static GenderType fromName(final String gender) {
            return genderTypeMap.get(gender.toUpperCase());
        }

        public String getGenderType() {
            return genderProcessor.get();
        }
    }
}
