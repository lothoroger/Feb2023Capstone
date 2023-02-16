package com.fds.FoodDelivery.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fds.FoodDelivery.model.Response;
import com.fds.FoodDelivery.model.User;
import com.fds.FoodDelivery.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	public static String TAG = "[User]";
	
	@Autowired
	UserRepository userRepo;
	
	Date date = new Date();
	

	@PostMapping(path="/add")
	//public Response addUser( @RequestParam String email, @RequestParam String password, @RequestParam(required=false) String firstName ,  @RequestParam(required=false) String lastName , @RequestParam(required=false) String phone,  @RequestParam(required=false) String address, @RequestParam(required=false) String city,@RequestParam(required=false) String state,@RequestParam(required=false) String zip,@RequestParam(required=false) String role ) {
	public Response<User> addUser(@RequestBody User data) {
	//User  data = new User(null,email, password, firstName, lastName, phone, address, city,state, zip, role);
		userRepo.save(data);
		return new Response<User>(101, TAG+" "+data+" Added Successful on "+date);
	}
	
	
	
	
	
	@GetMapping(path="/get")
	public Response<User> getUser() {
		ArrayList<User> data = new ArrayList<User>();
		userRepo.findAll().forEach((cust)->data.add(cust));
		return new Response<User>(101, " success ", data);
		
	}
	
	
	@PostMapping(path="/login")
	//public Response loginUser(@RequestBody User formData) {
   public Response<User> loginUser(@RequestParam String email, @RequestParam String password) {	
	
		Date date = new Date();
	//	String email = formData.email;
	//	String password = formData.password;
			
		User auser = userRepo.findByEmailAndPassword(email, password).get();
		System.out.print(auser);
		if ( auser.getEmail() != null) {
			
			return new Response<User>(101, TAG+" "+auser+" Logged in Successful on "+date );
		} else {
			
			return new Response<User>(201, TAG+" "+auser+"  Authentication Failed on "+date);
		}
		
	}
	
	


	

}
