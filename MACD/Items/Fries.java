package PracticeQuestions.MACD.Items;

import PracticeQuestions.MACD.ENUMS.FriesType;

public class Fries extends MenuItem {
    FriesType type;
   public Fries(FriesType type){
    super("French Fries", 200, 5);
    this.type = type;
   }

   public Fries customize(Fries fries, FriesType type){
        switch(type){
            case PERIPERI:
                return new PeriPeriDecorator(fries).decorate();
            case CHEESE:
                return new CheeseDecorator(fries).decorate();
            default:
                return fries;          
        }
   }
}

class PeriPeriDecorator {
    Fries fries;
    PeriPeriDecorator(Fries fries){
        this.fries = fries;
    }
    Fries decorate(){
        fries.name = fries.getName() + "Peri Peri";
        fries.price = fries.getPrice() + 50;
        fries.type = FriesType.PERIPERI;
        return fries;
    }
} 

class CheeseDecorator {
    Fries fries;
    CheeseDecorator(Fries fries){
        this.fries = fries;
    }

    Fries decorate(){
        fries.name = fries.getName() + "Cheese";
        fries.price = fries.getPrice() + 60;
        fries.type = FriesType.CHEESE;
        return fries;
    }
} 