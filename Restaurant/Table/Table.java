package PracticeQuestions.Restaurant.Table;

import PracticeQuestions.Restaurant.Bill.Bill;
import PracticeQuestions.Restaurant.Command.Command;
import PracticeQuestions.Restaurant.Command.PrepareCommand;
import PracticeQuestions.Restaurant.Enums.OrderStatus;
import PracticeQuestions.Restaurant.Order.Order;
import PracticeQuestions.Restaurant.Waiter;

import java.util.ArrayList;
import java.util.List;

public class Table {
    int people;
    List<Order> orders;
    Order currentOrder;
    Waiter waiter;
    Bill bill;

    public Table(int people, Waiter waiter){
        this.people = people;
        this.waiter = waiter;
        this.currentOrder = null;
        this.orders = new ArrayList<>();
        this.bill = new Bill();
    }

    public void addOrder(Order order){
        if(order.getItems().isEmpty()){
            return;
        }
        Command command = new PrepareCommand(order);
        this.currentOrder = order;
        order.setWaiter(waiter);
        waiter.setCommand(command);
        this.bill.addOrder(order);
        this.orders.add(order);
    }

    public void payBill() {
        if(this.orders.isEmpty())
            return;
        this.bill.displayBill();
    }

}
