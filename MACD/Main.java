package PracticeQuestions.MACD;

import PracticeQuestions.MACD.Cart.Cart;
import PracticeQuestions.MACD.Customize.Customize;
import PracticeQuestions.MACD.Display.Display;
import PracticeQuestions.MACD.Order.CreateOrder;
import PracticeQuestions.MACD.Order.Order;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("Welcome to MacDonald's");
        System.out.println("----****MENU****----");
        System.out.println("---------------------------------------");
        Scanner sc = new Scanner(System.in);
        //Displaying the items
        Display display = new Display();

        //selecting the items to make an order
        CreateOrder createOrder = new CreateOrder();
        Order order = createOrder.startOrder(sc);

        //Add Order to the cart
        Order[] orders = new Order[1];
        if(order == null)
            return;
        orders[0] = order;

        Cart cart = Cart.getInstance();
        cart.setOrders(orders);
        cart.viewCart();

        //Customize Order
        Customize customize = new Customize(cart,sc);
        cart.viewCart();
        sc.close();

    }
}
