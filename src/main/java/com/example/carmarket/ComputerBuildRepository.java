package com.example.carmarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerBuildRepository extends JpaRepository<CompSbor, Long> {
}

