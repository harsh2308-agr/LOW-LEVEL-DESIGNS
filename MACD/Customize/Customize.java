package PracticeQuestions.MACD.Customize;

import PracticeQuestions.MACD.Cart.Cart;
import PracticeQuestions.MACD.ENUMS.ColdDrinkType;
import PracticeQuestions.MACD.ENUMS.FriesType;
import PracticeQuestions.MACD.Items.ColdDrink;
import PracticeQuestions.MACD.Items.Fries;
import PracticeQuestions.MACD.Items.MenuItem;
import PracticeQuestions.MACD.Meals.Meal;
import PracticeQuestions.MACD.Order.Order;

import java.util.Scanner;

public class Customize {
    Cart cart;

    public Customize(Cart cart, Scanner sc) {
        this.cart = cart;
        this.customizeOrder(sc);
    }

    private Cart customizeOrder(Scanner sc) {
        Order order = this.cart.getOrders()[0];
        Meal[] mealList = order.getMeals();
        MenuItem[] items = order.getItems();

        System.out.println("-----Customize your order--------");

        while (true) {
            System.out.println("Press 1 to customize your meal or 2 to customize your items or 3 to exit");
            int key = sc.nextInt();

            if (key == 3) {
                break;
            }

            if (key == 1) {
                for (int i = 0; i < mealList.length; i++) {
                    Meal meal = mealList[i];
                    System.out.println("updating your " + (i + 1) + " meal");
                    for (int j = 0; j < meal.getItems().length; j++) {
                        MenuItem item = meal.getItems()[j];

                        if (item.getKey() == 5) {
                            System.out.println("Press 1 for upgrading to PeriPeri Fries or 2 for cheese Fries or 3 to cancel");
                            int key1 = sc.nextInt();


                            while (key1 != 1 && key1 != 2 && key1 != 3) {
                                System.out.println("Error updating fries, press 1 or 2 or 3 to cancel");
                                key1 = sc.nextInt();
                            }

                            if (key1 == 1 && item instanceof Fries) {
                                item = ((Fries) item).customize((Fries) item, FriesType.PERIPERI);
                                meal.getItems()[j] = item;
                                System.out.println("Updated the fries to peri peri !!!!");
                            } else if (key1 == 2 && item instanceof Fries) {
                                item = ((Fries) item).customize((Fries) item, FriesType.CHEESE);
                                meal.getItems()[j] = item;
                                System.out.println("Updated the fries to CHEEESE !!!!");
                            }
                        } else if (item.getKey() == 6) {
                            System.out.println("Press 1 for upgrading to LIMESODA or 2 for COCACOLA or 3 to SPRITE or 4 to cancel");
                            int key1 = sc.nextInt();


                            while (key1 != 1 && key1 != 2 && key1 != 3 && key1 != 4) {
                                System.out.println("Error updating drink, press 1, 2, 3 or 4 to cancel");
                                key1 = sc.nextInt();
                            }

                            if (key1 == 1 && item instanceof ColdDrink) {
                                item = ((ColdDrink) item).customize(ColdDrinkType.LIMESODA);
                                meal.getItems()[j] = item;
                                System.out.println("Updated the ColdDrink to LIMESODA !!!!");
                            } else if (key1 == 2 && item instanceof ColdDrink) {
                                item = ((ColdDrink) item).customize(ColdDrinkType.COCOCOLA);
                                meal.getItems()[j] = item;
                                System.out.println("Updated the ColdDrink to COCOCOLA !!!!");
                            } else if (key1 == 3 && item instanceof ColdDrink) {
                                item = ((ColdDrink) item).customize(ColdDrinkType.SPRITE);
                                meal.getItems()[j] = item;
                                System.out.println("Updated the ColdDrink to SPRITE !!!!");
                            }
                        }
                    }
                }
            } else if (key == 2) {
                for (int i = 0; i < items.length; i++) {
                    MenuItem item = items[i];
                    if (item.getKey() != 5 && item.getKey() != 6) // Fix: corrected logic check
                        continue;

                    System.out.println("Updating the " + (i + 1) + " Item");
                    if (item.getKey() == 5) {
                        System.out.println("Press 1 for upgrading to PeriPeri Fries or 2 for cheese Fries or 3 to cancel");
                        int key1 = sc.nextInt();
                        while (key1 != 1 && key1 != 2 && key1 != 3) {
                            System.out.println("Error updating fries, press 1 or 2 or 3 to cancel");
                            key1 = sc.nextInt();
                        }
                        if (key1 == 1 && item instanceof Fries) {
                            item = ((Fries) item).customize((Fries) item, FriesType.PERIPERI);
                            items[i] = item;
                            System.out.println("Updated the fries to peri peri !!!!");
                        } else if (key1 == 2 && item instanceof Fries) {
                            item = ((Fries) item).customize((Fries) item, FriesType.CHEESE);
                            items[i] = item;
                            System.out.println("Updated the fries to CHEEESE !!!!");
                        }
                    } else {
                        System.out.println("Press 1 for upgrading to LIMESODA or 2 for COCACOLA or 3 to SPRITE or 4 to cancel");
                        int key1 = sc.nextInt();
                        while (key1 != 1 && key1 != 2 && key1 != 3 && key1 != 4) {
                            System.out.println("Error updating drink, press 1, 2, 3 or 4 to cancel");
                            key1 = sc.nextInt();
                        }
                        if (key1 == 1 && item instanceof ColdDrink) {
                            item = ((ColdDrink) item).customize(ColdDrinkType.LIMESODA);
                            items[i] = item;
                            System.out.println("Updated the ColdDrink to LIMESODA !!!!");
                        } else if (key1 == 2 && item instanceof ColdDrink) {
                            item = ((ColdDrink) item).customize(ColdDrinkType.COCOCOLA);
                            items[i] = item;
                            System.out.println("Updated the ColdDrink to COCOCOLA !!!!");
                        } else if (key1 == 3 && item instanceof ColdDrink) {
                            item = ((ColdDrink) item).customize(ColdDrinkType.SPRITE);
                            items[i] = item;
                            System.out.println("Updated the ColdDrink to SPRITE !!!!");
                        }
                    }
                }
            }
            System.out.println("Successfully customized the order.!!!");
        }


        return this.cart;
    }
}
