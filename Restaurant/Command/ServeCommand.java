package PracticeQuestions.Restaurant.Command;

import PracticeQuestions.Restaurant.Order.Order;

public class ServeCommand implements Command {
    private Order order;
    public ServeCommand(Order order){
        this.order = order;
    }

    public void execute(){
        try {
            this.order.serveOrder();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


