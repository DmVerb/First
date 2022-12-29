import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ParseHTML metro = new ParseHTML("https://skillbox-java.github.io/");
        metro.parseToFile("data/.txt");
        ArrayList <Line> lines = metro.addLine();
        ArrayList <Station> stations = metro.addStation();


        SearchFile searchFile = new SearchFile();
        searchFile.getSearchFilePath("src/main/resources/data");

        JsonParser jsonParser = new JsonParser();
        ArrayList<StationDepth> stationDepth = jsonParser.parserJsonArray(searchFile.pathsJSON);


        CsvParser csvParser = new CsvParser();
        ArrayList <StationDate> stationDates = csvParser.parserCsvArray(searchFile.pathsCSV);

        WriteJsonFile writeJsonFile = new WriteJsonFile(lines,stations,stationDates,stationDepth);
        writeJsonFile.stationAndLinToAddToFile();
        writeJsonFile.stationInfoToAddToFile();
    }
}