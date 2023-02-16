package com.fds.FoodDelivery.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fds.FoodDelivery.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByEmailAndPassword(String email , String password);

}