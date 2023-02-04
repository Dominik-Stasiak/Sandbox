package pl.dstasiak;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    String filePath;
    Boolean append = true;
    public Writer(String filePath, Boolean append){
        this.filePath = filePath;
        this.append = append;
    }

    public Writer(String filePath){
        this.filePath = filePath;
    }

    public void write(String textToWrite){
        try{
            File file = new File(filePath);
            if (file.exists()) {
                FileWriter fileWriter = new FileWriter(file, append);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                if (file.length() == 0) {
                    bufferedWriter.write(textToWrite);
                } else {
                    bufferedWriter.write("\n"+textToWrite);
                }
                bufferedWriter.close();
                fileWriter.close();
                if (append) {
                    System.out.println("Text appended");
                } else {
                    System.out.println("Text overwrite");
                }
            } else {
                System.out.println("File doesn't exists");
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
