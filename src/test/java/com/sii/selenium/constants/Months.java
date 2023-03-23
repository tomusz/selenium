package com.sii.selenium.constants;

public enum Months {

    JANUARY("01", "January"), FEBRUARY("02", "February"), MARCH("03", "March"), APRIL("04", "April"), MAY("05", "May"),
    JUNE("06", "June"), JULY("07","July"), AUGUST("08","August"), September("09","September"), OCTOBER("10","October"),
    NOVEMBER("11","November"), DECEMBER("12", "December");

    private final String number;
    private final String name;

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    Months(String number, String name) {
        this.number = number;
        this.name = name;
    }
}
