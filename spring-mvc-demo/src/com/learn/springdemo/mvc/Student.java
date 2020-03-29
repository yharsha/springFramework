package com.learn.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.learn.springdemo.validation.CourseCode;
import com.sun.xml.internal.ws.assembler.jaxws.MustUnderstandTubeFactory;

import jdk.nashorn.internal.ir.WithNode;



public class Student {
	
	private String firstName;

	@NotNull(message="Cannot be Empty")
	@Size(min=1,message="Enter minimum 1 character")
	private String lastName;
	
	private String country;

	private String favouriteLanguage;
	
	private String [] os;
	
	@Min(value=0,message="min value is 0")
	@Max(value=10,message="max value is 10")
	@NotNull(message="Mandatory field")
	private Integer passes;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="enter only 5 char/digits")
	private String postalCode;
	
	@CourseCode(value="Tops",message="Must start WithNode Tops")
	private String courseCode;

	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		//populate country: use ISO country code
		
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("IN", "INDIA");
		countryOptions.put("FR", "FRANCE");
		countryOptions.put("GE", "GERMANY");
		countryOptions.put("UA", "UAE");
		
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String[] getOs() {
		return os;
	}

	public void setOs(String[] os) {
		this.os = os;
	}

	public Integer getPasses() {
		return passes;
	}

	public void setPasses(Integer passes) {
		this.passes = passes;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
}
