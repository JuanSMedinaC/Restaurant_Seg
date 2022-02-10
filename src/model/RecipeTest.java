package model;

import java.util.ArrayList; 
import java.util.List;

import static org.junit.Assert.*;


import org.junit.Test;

public class RecipeTest {
	
	private Recipe recipe;
	private List<Ingredient> ingredients;
	public void setupStage1() {
		recipe=new Recipe();
	}
	
	public void setupStage2() {
		recipe = new Recipe();
		recipe.addIngredient("Cebolla", 315);
		recipe.addIngredient("Ajo", 58);
		recipe.addIngredient("Arroz", 520);
	}
	@Test
	public void addIngredientTest1() {
		setupStage1();
		recipe.addIngredient("Sal",12);
		boolean weightProve=false;
		ingredients = new ArrayList<Ingredient>();
		ingredients = recipe.getIngredients();
		
		Ingredient ingredient;
		ingredient=ingredients.get(0);
		
		assertEquals(1, ingredients.size());
		assertEquals("Sal", ingredient.getName());
		if (ingredient.getWeight()==12) {
			weightProve=true;
		}
		assertTrue(weightProve);
	}
	
	@Test
	public void addIngredientTest2() {
		setupStage2();
		recipe.addIngredient("Pimienta", 6);
		boolean weightProve=false;
		ingredients = new ArrayList<Ingredient>();
		ingredients = recipe.getIngredients();
		Ingredient ingredient;
		ingredient=ingredients.get(ingredients.size()-1);
		
		assertEquals(4, ingredients.size());
		assertEquals("Pimienta", ingredient.getName());
		if (ingredient.getWeight()==6) {
			weightProve=true;
		}
		assertTrue(weightProve);
	}
	
	@Test
	public void addIngredientTest3() {
		setupStage2();
		recipe.addIngredient("Ajo",21);
		boolean weightProve=false;
		boolean stop=false;
		ingredients = new ArrayList<Ingredient>();
		ingredients = recipe.getIngredients();
		Ingredient ingredient;
		ingredient=ingredients.get(0);
		for( int i =0; i<ingredients.size()&&stop==false;i++) {
			if (ingredients.get(i).getName().equals("Ajo")) {
				stop=true;
				ingredient=ingredients.get(i);
			}
		}
		
		assertEquals(3, ingredients.size());
		assertEquals("Ajo", ingredient.getName());
		if (ingredient.getWeight()==79) {
			weightProve=true;
		}
		assertTrue(weightProve);
	}
	
	@Test
	public void removeIngredientTest1() {
		setupStage2();
		ingredients = new ArrayList<Ingredient>();
		ingredients = recipe.getIngredients();
		recipe.removeIngredient("Ajo");
		
		assertEquals(2, ingredients.size());
		assertEquals("Cebolla", ingredients.get(0).getName());
		assertEquals("Arroz", ingredients.get(1).getName());
	}
	
}
