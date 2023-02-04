package pl.dstasiak;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\pl\\dstasiak\\files\\test.txt";
        String filePath2 = System.getProperty("user.dir")+"\\src\\main\\java\\pl\\dstasiak\\files\\tester2.txt";

//        Writer writer = new Writer(filePath);
//        Writer writer2 = new Writer(filePath2);
//        writer.write("text");
//        writer2.write("text2");

//        Reader reader = new Reader(filePath);
//        Reader reader2 = new Reader(filePath2);
//        reader.read();
//        reader2.read();

        Checker checker = new Checker(filePath);
        Checker checker2 = new Checker(filePath, filePath2);
        checker.check();
        checker2.check();
    }
}