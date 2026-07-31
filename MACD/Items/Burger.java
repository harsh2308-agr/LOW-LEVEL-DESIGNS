package PracticeQuestions.MACD.Items;

import PracticeQuestions.MACD.ENUMS.BurgerType;

public class Burger extends MenuItem {
    String name;
    BurgerType type;
    int price;
    public Burger(String name, int price, BurgerType type, int key){
        super(name, price, key);
        this.type = type;
    }
}

