package com.example.mealwheels.dao;

import com.example.mealwheels.entity.Fund;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundDao extends CrudRepository<Fund, Long> {
}
