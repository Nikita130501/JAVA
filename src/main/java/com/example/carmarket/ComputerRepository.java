package com.example.carmarket;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
    // Дополнительные методы, если нужно
}

