package PracticeQuestions.Restaurant.Bill;

import PracticeQuestions.Restaurant.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    List<Order> orders = new ArrayList<>();
    int totalPrice;

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public int calculatePrice(){
        int price = 0;
        for(int i=0;i<orders.size();i++){
            Order order = orders.get(i);
            price = price + order.getPrice();
        }
        this.totalPrice = price;
        return price;
    }

    public void displayBill() {
        System.out.println("Your Bill is:- ");
        for(int i=0;i<orders.size();i++){
            Order order = orders.get(i);
            order.displayOrder();
        }
        System.out.println("----------------------------");
        System.out.println("Total:- "+this.calculatePrice());
        this.payBill();
    }

    private void payBill(){

    }
}
