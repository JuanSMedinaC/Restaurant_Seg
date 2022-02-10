package model;

import java.util.ArrayList; 
import java.util.List;

import exception.*;

public class Recipe {
	private List<Ingredient> ingredients;
	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
	}
	
	public String addIngredient(String n, double w) {
		String message="";
		
		Ingredient searched = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(n)) {
				searched = current;
			}
		}
		
			if(searched!=null) {
				try {
					searched.addWeight(w);
					message="Weight added";
				} catch (NegativeNumberException e) {
					message="Weight couldn't be added";
					e.printStackTrace();
				}
			
			}else {
				Ingredient newIngredient;
				try {
					newIngredient = new Ingredient(n, w);
					ingredients.add(newIngredient);
					message="Ingredient added correctly";
				} catch (NegativeNumberException e) {
					message="New ingredient couldn't be added";
					e.printStackTrace();
				}
				
				
			}		
		
		return message;
	}
	
	public String removeIngredient(String name) {
		String message="";
		
		boolean stop=false;
		
		for (int i=0; i<ingredients.size() && stop==false; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(name)) {
					ingredients.remove(i);
					stop=true;
					message="Ingredient removed succesfully";
				}
			}
		if(stop==false) {
			message="Couldn't find that ingredient";
		}
		return message;
	}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
	
}