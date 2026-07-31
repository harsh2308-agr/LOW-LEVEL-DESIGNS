package PracticeQuestions.MACD.Meals;

import PracticeQuestions.MACD.ENUMS.MealType;
import PracticeQuestions.MACD.Items.MenuItem;

public class Meal {
//    Burger burgers[];
//    Fries fries;
//    ColdDrink coldDrinks[];
//    int price;
    MenuItem items[];
    int price;
    int key;
    MealType type;

    public Meal(MenuItem items[], int price, int key, MealType type){
        this.items = items;
        this.price = price;
        this.key = key;
        this.type = type;
    }
    public Meal(){
    }

    public int getPrice(){
        return this.price;
    }

    public MenuItem[] getItems(){
        return this.items;
    }

    public int getKey(){
        return this.key;
    }

    public void displayMeal() {
       switch(this.type){
           case CHICKEN:
               System.out.println("Name:- CHICKEN MEAL Price:- "+this.getPrice());
               break;
           case DELUX:
               System.out.println("Name:- DELUX MEAL Price:- "+this.getPrice());
               break;
           case SUNDAY:
               System.out.println("Name:- SUNDAY MEAL Price:- "+this.getPrice());
               break;
           default:
               System.out.println("No meals");
               break;
       }
    }
}
