package com.fds.FoodDelivery.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return new Response<Cuisines>(101, TAG+" "+data+" Added Successful on "+date, data);
	}
	
	
	
	
	
	@GetMapping(path="/get")
	public Response<Cuisines>  getCuisines() {
		ArrayList<Cuisines> data = new ArrayList<Cuisines>();
		cuisineRepo.findAll().forEach((cuise)->data.add(cuise));
		return new Response<Cuisines>(101, " success ", (List<Cuisines>) data);
		}
	
	
	@DeleteMapping(path="/delete/{id}")
	public Response<Cuisines>  deleteCuisine(@PathVariable("id") Integer id) {
		
		Cuisines cuisined = cuisineRepo.findById(id).get();
		
		    cuisineRepo.deleteById(id);
			cuisineRepo.delete(cuisined);
			System.out.print(cuisined);
			return new Response<Cuisines> (101, cuisined+" "+TAG+"s DELETED Successful on "+date, cuisined);
			}
	

	@GetMapping(path="/get/{id}")
	public Response<Cuisines> getCuisineById(@PathVariable("id") Integer id) {
		
		Cuisines cuisined = cuisineRepo.findById(id).get();
		if (cuisined.getId() == id) {
			return new Response<Cuisines> (101, cuisined+" "+TAG+"s Fetched Successful on "+date,(List<Cuisines>) cuisined);
		} else {
			return new Response<Cuisines> (101, cuisined+" "+TAG+"s Fetched not Found  on "+date,(List<Cuisines>) cuisined);
		}
	}
	
		@PutMapping(path="/update/{id}")
		public Response<Cuisines> saveCuisine(@PathVariable("id") Integer id, @RequestBody Cuisines data) {
			
			Cuisines cuisined = cuisineRepo.findById(id).get();
			
				System.out.print(cuisined); 
			
			
				cuisined.setName(data.name);
				cuisined.setOrigin(data.origin);
				cuisined.setAvailable(data.available);
				cuisined.setImage(data.image);
				cuisined.setPrice(data.price);				
				cuisineRepo.save(data);
		    	return new Response<Cuisines> (101, cuisined+" "+TAG+"s UPDATE Successful on "+date, data);
				
			}
}
	

