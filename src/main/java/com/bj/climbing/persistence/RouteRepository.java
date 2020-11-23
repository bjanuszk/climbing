package com.bj.climbing.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {
}
