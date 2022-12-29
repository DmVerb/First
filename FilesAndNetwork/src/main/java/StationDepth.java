public class StationDepth {
    String name;
    double depth;

    public StationDepth (String name, double depth) {
        this.name = name;
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "StationDepth{" +
                "name='" + name + '\'' +
                ", depth=" + depth +
                '}';
    }
}
