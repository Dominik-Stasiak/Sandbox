package pl.dstasiak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        a.forEach(i -> map.compute(i, (k,v) -> v == null ? 1 : v + 1));

        return map.entrySet().stream()
                .filter(i -> i.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(0);
    }

}
