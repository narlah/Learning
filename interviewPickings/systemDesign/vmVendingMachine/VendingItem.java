package interviewPickings.systemDesign.vmVendingMachine;

public class VendingItem {
    int id;
    float price;
    int capacity;
    int maxCap;
    String name;

    public VendingItem(int id, float price, int capacity, int maxCap, String name) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
        this.maxCap = maxCap;
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
