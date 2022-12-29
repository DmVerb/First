public class Station {
    String name;
    boolean hasConnection = false;
    String numberLine;

    public Station(String name, String numberLine) {
        this.name = name;
        this.numberLine = numberLine;
    }

    public Station(String name, String numberLine, boolean hasConnection) {
        this.name = name;
        this.numberLine = numberLine;
        this.hasConnection = hasConnection;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", hasConnection=" + hasConnection +
                ", numberLine='" + numberLine + '\'' +
                '}';
    }
}
