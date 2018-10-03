package interviewPickings.systemDesign.vmVendingMachine;

import java.util.HashMap;

public class ItemsRepo {
    public HashMap<Integer, VendingItem> loadItems() {
        HashMap<Integer, VendingItem> map = new HashMap<>();
        map.put(1, new VendingItem(1, 2, 5, 10, "Вафла Мура"));
        map.put(2, new VendingItem(2, 3, 5, 10, "Сок"));
        map.put(3, new VendingItem(3, 1, 5, 10, "Вода"));
        map.put(4, new VendingItem(4, 5, 5, 10, "Кашу Ядки"));
        return map;
    }
}
