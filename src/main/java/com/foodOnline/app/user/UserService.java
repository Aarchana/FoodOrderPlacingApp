package com.foodOnline.app.user;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import  static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.stereotype.Component;

import com.foodOnline.app.user.foodMenu.FoodMenu;
import com.foodOnline.app.user.order.FoodOrder;
import com.foodOnline.app.user.order.FoodOrderRepository;

@Component
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private FoodOrderRepository foodOrderRepository;
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public Resource<User> getByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		if(user == null) {
			throw new UserNotFoundException("userName " + userName + " not found");
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkToAllUsers = linkTo(methodOn(UserController.class).getUsers());
		resource.add(linkToAllUsers.withRel("available-users"));
		return resource;
	}
	
	public void deleteByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		if(user == null) {
			throw new UserNotFoundException("userName " + userName + " not found");
		}
		userRepository.delete(userName);
	}

	public void createOrder(String userName, Set<FoodMenu> orders) {
		User user = userRepository.findByUserName(userName);
		FoodOrder order = new FoodOrder(user, orders);
		System.out.println("order " + order.getUser() + order.getFoodItems());
		foodOrderRepository.save(order);
	}

	public Set<FoodMenu> getUserOrders(String userName) {
		User user = userRepository.findByUserName(userName);
		FoodOrder order = foodOrderRepository.findByUser(user);
		return order.getFoodItems();
	}

}
