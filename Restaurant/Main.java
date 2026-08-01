package PracticeQuestions.Restaurant;

import PracticeQuestions.Restaurant.Enums.DISH;
import PracticeQuestions.Restaurant.Inventory.Inventory;
import PracticeQuestions.Restaurant.MenuItem.MenuItem;
import PracticeQuestions.Restaurant.Order.Order;
import PracticeQuestions.Restaurant.Table.Table;

public class Main {

    public static void main(String[] args) {
//        Inventory inventory = Inventory.getInstance();

        Table table = new Table(4, new Waiter());
        Order order = new Order();
        order.addItem(new MenuItem(DISH.KACHORI));
        order.addItem(new MenuItem(DISH.MANCHURIAN));


        table.addOrder(order);
        table.payBill();
    }
}
