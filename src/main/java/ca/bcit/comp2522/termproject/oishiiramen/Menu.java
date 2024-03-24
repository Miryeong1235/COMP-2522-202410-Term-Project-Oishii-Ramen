package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.ArrayList;

public abstract class Menu {
    public static final double COST_FOR_CHASHU = 0.5;
    public static final double COST_FOR_WAKAME = 0.1;
    public static final double COST_FOR_TAMAGO = 0.3;
    public static final double COST_FOR_SEAWEED = 0.1;
    private double costForRamen;
    private int menuID;
    private String name;
    private ArrayList<Topping> toppings;
    private final String size;
    private double price;
    private double materialCost;

    public Menu(String size) {
        this.size = size; // error handling
    }

    public double getCostForRamen() {
        return costForRamen;
    }

    public int getMenuID() {
        return menuID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public void setPrice(double price) {
        this.price = price; // Add some logic
    }
}
