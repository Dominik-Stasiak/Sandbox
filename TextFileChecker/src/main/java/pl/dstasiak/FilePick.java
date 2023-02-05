package pl.dstasiak;

import java.io.File;
import java.io.FilenameFilter;

public class FilePick {
    private String[] files;
    private final String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\pl\\dstasiak\\files";
    private final File file = new File(filePath);
    private final FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".txt");
        }
    };

    public int fileList() {
        files = file.list(filter);

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                System.out.println(i + 1 + ". " + files[i]);
            }

            return files.length;
        }

        return 0;
    }

    public File fileChoice(int choice) {
        choice -= 1;
        return new File(filePath + "\\" + files[choice]);
    }
}
