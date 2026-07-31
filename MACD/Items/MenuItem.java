package PracticeQuestions.MACD.Items;

public class MenuItem {
    String name;
    int price;
    int key;
    public MenuItem(String name, int price, int key) {
        this.name = name;
        this.price = price;
        this.key = key;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public int getKey(){
        return this.key;
    }
}