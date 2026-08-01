package PracticeQuestions.Restaurant.MenuItem;

import PracticeQuestions.Restaurant.Enums.DISH;

public class MenuItem {
    private DISH dish;

    public MenuItem(DISH dish){
        this.dish = dish;
    }

    public DISH getDish() {
        return dish;
    }

    public void setDish(DISH dish) {
        this.dish = dish;
    }
}
