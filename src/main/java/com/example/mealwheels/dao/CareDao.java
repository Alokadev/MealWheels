package com.example.mealwheels.dao;

import com.example.mealwheels.entity.CareRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareDao extends CrudRepository<CareRequest, Long> {
}
