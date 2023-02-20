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

import com.fds.FoodDelivery.model.User;
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
		return new Response<User>(101, TAG+" "+data+" Added Successful on "+date, data);
	}
	
	
	
	@DeleteMapping(path="/delete/{id}")
	public Response<User>  deleteUser(@PathVariable("id") Integer id) {
		
		User auser = userRepo.findById(id).get();
		    userRepo.deleteById(id);
			userRepo.delete(auser);
			System.out.print(auser);
			return new Response<User> (101, auser+" "+TAG+"s DELETED Successful on "+date, auser);
			}
	
	
	@GetMapping(path="/get")
	public Response<User> getUser() {
		ArrayList<User> data = new ArrayList<User>();
		userRepo.findAll().forEach((auser)->data.add(auser));
		System.out.print(data);
		return new Response<User>(101, " success ", (List<User>)  data);
		
	}

	
	
	@PostMapping(path="/login")
   public Response<User> loginUser(@RequestBody User datac) {
  // public Response<User> loginUser(@RequestParam String email, @RequestParam String password) {	
		//System.out.print(data);
		Date date = new Date();
       String email = datac.email;
       String password = datac.password;
		   System.out.print(password);
		User data = userRepo.findByEmailAndPassword(email, password).get();
		data.setEmail(email);
		data.setPassword(password);
			return new Response<User>(101, TAG+" "+data+" Logged in Successful on "+date,  data);
		
	}
	



	@PutMapping(path="/update/{id}")
	public Response<User> updateUser(@PathVariable("id") Integer id, @RequestBody User data) {
	
		User auser = userRepo.findById(id).get();
		
			System.out.print(auser); 
		
		    auser.setFirstname(data.firstname);
			auser.setLastname(data.lastname);
			auser.setEmail(data.email);
			auser.setPassword(data.password);
			auser.setAddress(data.address);
			auser.setCity(data.city);
			auser.setState(data.state);
			auser.setZip(data.zip);
			auser.setPhone(data.phone);
			userRepo.save(data);
	    	return new Response<User> (101, auser+" "+TAG+"s UPDATE Successful on "+date, data);
			
		}


}
