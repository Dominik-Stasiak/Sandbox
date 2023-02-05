package pl.dstasiak;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final FilePick filePick = new FilePick();
    private int x;

    public Menu() {
        System.out.println("Welcome to FileChecker program !\n");
        program();
    }

    private void program() {

        options();
        x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                System.out.println("Read text selected\n");
                if (fileList()) {
                    System.out.println("\nText from file :\n");
                    System.out.println("_______________________________________________________");
                    Reader reader = new Reader(filePick.fileChoice(x));
                    reader.read();
                    System.out.println("_______________________________________________________");
                    waitForKey();
                    program();
                } else {
                    program();
                }
            }
            case 2 -> {
                System.out.println("Write text to file selected\n");
                if (fileList()) {
                    System.out.println("\nText from file :\n");
                    System.out.println("_______________________________________________________");
                    Writer writer = new Writer(filePick.fileChoice(x));
                    Scanner write = new Scanner(System.in);
                    System.out.print("Write text to add : ");
                    writer.write(write.nextLine());
                    System.out.println("_______________________________________________________");
                    waitForKey();
                    program();
                } else {
                    program();
                }
            }
            case 3 -> {
                System.out.println("Check information about file selected\n");
                if (fileList()) {
                    System.out.println("_______________________________");
                    Checker checker = new Checker(filePick.fileChoice(x));
                    checker.check();
                    System.out.println("_______________________________");
                    waitForKey();
                    program();
                } else {
                    program();
                }
            }
            case 4 -> {
                System.out.println("Compare two of text file selected\n");
                if (fileList()) {
                    int f = x;
                    fileList();
                    System.out.println("__________________________________________________________________");
                    Checker checker = new Checker(filePick.fileChoice(f), filePick.fileChoice(x));
                    checker.check();
                    System.out.println("__________________________________________________________________");
                    waitForKey();
                    program();
                } else {
                    program();
                }
            }
            case 5 -> {
                System.out.println("Bye...");
                break;
            }
            default -> {
                program();
            }
        }
    }

    private void options() {

        String stringBuilder =
                """
                        Select option from [1-5]
                                                
                        1. Read text from file
                        2. Write text to file
                        3. Check information about text file
                        4. Compare information of 2 text files
                        5. Exit
                                        
                        ->\s""";

        System.out.print(stringBuilder);
    }

    private void waitForKey() {
        System.out.println("\nPress any key to continue...");
        try {
            System.in.read();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private boolean fileList() {
        boolean res = false;
        System.out.println("_______________________________________________________");
        int listSize = filePick.fileList();
        System.out.println("_______________________________________________________");
        if (listSize > 0) {
            res = true;
            System.out.print("Select number of file from the list or 0 to exit : ");
            x = scanner.nextInt();
            System.out.println();
            while (x < 0 || x > listSize) {
                System.out.print("[WARN] file doesn't exist, choose correct option : ");
                x = scanner.nextInt();
            }

            if (x == 0) {
                res = false;
                program();
            }
        } else {
            System.out.println("[WARN] \"files\" directory is empty");
        }
        return res;
    }
}
