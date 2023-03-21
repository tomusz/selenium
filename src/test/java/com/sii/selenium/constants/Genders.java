package com.sii.selenium.constants;

import java.util.Arrays;
import java.util.Optional;

public enum Genders {
    MALE("Male", "gridRadiosMale", 1), FEMALE("Female", "gridRadiosFemale", 2),
    OTHER("Other", "gridRadiosOther", 3);

    public final String sex;
    public final String id;
    private final int number;

    Genders(String sex, String id, int number) {
        this.sex = sex;
        this.id = id;
        this.number = number;
    }

    public static Genders getByNumber(int number) {
        return Optional.of(Arrays.stream(Genders.values()).findFirst().filter(x -> x.number == number)).get().orElse(OTHER);
    }
}
