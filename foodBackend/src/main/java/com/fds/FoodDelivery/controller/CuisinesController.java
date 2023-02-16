package com.fds.FoodDelivery.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fds.FoodDelivery.model.Cuisines;
import com.fds.FoodDelivery.model.Response;
import com.fds.FoodDelivery.repository.CuisinesRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cuisines")
public class CuisinesController {
	
	
	
public static String TAG = "[Cuisines]";
	
	@Autowired
	CuisinesRepository cuisineRepo;
	
	Date date = new Date();
	

	@PostMapping(path="/add")
	public Response<Cuisines> addCuisines(@RequestBody Cuisines data) {
		cuisineRepo.save(data);
		return new Response<Cuisines>(101, TAG+" "+data+" Added Successful on "+date);
	}
	
	
	
	
	
	@GetMapping(path="/get")
	public Response<Cuisines>  getCuisines() {
		ArrayList<Cuisines> data = new ArrayList<Cuisines>();
		cuisineRepo.findAll().forEach((cuise)->data.add(cuise));
		return new Response<Cuisines>(101, " success ", data);
		
	}
	

}
