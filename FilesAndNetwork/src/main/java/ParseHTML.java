import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ParseHTML {
    String nameWeb;

    public ParseHTML(String nameWeb) {
        this.nameWeb = nameWeb;
    }

    public String getNameWeb() {
        return nameWeb;
    }

    public void setNameWeb(String nameWeb) {
        this.nameWeb = nameWeb;
    }

    public void parseToFile(String fileName) {
        try {
            Document doc = Jsoup.connect(getNameWeb()).get();
            PrintWriter writer = new PrintWriter(fileName);
            writer.write(doc.toString());
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Line> addLine() {
        ArrayList<Line> lines = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(getNameWeb()).get();
            Elements elements = doc.select(".js-metro-line");
            elements.forEach(e ->
                    lines.add(new Line(e.attr("data-line"), e.text())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }


    public ArrayList<Station> addStation() {
        ArrayList<Station> stations = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(getNameWeb()).get();
            Elements elements = doc.select("div.js-metro-stations ");
            elements.forEach(element -> element.children().forEach(s -> {
                if (s.childNodeSize() > 2) {
                    stations.add(new Station(s.text().replaceAll("[0-9.]", "").trim(), element.attr("data-line"), true));
                } else
                    stations.add(new Station(s.text().replaceAll("[0-9.]", "").trim(), element.attr("data-line")));
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }


    @Override
    public String toString() {
        return "Parse{" +
                "nameWeb='" + nameWeb + '\'' +
                '}';
    }
}
