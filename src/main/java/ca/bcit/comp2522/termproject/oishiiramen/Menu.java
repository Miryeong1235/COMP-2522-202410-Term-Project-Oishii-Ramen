package ca.bcit.comp2522.termproject.oishiiramen;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * Menu class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public abstract class Menu {
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
        Large, Medium
    }

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
    protected final RamenSize size;

    /**
     * Price for the menu.
     */
    protected double price;

    /**
     * Material cost for the menu.
     */
    protected double materialCost;

    /**
     * Constructs a Menu object with a parameter.
     *
     * @param size as a RamenSizes
     */
    public Menu(final RamenSize size) {
        numberOfMenu++;
        this.menuID = numberOfMenu;
        this.size = Objects.requireNonNullElse(size, RamenSize.Medium);
        this.costForRamen = getCostForRamen();
        this.materialCost = this.costForRamen;

        // calculate material cost for this menu and ramen itself
        if (this.size.equals(RamenSize.Large)) {
            this.materialCost *= LARGE_SIZE_COEFFICIENT;
            this.costForRamen *= LARGE_SIZE_COEFFICIENT;
        }
    }

    /**
     * Returns a cost for the menu.
     *
     * @return costForRamen as a double
     */
    public abstract double getCostForRamen();

    /**
     * Returns menuID.
     *
     * @return menuID as an int
     */
    public int getMenuID() {
        return this.menuID;
    }

    /**
     * Returns name.
     *
     * @return name as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the ArrayList of Topping.
     *
     * @return toppings as an ArrayList
     */
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Returns the size for the menu.
     *
     * @return size as a String
     */
    public RamenSize getSize() {
        return this.size;
    }

    /**
     * Returns a price for the menu.
     *
     * @return price as a double
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns a material cost for the menu.
     *
     * @return totalCost as a double
     */
    public double getMaterialCost() {
       return this.materialCost;
    }

    /**
     * Sets name if valid.
     *
     * @param newName as a String
     */
    public void setName(final String newName) {
        if (newName != null && !newName.isBlank()) {
            this.name = newName.strip().substring(0, 1).toUpperCase()
                    + newName.strip().substring(1).toLowerCase();
        }
    }

    /**
     * Sets the toppings for the ramen and updates the material cost accordingly.
     *
     * @param toppings the list of toppings to be added as an ArrayList
     */
    public void setToppings(final ArrayList<Topping> toppings) {
            this.toppings = toppings;
        // setting new material cost with toppings
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

    private void addToppingMaterialCost(final double addingCost) {
        this.materialCost += addingCost;
    }

    /**
     * Sets the new price if newName is valid.
     *
     * @param newPrice newName as a double
     */
    public void setPrice(final double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
        }
    }

    /**
     * Resets the total number of menu to zero.
     */
    public static void resetNumberOfMenu() {
        numberOfMenu = 0;
    }

    /**
     * Returns the number of the menu as an int.
     *
     * @return the number of the menu as an int
     */
    public static int getNumberOfMenu() {
        return numberOfMenu;
    }

    /**
     * Evaluates if some other object if "equal" to this one.
     *
     * @param o the reference object with which to compare
     * @return true if this object is equal to the o argument; false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Double.compare(getCostForRamen(), menu.getCostForRamen()) == 0 && getMenuID() == menu.getMenuID()
                && Double.compare(getPrice(), menu.getPrice()) == 0
                && Double.compare(getMaterialCost(), menu.getMaterialCost()) == 0
                && Objects.equals(getName(), menu.getName()) && Objects.equals(getToppings(), menu.getToppings())
                && getSize() == menu.getSize();
    }

    /**
     * Returns a hash code of this object.
     *
     * @return description as a String
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCostForRamen(), getMenuID(), getName(), getToppings(),
                getSize(), getPrice(), getMaterialCost());
    }

    /**
     * Returns a String representation of this object.
     *
     * @return description as a String
     */
    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.CANADA);
        numberFormat.setMaximumFractionDigits(2);
        return "Menu{"
                + "costForRamen=" + numberFormat.format(costForRamen)
                + ", menuID=" + menuID
                + ", name='" + name + '\''
                + ", toppings=" + toppings
                + ", size=" + size
                + ", price=" + price
                + ", materialCost=" + numberFormat.format(materialCost)
                + '}';
    }
}
