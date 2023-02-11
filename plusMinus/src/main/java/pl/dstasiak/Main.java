package pl.dstasiak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println("Ratio of positive / negative / zeros numbers in array : \n");
        Ratio.plusMinus(arr);
        System.out.println("\nMinimum and maximum of 4 numbers in array : \n");
        MinMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }
}