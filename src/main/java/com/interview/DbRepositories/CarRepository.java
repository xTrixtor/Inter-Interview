package com.interview.DbRepositories;

import com.interview.Models.Db.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
