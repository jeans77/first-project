package com.example.demo.models;

public class Yeller {

	//instance variables
	String received;
	
	//constructor
	public Yeller (String message) {
		received = message;
	}

	public  String capitalize () {
		return received.toUpperCase();
			}
	

}
