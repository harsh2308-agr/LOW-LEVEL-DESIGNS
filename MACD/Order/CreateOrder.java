package PracticeQuestions.MACD.Order;

import PracticeQuestions.MACD.ENUMS.BurgerType;
import PracticeQuestions.MACD.ENUMS.ColdDrinkType;
import PracticeQuestions.MACD.ENUMS.FriesType;
import PracticeQuestions.MACD.ENUMS.MealType;
import PracticeQuestions.MACD.Items.BurgerFactory;
import PracticeQuestions.MACD.Items.ColdDrink;
import PracticeQuestions.MACD.Items.Fries;
import PracticeQuestions.MACD.Items.MenuItem;
import PracticeQuestions.MACD.Meals.Meal;
import PracticeQuestions.MACD.Meals.Mealfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateOrder {



    public Order startOrder(Scanner sc) {
        int key = 1;
        List<MenuItem> itemList = new ArrayList<>();
        List<Meal> mealList = new ArrayList<>();

        BurgerFactory burgerFactory = new BurgerFactory();
        Mealfactory mealfactory = new Mealfactory();
        System.out.println("Create your Order---------->");
        while(key!=0 && isValidKey(key)){
            System.out.println("Enter the key you want to add or 0 to exit the order");
            key = sc.nextInt();
            if(!isMeal(key)){
                switch(key){
                    case 1:
                        itemList.add(burgerFactory.createBurger(BurgerType.VEG));
                        break;
                    case 2:
                        itemList.add(burgerFactory.createBurger(BurgerType.WHOOPER));
                        break;
                    case 3:
                        itemList.add(burgerFactory.createBurger(BurgerType.CHICKEN));
                        break;
                    case 4:
                        itemList.add(burgerFactory.createBurger(BurgerType.MAHARAJA));
                        break;
                    case 5:
                        itemList.add(new Fries(FriesType.NORMAL));
                        break;
                    case 6:
                        itemList.add(new ColdDrink("LimeSoda",30, 6,ColdDrinkType.LIMESODA));
                        break;
                }
            } else {
                switch(key) {
                    case 7:
                        mealList.add(mealfactory.getMeal(MealType.DELUX));
                        break;
                    case 8:
                        mealList.add(mealfactory.getMeal(MealType.CHICKEN));
                        break;
                    case 9:
                        mealList.add(mealfactory.getMeal(MealType.SUNDAY));
                        break;
                }
            }
        }
        if(itemList.isEmpty() && mealList.isEmpty())
            return null;

        Order order = new Order();
        MenuItem[] items = itemList.toArray(new MenuItem[0]);
        order.items = items;

        Meal[] meals = mealList.toArray(new Meal[0]);
        order.meals = meals;
        return order;

    }



    private boolean isValidKey(int key){
        return key>=1 && key<=9;
    }

    private boolean isMeal(int key){
        return key>=7 && key<=9;
    }
}
