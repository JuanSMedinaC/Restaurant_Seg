package model;

import exception.NegativeNumberException;

public class Ingredient {
	private String name;
	private double weight;
	
	public Ingredient(String n, double w) throws NegativeNumberException {
		name = n;
		if(w<0) {
			throw new NegativeNumberException(w);
		}	
		weight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException {	
		if(additionalW<0) {
			throw new NegativeNumberException(additionalW);
		}	
		else {
			weight= weight+additionalW;
		}
	}	
	
	public void removeWeight(double inputWeight) throws NegativeNumberException {
		if(inputWeight<0) {
			throw new NegativeNumberException(inputWeight);
		}	
		else {
			weight= weight- inputWeight;	
		}
		
	}
}