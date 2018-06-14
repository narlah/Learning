package interviewPickings.codeFights;

import tools.MapTools;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JewellersCrown {

    int stonesForCrown(int[] stones) {
        int maxSizeOfStone = -1;
        long maxNumberOfStones = 0;
        Map<Integer, Long> map = Arrays.stream(stones).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        MapTools.printMap(map);
        Integer[] keyArr = new Integer[map.size()];
        map.keySet().toArray(keyArr);

        for (int i = keyArr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int currentBigKey = Math.max(keyArr[i], keyArr[j]);
                if (map.get(keyArr[i]).equals(map.get(keyArr[j])) && map.get(keyArr[i]) >= maxNumberOfStones) {
                    if (map.get(keyArr[i]) == maxNumberOfStones && currentBigKey < maxSizeOfStone) continue;
                    maxNumberOfStones = map.get(keyArr[i]);
                    maxSizeOfStone = currentBigKey;
                }
            }
        }

        return maxSizeOfStone;
    }

    public static void main(String[] args) {
        JewellersCrown jc = new JewellersCrown();
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 7};
        System.out.println(jc.stonesForCrown(arr));
    }
}
