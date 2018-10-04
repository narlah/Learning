package interviewPickings.systemDesign.vmVendingMachine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {
    ItemsRepo repo = new ItemsRepo();
    HashMap<Integer, VendingItem> inventoryMap = repo.loadItems();

    public String listMenu() {
        StringBuilder sb = new StringBuilder();
        List<VendingItem> list = inventoryMap.entrySet().stream().
                map(s -> s.getValue()).sorted(Comparator.comparing(VendingItem::getName)).collect(Collectors.toList());
        int id = 0;
        for (VendingItem vi : list) { //secret - :q quits vi
            sb.append(String.format("%d (id) Можете да закупите %s на цена %.2f. \n", id++, vi.getName(), vi.getPrice()));
        }
        sb.append("Моля направете избора си.");
        return sb.toString();
    }

    public VendingItem getItem(int id) {
        return inventoryMap.getOrDefault(id, new VendingItem(0, 0, 0, 0, "Not Found"));


    }
}
