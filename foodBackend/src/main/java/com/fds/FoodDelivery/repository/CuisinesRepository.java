package com.fds.FoodDelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fds.FoodDelivery.model.Cuisines;

@Repository
public interface CuisinesRepository extends CrudRepository<Cuisines, Integer> {

}
