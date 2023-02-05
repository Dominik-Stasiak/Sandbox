package pl.dstasiak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private final File file;
    public Reader(File file) {
        this.file = file;
    }

    public void read(){
        String out;
        try {
            if (file.exists()){
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((out = bufferedReader.readLine()) != null) {
                    System.out.println(out);
                }
            } else {
                System.out.println("File doesn't exists");
            }

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
