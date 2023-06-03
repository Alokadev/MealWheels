package com.example.mealwheels.dao;

import com.example.mealwheels.entity.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao extends CrudRepository<Menu, Long> {
}
