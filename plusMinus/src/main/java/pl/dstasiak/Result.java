package pl.dstasiak;

import java.util.*;

class Result {
    public static void plusMinus(List<Integer> arr) {
        int s = arr.size();
        double n = 0d, p = 0d, z = 0d;

        for (Integer i : arr) {
            if(i > 0){
                p++;
            } else if (i < 0){
                n++;
            } else z++;
        }

        System.out.printf("%.6f\n", p/s);
        System.out.printf("%.6f\n", n/s);
        System.out.printf("%.6f\n", z/s);
    }

}



