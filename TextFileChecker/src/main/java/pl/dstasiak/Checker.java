package pl.dstasiak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Checker {
    private int
            characters = 0,
            wordsOrWhite = 0,
            paragraphs = 0;
    double weigth = 0.0d;
    private int
            characters2 = 0,
            wordsOrWhite2 = 0,
            paragraphs2 = 0;
    double weigth2 = 0.0d;
    private final String filePath;
    private String fileName;
    private String filePath2 = null, fileName2;

    public Checker(String filePath, String filePath2) {
        this.filePath = filePath;
        this.filePath2 = filePath2;
    }

    public Checker(String filePath) {
        this.filePath = filePath;
    }

    public void check() {
        checkIt(filePath, true);
        if (filePath2 != null) checkIt(filePath2, false);
        show();
    }

    private void checkIt(String filePath, boolean first) {
        int p = 0;
        int w = 0;
        int ch = 0;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                int c;
                while ((c = bufferedReader.read()) != -1) {

                    if (c == 10) p++;
                    if (c == 10 || c == 32) {
                        w++;
                        continue;
                    }
                    ch++;
                }
                if (ch > 0) p++;
                bufferedReader.close();
                fileReader.close();

                if (first) {
                    this.characters = ch;
                    this.wordsOrWhite = w;
                    this.paragraphs = p;
                    this.fileName = file.getName();
                    this.weigth = file.length()/1024d;
                } else {
                    this.characters2 = ch;
                    this.wordsOrWhite2 = w;
                    this.paragraphs2 = p;
                    this.fileName2 = file.getName();
                    this.weigth2 = file.length()/1024d;
                }
            } else {
                System.out.println("File doesn't exists");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }

    private void show() {
        StringBuilder stringBuilder = new StringBuilder();

        if (filePath2 != null) {
            stringBuilder.append(String.format("%-15s %-20s %-20s %s\n", "file", fileName, fileName2, "differs"));
            stringBuilder.append(String.format("%-15s %-20s %-20s %s\n", "characters", characters, characters2, Math.abs(characters-characters2)));
            stringBuilder.append(String.format("%-15s %-20s %-20s %s\n", "words", wordsOrWhite, wordsOrWhite2, Math.abs(wordsOrWhite-wordsOrWhite2)));
            stringBuilder.append(String.format("%-15s %-20s %-20s %s\n", "paragraphs", paragraphs, paragraphs2, Math.abs(paragraphs-paragraphs2)));
            stringBuilder.append(String.format("%-15s %-20.3f %-20.3f %.3f\n", "size(Kb)", weigth, weigth2, Math.abs(weigth-weigth2)));
        } else {
            stringBuilder.append(String.format("%-15s %-20s\n", "file", fileName));
            stringBuilder.append(String.format("%-15s %-20s\n", "characters", characters));
            stringBuilder.append(String.format("%-15s %-20s\n", "words", wordsOrWhite));
            stringBuilder.append(String.format("%-15s %-20s\n", "paragraphs", paragraphs));
            stringBuilder.append(String.format("%-15s %-20.3f\n", "size(Kb)", weigth));
        }
        System.out.println(stringBuilder);
    }
}
