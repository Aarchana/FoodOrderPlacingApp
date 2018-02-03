package com.foodOnline.app.user.foodMenu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodMenuService {
	public List<FoodMenu> menuArrayList = new ArrayList<>();
	@Autowired
	private FoodMenuRepository foodMenuRepository;
	
	public List<FoodMenu> getFoodMenu() {
		return foodMenuRepository.findAll();
	}
	
	public void save(FoodMenu menu){
		menuArrayList.add(menu);
		foodMenuRepository.save(menuArrayList);
	}
	
//	public Resource<FoodMenu> getByUserName(String userName) {
//		User user = FoodMenuRepository.findByUserName(userName);
//		if(user == null) {
//			throw new UserNotFoundException("userName " + userName + " not found");
//		}
//		Resource<User> resource = new Resource<User>(user);
//		ControllerLinkBuilder linkToAllUsers = linkTo(methodOn(UserController.class).getUsers());
//		resource.add(linkToAllUsers.withRel("available-users"));
//		return resource;
//	}
//	
//	public void deleteByUserName(String userName) {
//		User user = userRepository.findByUserName(userName);
//		if(user == null) {
//			throw new UserNotFoundException("userName " + userName + " not found");
//		}
//		userRepository.delete(userName);
//	}

}
