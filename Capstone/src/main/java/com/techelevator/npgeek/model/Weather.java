package com.techelevator.npgeek.model;

import java.util.HashMap;
import java.util.Map;

public class Weather {

private String parkCode;
private int fiveDayForecastValue;
private int lowTemp;
private int highTemp;
private String forecast;
private String imageName;


@SuppressWarnings("serial")
public static final Map<String,String> RECOMMENDATIONS = new HashMap<String,String>(){{
	put("snow", "Bring snow shoes! ");
	put("rain", "Bring rain gear and wear waterproof shoes! ");
	put("thunderstorms", "Seek shelter and avoid hiking on exposed ridges! ");
	put("sunny", "Bring sunscreen! ");
	put("hot", "Bring an extra gallon of water! ");
	put("tempChange", "Wear breatheable layers! ");
	put("cold", "FROSTBITE WARNING: Beware of exposure to frigid temperatures! ");
}};


public String getParkCode() {
	return parkCode;
}
public void setParkCode(String parkCode) {
	this.parkCode = parkCode;
}
public int getFiveDayForecastValue() {
	return fiveDayForecastValue;
}
public void setFiveDayForecastValue(int fiveDayForecastValue) {
	this.fiveDayForecastValue = fiveDayForecastValue;
}
public int getLowTemp() {
	return lowTemp;
}
public void setLowTemp(int lowTemp) {
	this.lowTemp = lowTemp;
}
public int getHighTemp() {
	return highTemp;
}
public void setHighTemp(int highTemp) {
	this.highTemp = highTemp;
}
public String getForecast() {
	return forecast;
}
public void setForecast(String forecast) {
	this.forecast = forecast;
	
	//dealing with camel cased image file
	String[] imageName = forecast.split(" ");
	for (int i=1; i<imageName.length; i++) {
		char firstChar= Character.toUpperCase(imageName[i].charAt(0));
		imageName[i]= firstChar + imageName[i].substring(1);
	} 
	String result = "";
	for (String s: imageName) {
		result +=s;
	}
	this.imageName= result + ".png";
	
}
public String getImageName() {
	return imageName;
}

//class methods
public String getRecommendation() {
	String result="";
	if(forecast.equals("snow")) {
		result += RECOMMENDATIONS.get("snow");
	} else 	if(forecast.equals("rain")) {
		result += RECOMMENDATIONS.get("rain");
	} else 	if(forecast.equals("sunny")) {
		result += RECOMMENDATIONS.get("sunny");
	} else 	if(forecast.equals("thunderstorms")) {
		result += RECOMMENDATIONS.get("thunderstorms");
	}
	
	if (highTemp >75) {
		result += RECOMMENDATIONS.get("hot");
	} else if (lowTemp <20){
		result += RECOMMENDATIONS.get("low");
	}
	
	if (highTemp - lowTemp > 20) {
		result += RECOMMENDATIONS.get("tempChange");
	}
	return result;	
}
public void convertToCelsius() {
	double multiplier = .55;
	double convertedTemp = (lowTemp -32) * multiplier;
	lowTemp = (int)convertedTemp;
	convertedTemp = (highTemp -32) *multiplier;
	highTemp =(int)convertedTemp;
}




}
