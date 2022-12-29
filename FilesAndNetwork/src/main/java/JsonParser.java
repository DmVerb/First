import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class JsonParser {
    private static final String STATION_NAME = "station_name";
    private static final String DEPTH = "depth";

    ArrayList<StationDepth> stationsDepht = new ArrayList<>();

    public ArrayList<StationDepth> parserJsonArray(ArrayList<String> json) {
        for (String jsonPath :
                json) {
            JSONParser jsonParser = new JSONParser();
            try (FileReader fileReader = new FileReader(jsonPath)) {
                JSONArray linesJsonArray = (JSONArray) jsonParser.parse(fileReader);                    //Обход массива объектов (станций)
                for (Object it : linesJsonArray) {                                                       //Обход каждого элемента (станции)
                    JSONObject stationJsonObject = (JSONObject) it;

                    String station_name = (String) stationJsonObject.get(STATION_NAME);
                    String depthSTR = (String) stationJsonObject.get(DEPTH);
                    double depth = Double.parseDouble(depthSTR.replaceAll("[,]", ".").replaceAll("[?]", "0.0"));

                    stationsDepht.add(new StationDepth(station_name, depth));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stationsDepht;
    }


}
