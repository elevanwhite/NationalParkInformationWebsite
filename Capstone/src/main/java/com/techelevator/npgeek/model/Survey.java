package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

public class Survey {
	
	@NotBlank (message="Please enter a valid email.")
	@Email(message="Invalid Email")
	private String email;
	
	@NotBlank (message="Please select a park.")
	private String favPark;
	
	@AssertTrue(message="Invalid Park Code")
	public boolean isValidPark() {
		List<String> parkCodes = new ArrayList<>();
		parkCodes.add("CVNP");
		parkCodes.add("ENP");
		parkCodes.add("GCNP");
		parkCodes.add("GNP");
		parkCodes.add("GSMNP");
		parkCodes.add("GTNP");
		parkCodes.add("MRNP");
		parkCodes.add("RMNP");
		parkCodes.add("YNP");
		parkCodes.add("YNP2");
		return parkCodes.contains(favPark);
	}
	
	@NotBlank (message="Please select your state of residence.")
	private String stateRes;
	@AssertTrue (message="Please select a valid state.")
	public boolean isValidState() {
		States[] states = States.values();
		for (States s : states) {
			if (s.toString().equals(stateRes)) {
				return true;
			}
		}
		return false;
	}
	
	@NotBlank (message="Please select an activity level.")
	private String activityLvl;
	@AssertTrue (message="Please select a valid activity level.")
	public boolean isValidActivityLevel() {
		List<String> levels = new ArrayList<>();
		levels.add("inactive");
		levels.add("sedentary");
		levels.add("active");
		levels.add("extremelyActive");
		
		return levels.contains(activityLvl);
	}
// Getters & Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavPark() {
		return favPark;
	}
	public void setFavPark(String favPark) {
		this.favPark = favPark;
	}
	public String getStateRes() {
		return stateRes;
	}
	public void setStateRes(String stateRes) {
		this.stateRes = stateRes;
	}
	public String getActivityLvl() {
		return activityLvl;
	}
	public void setActivityLvl(String activityLvl) {
		this.activityLvl = activityLvl;
	}
	
}
