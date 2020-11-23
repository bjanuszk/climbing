package com.bj.climbing.common;

import com.bj.climbing.persistence.RouteEntity;

import java.time.LocalDate;

public class Route {
    private String name;
    private LocalDate date;

    public Route() {
    }

    public Route(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static Route from(RouteEntity route) {
        return new Route(route.getName(), route.getDate());
    }
}
