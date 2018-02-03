package com.foodOnline.app.user.foodMenu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodMenuController {
	
	@Autowired
	private FoodMenuService menuService;
	
	@GetMapping(path = "/food-menu")
	public List<FoodMenu> getMenu() {
		return menuService.getFoodMenu();
	}
	
	@PostMapping(path = "/food-menu")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@Valid @RequestBody FoodMenu FoodMenu){
		menuService.save(FoodMenu);
	}
	
}

