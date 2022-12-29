import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    ArrayList<StationDate> stationsDates = new ArrayList<>();


    public ArrayList<StationDate> parserCsvArray(ArrayList<String> csv) {
        for (String csvPath : csv) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(csvPath));
                for (String line : lines) {
                    if (line.contains("name") || line.contains("date")) {
                        continue;
                    }
                    String[] fragments = line.split("[,]");
                    if (fragments.length != 2) {
                        System.out.println("Wrong line: " + line);
                        continue;
                    }
                    String dateFormat = "dd.MM.yyyy";
                    stationsDates.add(new StationDate(fragments[0], (new SimpleDateFormat(dateFormat)).parse(fragments[1])));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return stationsDates;
    }
}
