package pl.dstasiak;

import java.util.ArrayList;
import java.util.List;

public class Matcher {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        int temp;
        List<Integer> res = new ArrayList<>();

        for (String q : queries) {
            temp = 0;
            for (String s : strings) {
                if (q.equals(s)) temp++;
            }
            res.add(temp);
        }

        return res;
    }
}
