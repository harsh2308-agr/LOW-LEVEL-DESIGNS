package PracticeQuestions.Restaurant;

import PracticeQuestions.Restaurant.Command.Command;
import PracticeQuestions.Restaurant.Command.ServeCommand;
import PracticeQuestions.Restaurant.Enums.OrderStatus;
import PracticeQuestions.Restaurant.Order.Order;

public class Waiter {
    private Command command;

    public Waiter(){

    }
    public void setCommand(Command command){
        this.command = command;
        this.followCommand();
    }

    public void followCommand(){
        this.command.execute();
    }

    public void getUpdate(Order order, OrderStatus status){
        if(status == OrderStatus.READY){
            this.setCommand(new ServeCommand(order));
        }
    }
}
