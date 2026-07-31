package PracticeQuestions.MACD.Meals;

import PracticeQuestions.MACD.ENUMS.ColdDrinkType;
import PracticeQuestions.MACD.ENUMS.FriesType;
import PracticeQuestions.MACD.Items.Burger;
import PracticeQuestions.MACD.Items.ColdDrink;
import PracticeQuestions.MACD.ENUMS.BurgerType;
import PracticeQuestions.MACD.ENUMS.MealType;
import PracticeQuestions.MACD.Items.Fries;
import PracticeQuestions.MACD.Items.MenuItem;


public class Mealfactory {
    public Meal getMeal(MealType type) {
        switch (type){
            case DELUX:
                return new DeluxMeal().getMeal();
            case SUNDAY:
                return new SundayMeal().getMeal();
            case CHICKEN:
                return new ChickenMeal().getMeal();
            default:
                return null;
        }
    }
}

class DeluxMeal extends Meal {
    Meal meal;
    DeluxMeal() {
        this.meal = this.prepareMeal();
    }

    Meal getMeal(){
        return this.meal;
    }

    Meal prepareMeal(){
        MenuItem burger = new Burger("VegBurger", 250, BurgerType.VEG, 1);
        MenuItem burger1 = new Burger("MaharajaBurger", 350, BurgerType.MAHARAJA, 4);
        MenuItem fries = new Fries(FriesType.NORMAL);
        ColdDrink cd = new ColdDrink("LimeSoda", 50, 6, ColdDrinkType.LIMESODA);
        MenuItem[] items = new MenuItem[4];
        items[0] = burger;
        items[1] = burger1;
        items[2] = fries;
        items[3] = cd;
        price = this.getPrice(items);
        return new Meal(items, price,7, MealType.DELUX);
    }

    int getPrice(MenuItem[] items){
        int price = 0;
        for(int i=0;i<items.length;i++){
            price += items[i].getPrice();
        }
        return price;
    }
}



class SundayMeal extends Meal {
    Meal meal;
    SundayMeal() {
        this.meal = this.prepareMeal();
    }

    Meal getMeal(){
        return this.meal;
    }

    Meal prepareMeal(){
        MenuItem burger = new Burger("VegBurger", 250, BurgerType.VEG,1);
        MenuItem fries = new Fries(FriesType.NORMAL);
        ColdDrink cd = new ColdDrink("COCOCOLA", 60, 6, ColdDrinkType.COCOCOLA);
        MenuItem[] items = new MenuItem[3];
        items[0] = burger;
        items[1] = fries;
        items[2] = cd;
        price = this.getPrice(items);
        return new Meal(items, price, 9, MealType.SUNDAY);
    }

    int getPrice(MenuItem[] items){
        int price = 0;
        for(int i=0;i<items.length;i++){
            price += items[i].getPrice();
        }
        return price;
    }
}

class ChickenMeal extends Meal {
    Meal meal;
    ChickenMeal() {
        this.meal = this.prepareMeal();
    }

    Meal getMeal(){
        return this.meal;
    }

    Meal prepareMeal(){
        MenuItem burger = new Burger("ChickenBurger", 450, BurgerType.CHICKEN, 3);
        MenuItem fries = new Fries(FriesType.NORMAL);
        ColdDrink cd = new ColdDrink("SPRITE", 55, 6, ColdDrinkType.SPRITE);
        MenuItem[] items = new MenuItem[3];
        items[0] = burger;
        items[1] = fries;
        items[2] = cd;
        price = getPrice(items);
        return new Meal(items, price, 8, MealType.CHICKEN);
    }

    int getPrice(MenuItem[] items){
        int price = 0;
        for(int i=0;i<items.length;i++){
            price += items[i].getPrice();
        }
        return price;
    }
}
