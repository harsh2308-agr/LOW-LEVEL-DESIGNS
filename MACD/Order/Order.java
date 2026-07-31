package PracticeQuestions.MACD.Order;

import PracticeQuestions.MACD.Meals.Meal;
import PracticeQuestions.MACD.Items.MenuItem;

public class Order {
    MenuItem[] items;
    Meal[] meals;
    int price;
    public Order(){

    }

    public Meal[] getMeals(){
        return this.meals;
    }

    public MenuItem[] getItems() {
        return this.items;
    }


    public int getPrice(){
        this.price = this.calculatePrice();
        return this.price;
    }

    public void displayOrder() {
        System.out.println("You have the following items-->");
        for(int i=0;i<items.length;i++){
            System.out.println("Name:- " + items[i].getName()+" Price:- "+items[i].getPrice());
        }
        if(items.length==0)
            System.out.println("No items");
        System.out.println();
        System.out.println("You have the following meals");
        for(int i=0;i< meals.length;i++) {
            Meal meal = meals[i];
            meal.displayMeal();
        }
        if(meals.length==0)
            System.out.println("No meals");
    }
    private int calculatePrice(){
        int price = 0;
        for(int i=0;i<this.meals.length;i++){
            price = price + this.meals[i].getPrice();
        }

        for(int i=0;i<this.items.length;i++){
            price = price + this.items[i].getPrice();
        }
        return price;
    }

}
