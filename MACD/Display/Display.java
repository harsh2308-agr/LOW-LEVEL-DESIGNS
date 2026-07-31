package PracticeQuestions.MACD.Display;

import PracticeQuestions.MACD.ENUMS.MealType;
import PracticeQuestions.MACD.Items.MenuItem;
import PracticeQuestions.MACD.Meals.Meal;
import PracticeQuestions.MACD.Meals.Mealfactory;

public class Display {
    MenuItem[] items = new MenuItem[6];
    Meal[] meals = new Meal[3];
    public Display(){
        createDisplay();
        displayItems();
        System.out.println("---------------------------------------------------------");
        displayMeals();
    }

    private void createDisplay(){
        items[0] = new MenuItem("VegBurger", 250, 1);
        items[1] = new MenuItem("Whooper", 350, 2);
        items[2] = new MenuItem("Chicken", 350, 3);
        items[3] = new MenuItem("Maharaja", 400, 4);
        items[4] = new MenuItem("Fries", 200, 5);
        items[5] = new MenuItem("ColdDrink", 400, 6);

        Mealfactory mealFactory = new Mealfactory();
        Meal deluxMeal = mealFactory.getMeal(MealType.DELUX);
        meals[0] = new Meal(deluxMeal.getItems(), deluxMeal.getPrice(), deluxMeal.getKey(), MealType.DELUX);

        Meal chickenMeal = mealFactory.getMeal(MealType.CHICKEN);
        meals[1] = new Meal(chickenMeal.getItems(), chickenMeal.getPrice(), chickenMeal.getKey(), MealType.CHICKEN);

        Meal sundayMeal = mealFactory.getMeal(MealType.SUNDAY);
        meals[2] = new Meal(sundayMeal.getItems(), sundayMeal.getPrice(), sundayMeal.getKey(), MealType.SUNDAY);

    }

    private void displayMeals(){
        System.out.println("We have the following meals:- ");
        for(int i=0;i<meals.length;i++){
            switch(meals[i].getKey()){
                case 7:
                    System.out.println("Name:- Delux Meal"+" Price:- "+meals[i].getPrice()+" KEY:- "+meals[i].getKey());
                    break;
                case 8:
                    System.out.println("Name:- Chicken Meal"+" Price:- "+meals[i].getPrice()+" KEY:- "+meals[i].getKey());
                    break;
                case 9:
                    System.out.println("Name:- Sunday Meal"+" Price:- "+meals[i].getPrice()+" KEY:- "+meals[i].getKey());
                    break;
                default:
                    System.out.println("No meals to display");
                    break;
            }
        }
        if(meals.length==0)
            System.out.println("No meals to display");
    }


    private void displayItems(){
        System.out.println("We have the following individual Items");
        for(int i=0;i<items.length;i++) {
            displayItem(items[i]);
        }
    }


    private void displayItem(MenuItem item){
        System.out.println("Name:- "+item.getName()+" "+"Price:- "+item.getPrice()+" KEY:- "+item.getKey());
    }


}


