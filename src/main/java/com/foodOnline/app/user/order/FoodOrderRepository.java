package com.foodOnline.app.user.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOnline.app.user.User;


@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {
	FoodOrder findByUser(User user);

}
