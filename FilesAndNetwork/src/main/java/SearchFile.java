import java.io.File;
import java.util.ArrayList;

public class SearchFile {

    ArrayList<String> pathsJSON = new ArrayList<>();
    ArrayList<String> pathsCSV = new ArrayList<>();

    public ArrayList<String> getSearchFilePath(String folderFile) {
        File filePath = new File(folderFile);
        if (filePath.isDirectory()) {
            File[] directoryFile = filePath.listFiles();
            if (directoryFile != null) {
                for (File file : directoryFile) {
                    if (file.isDirectory()) {
                        getSearchFilePath(String.valueOf(file));
                    }
                    if (file.getName().toLowerCase().endsWith(".json")) {
                        pathsJSON.add(file.getAbsolutePath());
                    }
                    if (file.getName().toLowerCase().endsWith(".csv")) {
                        pathsCSV.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return new ArrayList<String>();
    }

    public ArrayList<String> getPathsJSON() {
        return pathsJSON;
    }

    public ArrayList<String> getPathsCSV() {
        return pathsCSV;
    }
}
