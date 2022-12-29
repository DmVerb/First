import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.*;

public class WriteJsonFile {
    private final Map<String, List<String>> metro = new HashMap<>();
    private final List<Map<String, Object>> station = new ArrayList<>();


    private final List<Line> lines;
    private final List<Station> stations;
    private final List<StationDate> stationDate;
    private final List<StationDepth> stationDepth;

    public WriteJsonFile(List<Line> lines, List<Station> stations, List<StationDate> stationDate, List<StationDepth> stationDepth) {
        this.lines = lines;
        this.stations = stations;
        this.stationDate = stationDate;
        this.stationDepth = stationDepth;
    }

    public void stationAndLinToAddToFile() {
        lines.forEach(line -> {
            List<String> stationsOfLine = new ArrayList<>();
            stations.forEach(station -> {
                if (line.getNumber().equals(station.getNumberLine())) {
                    stationsOfLine.add(station.getName());
                }
            });
            metro.put(line.getNumber(), stationsOfLine);
        });

        JSONObject stationAndLine = new JSONObject();
        stationAndLine.put("stations", metro);
        stationAndLine.put("lines", lines);

        try {
            ObjectMapper mapper = new ObjectMapper();
            File output = new File("data/new.json");
            mapper.writeValue(output, stationAndLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stationInfoToAddToFile() {
        stations.forEach(s -> {
            Map<String, Object> st = new LinkedHashMap<>();
            st.put("name", s.getName());
            st.put("line", lines.stream().filter(line -> line.getNumber().equals(s.getNumberLine())).findFirst().get().getName());
            if (stationDate.stream().anyMatch(stationDate1 -> stationDate1.getName().equals(s.getName()))) {
                st.put("date", stationDate.stream().filter(stationDate1 -> stationDate1.getName().equals(s.getName())).findFirst().get().getDate());
            }
            if (stationDate.stream().anyMatch(stationDate1 -> stationDate1.getName().equals(s.getName()))) {
                st.put("depth", stationDepth.stream().filter(stationDepth1 -> stationDepth1.getName().equals(s.getName())).findFirst().get().getDepth());
            }
            st.put("hasConnection", s.isHasConnection());
            station.add(st);
        });
        JSONObject stationsInfo = new JSONObject();
        stationsInfo.put("stations", station);
        try {
            ObjectMapper mapper = new ObjectMapper();
            File output = new File("data/stations.json");
            mapper.writeValue(output, stationsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

