package com.foodOnline.app.user.order;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.foodOnline.app.user.User;
import com.foodOnline.app.user.foodMenu.FoodMenu;


@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private User user;
	
	public FoodOrder() {
		super();
	}

	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<FoodMenu> foodItems;
	
	public Set<FoodMenu> getFoodItems() {
		return foodItems;
	}

	public FoodOrder(User user, Set<FoodMenu> foodItems) {
		super();
		this.user = user;
		this.foodItems = foodItems;
	}
	
	public int getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
}
