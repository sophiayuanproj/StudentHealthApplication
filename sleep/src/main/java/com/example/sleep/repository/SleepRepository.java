package com.example.sleep.repository;

import com.example.sleep.model.SleepModel;
import org.springframework.data.repository.CrudRepository;

public interface SleepRepository extends CrudRepository<SleepModel, Integer> {
}
