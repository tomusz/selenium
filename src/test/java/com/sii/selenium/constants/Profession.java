package com.sii.selenium.constants;

import java.util.Arrays;
import java.util.Optional;

public enum Profession {
    MANUAL_TESTER("gridCheckManulTester","Manual tester",1),
    AUTOMATION_TESTER("gridCheckAutomationTester","Automation Tester",2),
    OTHER("gridCheckOther","Other",3);

    public final String id;
    public final String label;
    private final int number;

    Profession(String id, String label, int number) {
        this.id = id;
        this.label = label;
        this.number = number;
    }

    public static Profession getByNumber(int number) {
        return Optional.of(Arrays.stream(Profession.values()).findFirst().filter(x -> x.number == number)).get().orElse(OTHER);
    }
}
