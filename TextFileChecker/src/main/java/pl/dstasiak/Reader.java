package pl.dstasiak;

import java.io.*;

public class Reader {
    private String filePath;
    public Reader(String filePath) {
        this.filePath = filePath;
    }

    public void read(){
        String out;
        try {
            File file = new File(filePath);
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
