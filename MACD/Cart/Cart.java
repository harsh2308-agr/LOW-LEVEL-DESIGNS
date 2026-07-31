package PracticeQuestions.MACD.Cart;

import PracticeQuestions.MACD.Order.Order;

public class Cart {

    static Cart cart;
    Order[] orders;
    int price;
    private Cart(){}

    public static Cart getInstance(){
        if(cart==null){
            cart = new Cart();
        }
        return cart;
    }

    public int getPrice(){
        this.price = calculatePrice();
        return this.price;
    }

    public void setOrders(Order[] orders){
        this.orders = orders;
    }

    public Order[] getOrders(){
        return this.orders;
    }

    public void viewCart(){
        if(orders[0]==null)
            return;
        orders[0].displayOrder();
        System.out.println("---------->Your total price is --> "+this.getPrice());
    }
    private int calculatePrice(){
        int price = 0;
        for(int i=0;i<orders.length;i++){
            price+=orders[i].getPrice();
        }
        return price;
    }


}
