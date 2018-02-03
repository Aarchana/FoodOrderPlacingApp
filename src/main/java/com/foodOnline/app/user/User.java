package com.foodOnline.app.user;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.foodOnline.app.user.foodMenu.FoodMenu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "User properties validation description")
public class User {
	@Id
	@ApiModelProperty(notes = "username is a mandatory field")
	@NotNull(message = "user name is a mandatory field")
	private String userName;
	
	@Size(min = 2, message = "Name should be atleast of 2 characters")
	@ApiModelProperty(notes = "Name should be atleast of 2 characters")
	private String name;
	
	@Pattern(regexp = "^[0-9]{10}$",  message = "Mobile number should be of 10 digits only")
	@ApiModelProperty(notes = "mobileNo should be of 10 digits")
	private String mobileNo;


	protected User(){
		
	}
	
	public User(String userName, String name, String mobileNo) {
		super();
		this.userName = userName;
		this.name = name;
		this.mobileNo = mobileNo;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public String getUserName() {
		return userName;
	}

}
