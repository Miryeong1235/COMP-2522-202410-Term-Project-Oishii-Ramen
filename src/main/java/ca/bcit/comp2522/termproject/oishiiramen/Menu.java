package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.ArrayList;

public abstract class Menu {
    public static final double COST_FOR_CHASHU = 0.5;
    public static final double COST_FOR_CORN = 0.1;
    public static final double COST_FOR_TAMAGO = 0.3;
    public static final double COST_FOR_SEAWEED = 0.1;

    public static final double LARGE_SIZE_COEFFICIENT = 1.3;
    protected double costForRamen;
    protected int menuID;
    protected String name;
    protected ArrayList<Topping> toppings;
    protected final String size;
    protected double price;
    protected double materialCost;

    static int numberOfMenu = 0;

    public enum Topping {
        chashu,
        corn,
        tamago,
        seaweed,
    }

    public enum RamenSize {
        large, medium
    }

    public Menu(String size) {
        numberOfMenu++;
        this.menuID = numberOfMenu;
        this.size = size; // error handling

        // calculate material cost for this menu and ramen itself
        if (this.size.equals("large")) {
            this.materialCost = getCostForRamen() * LARGE_SIZE_COEFFICIENT;
            this.costForRamen = getCostForRamen() * LARGE_SIZE_COEFFICIENT;
        } else {
            this.materialCost = getCostForRamen();
            this.costForRamen = getCostForRamen();
        }

        this.name = this.getClass().getName() + this.getSize();
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

    public void setName(String newName) {
        this.name = newName;
    }

    //今のままだとtoppingを一度addしたら変えられないかも
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;

        // setting new material cost with toppings
        // enumの使い方がいまいちわからない
        for (Topping topping : toppings) {
            if (topping.equals(Topping.chashu)) {
                addToppingMaterialCost(COST_FOR_CHASHU);
            } else if (topping.equals(Topping.corn)) {
                addToppingMaterialCost(COST_FOR_CORN);
            } else if (topping.equals(Topping.tamago)) {
                addToppingMaterialCost(COST_FOR_TAMAGO);
            } else if (topping.equals(Topping.seaweed)) {
                addToppingMaterialCost(COST_FOR_SEAWEED);
            }
        }
    }

    public void addToppingMaterialCost(double addingCost){
        this.materialCost += addingCost;
    };

    public void setPrice(double newPrice) {
        this.price = newPrice; // Add some logic
    }
}
