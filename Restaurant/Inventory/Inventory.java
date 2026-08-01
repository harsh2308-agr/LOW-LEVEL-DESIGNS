package PracticeQuestions.Restaurant.Inventory;

import PracticeQuestions.Restaurant.Enums.DISH;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private static Inventory inventory;
    private static HashMap<DISH, Integer> dishMap = new HashMap<>();
    private static ConcurrentHashMap<DISH, Integer> stock= new ConcurrentHashMap<>();

    private static HashMap<DISH, String> nameMap = new HashMap<>();

    private static HashMap<DISH, Integer> priceMap = new HashMap<>();

    public static HashMap<DISH, String> getNameMap() {
        return nameMap;
    }

    private Inventory(){

    }

    public static HashMap<DISH, Integer> getDishMap() {
        return dishMap;
    }

    public static ConcurrentHashMap<DISH, Integer> getStock() {
        return stock;
    }

    public static HashMap<DISH, Integer> getPriceMap() {
        return priceMap;
    }

    public static Inventory getInstance(){
        if(inventory==null){
            inventory = new Inventory();
            mapDishes();
            updateInventory();
            updatePrice();
        }
        return inventory;
    }

    public int getQuantity(DISH dish){
        return stock.get(dish);
    }

    public boolean removeItem(DISH dish, int quantity){
        if(!isAvailable(dish, quantity))
            return false;
        int leftOver = stock.get(dish) - quantity;
        stock.put(dish, leftOver);
        return true;
    }

    public boolean addItem(DISH dish, int quantity){
        stock.put(dish, stock.get(dish)+quantity);
        return true;
    }

    private boolean isAvailable(DISH dish, int quantity){
        int available = stock.get(dish);
        if(quantity<available)
            return true;
        return false;
    }
    private static void mapDishes(){
        int i = 1;
        for(DISH dish: DISH.values()){
            dishMap.put(dish, i);
            i++;
        }
    }

    private static void updateInventory(){
        for(DISH key: dishMap.keySet()){
            stock.put(key, 5);
        }
    }

    private static void updatePrice() {
        for(DISH dish: dishMap.keySet()){
            switch (dish){
                case PAVBHAJI:
                    priceMap.put(dish, 200);
                    nameMap.put(dish, "PavBhaji");
                    break;
                case SHAKE:
                    priceMap.put(dish, 100);
                    nameMap.put(dish, "SHAKE");
                    break;
                case KACHORI:
                    priceMap.put(dish, 50);
                    nameMap.put(dish, "KACHORI");
                    break;
                case MAGGIEE:
                    priceMap.put(dish, 50);
                    nameMap.put(dish, "MAGGIEE");
                    break;
                case NOODLES:
                    priceMap.put(dish, 150);
                    nameMap.put(dish, "NOODLES");
                    break;
                case VADAPAV:
                    priceMap.put(dish, 50);
                    nameMap.put(dish, "VADAPAV");
                    break;
                case SANDWICH:
                    priceMap.put(dish, 80);
                    nameMap.put(dish, "SANDWICH");
                    break;
                case MANCHURIAN:
                    priceMap.put(dish, 150);
                    nameMap.put(dish, "MANCHRUIAN");
                    break;
                default:
                    priceMap.put(dish, 20);
                    nameMap.put(dish, "RANDOM");
                    break;
            }
        }
    }
}
