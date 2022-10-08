package com.example.demo.enums;


public enum RussianMonth {
    MONTH_JANUARY("Января"),
    MONTH_FEBRUARY("Февраля"),
    MONTH_MARCH("Марта"),
    MONTH_APRIL("Апреля"),
    MONTH_MAY("Мая"),
    MONTH_JUNE("Июня"),
    MONTH_JULY("Июля"),
    MONTH_AUGUST("Августа"),
    MONTH_SEPTEMBER("Сентября"),
    MONTH_OCTOBER("Октября"),
    MONTH_NOVEMBER("Ноября"),
    MONTH_DECEMBER("Декабря");

    private String title;
    RussianMonth(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
