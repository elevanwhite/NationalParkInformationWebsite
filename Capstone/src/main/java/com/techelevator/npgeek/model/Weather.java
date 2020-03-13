package com.techelevator.npgeek.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

//private String parkCode; NO LONGER USER, DUE TO API
private int fiveDayForecastValue;
private double lowTemp;
private double highTemp;
private String icon;
//private String forecast; NO LONGER USER, DUE TO API
private String imageName;
private boolean isCelsius = false;
private String month = LocalDate.now().getMonth().toString();
private int day;

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

// NO LONGER USER, DUE TO API
//public String getParkCode() {
//	return parkCode;
//}
//public void setParkCode(String parkCode) {
//	this.parkCode = parkCode;
//}
public int getFiveDayForecastValue() {
	return fiveDayForecastValue;
}
public void setFiveDayForecastValue(int fiveDayForecastValue) {
	this.fiveDayForecastValue = fiveDayForecastValue;
	this.day = LocalDate.now().plusDays(fiveDayForecastValue - 1).getDayOfMonth();
}
public double getLowTemp() {
	return lowTemp;
}
public void setLowTemp(double lowTemp) {
	this.lowTemp = lowTemp;
}
public double getHighTemp() {
	return highTemp;
}
public void setHighTemp(double highTemp) {
	this.highTemp = highTemp;
}
// NO LONGER USER, DUE TO API
//public String getForecast() {
//	return forecast;
//}
//public void setForecast(String forecast) {
//	this.forecast = forecast;
//	
//	//dealing with camel cased image file
//	String[] imageName = forecast.split(" ");
//	for (int i=1; i<imageName.length; i++) {
//		char firstChar= Character.toUpperCase(imageName[i].charAt(0));
//		imageName[i]= firstChar + imageName[i].substring(1);
//	} 
//	String result = "";
//	for (String s: imageName) {
//		result +=s;
//	}
//	this.imageName= result + ".png";
//	
//}
public String getImageName() {
	return imageName;
}

public String getIcon() {
	return icon;
}
// Icon data point >>> existing weather image names
public void setIcon(String icon) {
	this.icon = icon;
	switch(icon) {
		case "clear-day":
			icon = "sunny";
			break;
		case "clear-night":
			icon = "sunny";
			break;
		case "sleet":
			icon = "snow";
			break;
		case "wind":
			icon = "partlyCloudy";
			break;
		case "fog":
			icon = "cloudy";
			break;
		case "partly-cloudy-day":
			icon = "partlyCloudy";
			break;
		case "partly-cloudy-night":
			icon = "partlyCloudy";
			break;
	}
	this.imageName = icon + ".png";
}

public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
//class methods
public String getRecommendation() {
	String result="";
	if(imageName.equals("snow.png")) {
		result += RECOMMENDATIONS.get("snow");
	} else 	if(imageName.equals("rain.png")) {
		result += RECOMMENDATIONS.get("rain");
	} else 	if(imageName.equals("sunny.png")) {
		result += RECOMMENDATIONS.get("sunny");
	} else 	if(imageName.equals("thunderstorms.png")) {
		result += RECOMMENDATIONS.get("thunderstorms");
	}
	if (isCelsius == false) {
// README specified breakpoint for HOT = 75 F
		if (highTemp > 75) {
			result += RECOMMENDATIONS.get("hot");
// README specified breakpoint for COLD = 20 F
		} else if (lowTemp < 20){
			result += RECOMMENDATIONS.get("cold");
		}
// README specified breakpoint for TempDiff = 20 F
		if (highTemp - lowTemp > 20) {
			result += RECOMMENDATIONS.get("tempChange");
		}
	} else {
		double multiplier = .55;
// C conversion HOT
		if (highTemp > 23.889) {
			result += RECOMMENDATIONS.get("hot");
// C conversion Cold
		} else if (lowTemp < -6.667){
			result += RECOMMENDATIONS.get("cold");
		}
// C Conversion TempDiff
		if (highTemp - lowTemp > 11.11) {
			result += RECOMMENDATIONS.get("tempChange");
		}
	}
	return result;	
}
public void convertToCelsius() {
	double multiplier = .55;
	double convertedTemp = (lowTemp -32) * multiplier;
	lowTemp = convertedTemp;
	convertedTemp = (highTemp -32) *multiplier;
	highTemp = convertedTemp;
	isCelsius = true;
}




}
