import java.util.HashMap;

public class VendingMachine {
    HashMap<Product, Integer> inventory;
    int collectedMoney;
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
            return "Product not available at the moment";
        if(quantity>inventory.get(product))
            return "Not enough product present";
        if(moneyEntered<quantity*product.price)
            return "Insufficient Funds";
        collectedMoney += product.price*quantity;
        int changeMoney = moneyEntered - product.price*quantity;
        return String.valueOf(changeMoney);
    }



}
