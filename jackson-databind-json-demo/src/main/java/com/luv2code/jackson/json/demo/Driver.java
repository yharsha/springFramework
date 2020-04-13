package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String [] args) {
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file & convet to POJO
			Student student =
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			//print attributes
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			System.out.println(student.getId());
			
			Address address=student.getAddress();
			System.out.println("");
			System.out.println(address.getCountry());
			System.out.println(address.getState());
			
			for (String temp: student.getLanguages())
			{
				System.out.println(temp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
