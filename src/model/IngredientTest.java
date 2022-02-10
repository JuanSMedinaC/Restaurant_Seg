package model;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.NegativeNumberException;

public class IngredientTest {
	
	private Ingredient ingredient;
	
	public void setupStage1(){
		try {
			ingredient=new Ingredient("Tomate", 245);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addWeightTest1() {
		setupStage1();
		boolean weightProve=false;
		try {
			ingredient.addWeight(54);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
		if (ingredient.getWeight()==299) {
			weightProve=true;
		}
		assertTrue(weightProve);
		
	}
	
	@Test
	public void addWeightTest2() {
		setupStage1();
		boolean exceptionProve=false;
		boolean weightProve=false;
		try {
			ingredient.addWeight(-100);
		} catch (NegativeNumberException e) {
			exceptionProve=true;
			e.printStackTrace();
		}
		if (ingredient.getWeight()==245) {
			weightProve=true;
		}
		assertTrue(weightProve);
		assertTrue(exceptionProve);
	}
	
	@Test
	public void removeWeightTest1(){
		setupStage1();
		boolean weightProve=false;
		try {
			ingredient.removeWeight(45);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
		if (ingredient.getWeight()==200) {
			weightProve=true;
		}
		assertTrue(weightProve);
	}
	
	@Test
	public void removeWeightTest2() {
		setupStage1();
		boolean exceptionProve=false;
		boolean weightProve=false;
		try {
			ingredient.removeWeight(-100);
		} catch (NegativeNumberException e) {
			exceptionProve=true;
			e.printStackTrace();
		}
		if (ingredient.getWeight()==245) {
			weightProve=true;
		}
		assertTrue(weightProve);
		assertTrue(exceptionProve);
	}

	
}
