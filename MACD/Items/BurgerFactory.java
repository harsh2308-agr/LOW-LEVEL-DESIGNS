package PracticeQuestions.MACD.Items;


import PracticeQuestions.MACD.ENUMS.BurgerType;

public class BurgerFactory {
    public Burger createBurger(BurgerType type){
        switch(type){
            case VEG:
                return new Burger("VegBurger", 250, BurgerType.VEG, 1);
            case WHOOPER:
                return new Burger("Whooper", 350, BurgerType.WHOOPER, 2);
            case CHICKEN:
                return new Burger("Chicken", 350, BurgerType.CHICKEN, 3);
            case MAHARAJA:
                return new Burger("Maharaja", 400, BurgerType.MAHARAJA, 4);
            default :
                return null;    
        }
    }
}


