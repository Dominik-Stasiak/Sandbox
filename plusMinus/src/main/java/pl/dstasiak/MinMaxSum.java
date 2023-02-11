package pl.dstasiak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        List<Integer> temp = arr;
        Collections.sort(temp);

        long maximum = 0, minimum = 0;

        for (int i = 0; i<4; i++) minimum += temp.get(i);
        for (int i = temp.size()-1; i>temp.size()-5; i--) maximum += temp.get(i);

        System.out.println(minimum+" "+maximum);
    }
}
