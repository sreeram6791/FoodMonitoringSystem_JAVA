/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Food;

import java.util.ArrayList;

/**
 *
 * @author rama
 */
public class FoodDirectory {
    
    private ArrayList<Food> foodDirectory;
    
    public FoodDirectory(){
        foodDirectory = new ArrayList<>();
    }

    public ArrayList<Food> getFoodDirectory() {
        return foodDirectory;
    }

    public void setFoodDirectory(Food food) {
        this.foodDirectory.add(food);
    }

    
    
    
    
}
