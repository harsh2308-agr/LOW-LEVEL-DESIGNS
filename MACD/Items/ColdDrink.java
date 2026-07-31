package PracticeQuestions.MACD.Items;

import PracticeQuestions.MACD.ENUMS.ColdDrinkType;

public class ColdDrink extends MenuItem{
    String name;
    int price;
    ColdDrinkType type;
    public ColdDrink(String name, int price, int key, ColdDrinkType type){
        super(name, price, key);
        this.type = type;
    }


    public ColdDrink customize(ColdDrinkType type){
        switch(type){
            case LIMESODA:
                this.name = "LimeSoda";
                this.price = 30;
                this.type = ColdDrinkType.LIMESODA;
                return this;
            case SPRITE:
                this.name = "SPRITE";
                this.price = 40;
                this.type = ColdDrinkType.SPRITE;
                return this;
            case COCOCOLA:
                this.name = "COCOCOLA";
                this.price = 50;
                this.type = ColdDrinkType.COCOCOLA;
                return this;
            default:
                return null;    
        }
    }
}
