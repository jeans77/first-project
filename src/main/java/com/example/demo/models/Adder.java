package com.example.demo.models;

public class Adder {
	
	//instance variables
	int secret1;
	double secret2;
	
	//constructor
	public Adder(int first, double second) {
		secret1 = first;
		secret2 = second;	
	}
	
	public double calculate() {
		return secret1 + secret2;
	}

}
