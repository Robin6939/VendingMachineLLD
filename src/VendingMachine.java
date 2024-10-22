import java.util.HashMap;

public class VendingMachine {
    private HashMap<Product, Integer> inventory;
    private int collectedMoney;
    private static VendingMachine vendingMachine;

    private VendingMachine() {
        inventory = new HashMap<>();
        collectedMoney = 0;
    }

    public static VendingMachine getInstance() {
        if(vendingMachine == null){
            vendingMachine = new VendingMachine();
            return vendingMachine;
        }
        else
            return null;
    }

    void addInventory(Product product, int quantity) {
        if(inventory.containsKey(product)) {
            inventory.put(product, inventory.get(product)+quantity);
        }
        else
            inventory.put(product, quantity);
    }

    String buyProduct(Product product, int quantity, int moneyEntered) {
        if(!inventory.containsKey(product))
            return "Product out of stock";
        if(quantity>inventory.get(product))
            return "Not enough product present";
        if(moneyEntered<quantity*product.price)
            return "Insufficient Funds";
        collectedMoney += product.price*quantity;
        int changeMoney = moneyEntered - product.price*quantity;
        return String.valueOf(changeMoney);
    }

    int getQuantityOf(Product product) {
        return inventory.get(product);
    }

    int getCollectedMoney() {
        return collectedMoney;
    }



}
