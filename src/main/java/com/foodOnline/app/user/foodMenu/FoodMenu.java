package com.foodOnline.app.user.foodMenu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodMenu {
	protected FoodMenu() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodItemId;
	private String name;
	private double cost;
	public FoodMenu(String name, double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	public double getCost() {
		return cost;
	}
	
}
