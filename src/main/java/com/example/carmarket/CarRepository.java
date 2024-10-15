package com.example.carmarket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarBrand, Long> {
}

