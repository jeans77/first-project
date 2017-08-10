package com.example.demo.models;

public class Whisper {

	//instance variables
	String received;
	
	//constructor
	public Whisper (String message) {
		received = message;
	}

	public  String decapitalize () {
		return received.toLowerCase();
			}

}
