package com.bj.climbing.web;

import com.bj.climbing.common.Route;
import com.bj.climbing.domain.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public List<Route> all() {
        return routeService.getAll();
    }

    @PostMapping("/routes")
    public Route newEmployee(@RequestBody Route route) {
        return routeService.save(route);
    }
}
