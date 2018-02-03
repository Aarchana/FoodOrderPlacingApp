package com.foodOnline.app.user.foodMenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, String> {

}
