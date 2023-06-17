import java.lang.String;

public class Item {
    private String name;
    private double calories;
    private boolean standalone = false;
    public double price;
    public int stock;

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;   
    }

    public void addStock(Item item, int amountToAdd) {
        this.Item.stock += amountToAdd;
    }

    public void minusStock(Item item, int amountToAdd) {
        this.Item.stock -= amountToAdd;
    }
}
