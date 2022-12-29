import java.text.SimpleDateFormat;
import java.util.Date;

public class StationDate {
    String name;
    Date date;

    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");


    public StationDate(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return formater.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StationDate{" +
                "name='" + name + '\'' +
                ", date=" + formater.format(date) +
                '}';
    }
}
