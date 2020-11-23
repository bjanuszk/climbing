package com.bj.climbing.persistence;

import com.bj.climbing.common.Route;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@Entity(name = "route")
public class RouteEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "route_id_seq"
    )
    @SequenceGenerator(
            name = "route_id_seq",
            allocationSize = 1
    )
    private Integer id;
    private String name;
    @Column(name = "created")
    private LocalDate date;

    public RouteEntity() {
    }

    public RouteEntity(Integer id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static RouteEntity from(Route route) {
        return new RouteEntity(null, route.getName(), route.getDate());
    }
}
