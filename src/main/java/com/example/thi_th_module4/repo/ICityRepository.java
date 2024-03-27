package com.example.thi_th_module4.repo;

import com.example.thi_th_module4.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.LongBinaryOperator;

public interface ICityRepository extends JpaRepository<City, Long> {
}
