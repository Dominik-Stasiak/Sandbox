package pl.dstasiak;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class AM_PM {
    public static String timeConversion(String s) {
       String timeType = s.substring(s.length()-2);
       int h = Integer.parseInt(s.substring(0,2),10);
       String endT = s.substring(2, s.length() - 2);
       String startT;
       if (timeType.equals("AM")) {
           if (h == 12) {
               startT="00";
           } else {
               startT = s.substring(0,2);
           }
           return startT+endT;
       }
       else{
           if (h == 12){
               return h+endT;
           } else {
               return (h+12)+endT;
           }
       }
    }
}
