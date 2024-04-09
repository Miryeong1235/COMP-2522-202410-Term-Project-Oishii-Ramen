package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.ArrayList;

/**
 * Menu class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public abstract class Menu {

    /**
     * Material cost for chashu.
     */
    public static final double COST_FOR_CHASHU = 0.5;

    /**
     * Material cost for corn.
     */
    public static final double COST_FOR_CORN = 0.1;

    /**
     * Material cost for tamago.
     */
    public static final double COST_FOR_TAMAGO = 0.3;

    /**
     * Material cost for seaweed.
     */
    public static final double COST_FOR_SEAWEED = 0.1;

    /**
     * Coefficient for large sized ramen.
     */
    public static final double LARGE_SIZE_COEFFICIENT = 1.3;

    /**
     * The number of menu.
     */
    private static int numberOfMenu = 0;

    /**
     * Material cost for the menu object.
     */
    protected double costForRamen;

    /**
     * Menu ID for the menu.
     */
    protected int menuID;

    /**
     * Name for the menu.
     */
    protected String name;

    /**
     * An ArrayList of the toppings.
     */
    protected ArrayList<Topping> toppings;

    /**
     * Size for the menu.
     */
    protected final String size;

    /**
     * Price for the menu.
     */
    protected double price;

    /**
     * Material cost for the menu.
     */
    protected double materialCost;

    /**
     * The Topping enum represents the possible toppings which a menu object can have.
     * It provides four options: chashu, corn, tamago, and seaweed.
     */
    public enum Topping {
        chashu,
        corn,
        tamago,
        seaweed,
    }

    /**
     * The RamenSize enum represents the possible size of the ramen.
     * It provides three options: large and medium.
     */
    public enum RamenSize {
        large, medium
    }

    /**
     * Constructs a Menu object with a parameter.
     *
     * @param size as a String
     */
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

    /**
     * Returns a cost for the menu.
     *
     * @return costForRamen as a double
     */
    public double getCostForRamen() {
        return costForRamen;
    }

    /**
     * Returns menuID.
     *
     * @return menuID as an int
     */
    public int getMenuID() {
        return menuID;
    }

    /**
     * Returns name.
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ArrayList of Topping.
     *
     * @return toppings as an ArrayList
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    /**
     * Returns the size for the menu.
     *
     * @return size as a String
     */
    public String getSize() {
        return size;
    }

    /**
     * Returns a price for the menu.
     *
     * @return price as a double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a material cost for the menu.
     *
     * @return materialCost as a double
     */
    public double getMaterialCost() {
        return materialCost;
    }

    /**
     * Sets name.
     *
     * @param newName as a String
     */
    public void setName(final String newName) {
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

    public static int getNumberOfMenu() {
        return numberOfMenu;
    }
}
