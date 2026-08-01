package PracticeQuestions.Restaurant.Command;

import PracticeQuestions.Restaurant.Order.Order;

public class PrepareCommand implements Command {
    private Order order;
    public PrepareCommand(Order order){
        this.order = order;
    }

    public void execute(){
        try {
            this.order.prepareOrder();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
