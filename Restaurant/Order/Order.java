package PracticeQuestions.Restaurant.Order;

import PracticeQuestions.Restaurant.Enums.OrderStatus;
import PracticeQuestions.Restaurant.Inventory.Inventory;
import PracticeQuestions.Restaurant.MenuItem.MenuItem;
import PracticeQuestions.Restaurant.Waiter;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Inventory inventory;
    List<MenuItem> items = new ArrayList<>();
    OrderStatus status;

    Waiter waiter;

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public Order() {
        this.inventory = Inventory.getInstance();
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public boolean addItem(MenuItem item){
        boolean success = inventory.removeItem(item.getDish(),1);
        if(success){
            this.items.add(item);
        } else {
            System.out.println("Sorry insufficient stock for- "+Inventory.getNameMap().get(item.getDish()));
        }
        return success;
    }

    public void prepareOrder() throws InterruptedException {
        this.status = OrderStatus.PREPARING;
        System.out.println("Preparing the order");
        Thread.sleep(2000);
        System.out.println("Order is prepared");
        this.status = OrderStatus.READY;
        this.notiyWaiter();
    }

    public void serveOrder() throws InterruptedException {
        System.out.println("Serving the order");
        Thread.sleep(2000);
        System.out.println("Order is served");
        this.status = OrderStatus.SERVED;
        this.notiyWaiter();
    }

    public int getPrice(){
        int price = 0;
        for(int i=0;i<items.size();i++){
            MenuItem item = items.get(i);
            price = price + inventory.getPriceMap().get(item.getDish());
        }
        return price;
    }

    public void displayOrder() {
        System.out.println("-------------");
        for(int i=0;i<items.size();i++){
            MenuItem item = items.get(i);
            System.out.println("NAME:- "+inventory.getNameMap().get(item.getDish())+" Price:- "+inventory.getPriceMap().get(item.getDish()));
        }
    }

    private void notiyWaiter(){
        this.waiter.getUpdate(this, this.status);
    }
}
