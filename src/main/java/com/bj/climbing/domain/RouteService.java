package com.bj.climbing.domain;

import com.bj.climbing.common.Route;
import com.bj.climbing.persistence.RouteEntity;
import com.bj.climbing.persistence.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route save(Route route) {
        RouteEntity routeEntity = RouteEntity.from(route);
        return Route.from(routeRepository.save(routeEntity));
    }

    public List<Route> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(Route::from)
                .collect(toList());
    }
}
