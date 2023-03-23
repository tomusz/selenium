package com.sii.selenium.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private Calendar calendar;

    public DateUtils(Date date) {
        this.calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    public DateUtils addYear(int years) {
        this.calendar.add(Calendar.YEAR, years);
        return this;
    }

    public DateUtils addMonth(int months) {
        this.calendar.add(Calendar.MONTH, months);
        return this;
    }

    public DateUtils addDay(int days) {
        this.calendar.add(Calendar.DAY_OF_YEAR, days);
        return this;
    }

    public DateUtils setDate(int year, int month, int day) {
        this.calendar.set(year, month, day);
        return this;
    }

    public DateUtils setDay(int dayNumber) {
        this.calendar.set(Calendar.DAY_OF_MONTH, dayNumber);
        return this;
    }

    public DateUtils setMonth(int monthNumber) {
        this.calendar.set(Calendar.MONTH, monthNumber);
        return this;
    }

    public DateUtils setYear(int yearNumber) {
        this.calendar.set(Calendar.YEAR, yearNumber);
        return this;
    }

    public DateUtils setFirstOfDayMonth() {
        this.calendar.set(Calendar.DAY_OF_MONTH, this.calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return this;
    }

    public DateUtils setLastDayOfMonth() {
        this.calendar.set(Calendar.DAY_OF_MONTH, getLastDayOfMonth());
        return this;
    }

    public int getLastDayOfMonth() {
        return this.calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public Date getDate() {
        return calendar.getTime();
    }
}