package com.foodOnline.app.user;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.foodOnline.app.user.foodMenu.FoodMenu;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping(path = "/users")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@Valid @RequestBody User user){
		userService.save(user);
	}
	
	@GetMapping(path = "/users/{userName}")
	public Resource<User> getByUserName(@PathVariable String userName) {
		
		return userService.getByUserName(userName);
	}
	
	@DeleteMapping(path = "/users/{userName}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteByUserName(@PathVariable String userName) {
		userService.deleteByUserName(userName);
	}
	
	@PostMapping(path = "/users/{userName}/orders")
	public void createUserOrder(@PathVariable String userName, @RequestBody  Set<FoodMenu> userOrder) {
		userService.createOrder(userName, userOrder);
	}

	@GetMapping(path = "/users/{userName}/orders")
	public Set<FoodMenu> getUserOrder(@PathVariable String userName) {
		return userService.getUserOrders(userName);
	}
}

