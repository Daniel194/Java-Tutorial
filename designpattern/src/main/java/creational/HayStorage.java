package creational;

// Singleton
public class HayStorage {
    private int quantity = 0;
    private static HayStorage ourInstance = new HayStorage();

    private HayStorage() {
    }

    public static HayStorage getInstance() {
        return ourInstance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }

}
