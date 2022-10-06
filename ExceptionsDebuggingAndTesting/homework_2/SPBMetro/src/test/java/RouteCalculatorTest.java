import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "Выхинская");
        Line line2 = new Line(2, "Салатовая");
        Line line3 = new Line(3, "Новогиреевская");

        Station l1s1 = new Station("Пролетарская", line1);
        Station l1s2 = new Station("Волгоградка", line1);
        Station l1s3 = new Station("Текстильщики", line1);
        Station l2s1 = new Station("Крестьянская застава", line2);
        Station l2s2 = new Station("Ещё", line2);
        Station l2s3 = new Station("Римская", line2);
        Station l3s1 = new Station("Шосики", line3);
        Station l3s2 = new Station("Авиамоторная", line3);
        Station l3s3 = new Station("Площадь Ильича", line3);

        line1.addStation(l1s1);        line1.addStation(l1s2);        line1.addStation(l1s3);
        line2.addStation(l2s1);        line2.addStation(l2s2);        line2.addStation(l2s3);
        line3.addStation(l3s1);        line3.addStation(l3s2);        line3.addStation(l3s3);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(l1s1);        stationIndex.addStation(l1s2);        stationIndex.addStation(l1s3);
        stationIndex.addStation(l2s1);        stationIndex.addStation(l2s2);        stationIndex.addStation(l2s3);
        stationIndex.addStation(l3s1);        stationIndex.addStation(l3s2);        stationIndex.addStation(l3s3);

        List<Station> connectionStationOne = new ArrayList<>();
        connectionStationOne.add(stationIndex.getStation("Пролетарская"));
        connectionStationOne.add(stationIndex.getStation("Крестьянская застава"));
        List<Station> connectionStationTwo = new ArrayList<>();
        connectionStationTwo.add(stationIndex.getStation("Римская"));
        connectionStationTwo.add(stationIndex.getStation("Площадь Ильича"));

        stationIndex.addConnection(connectionStationOne);
        stationIndex.addConnection(connectionStationTwo);

        route.add(new Station("Текстильщики", line1));
        route.add(new Station("Волгоградка", line1));
        route.add(new Station("Пролетарская", line1));
        route.add(new Station("Крестьянская застава", line2));
    }


    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expect = 8.5;
        assertEquals(expect, actual);
    }

    public void testGetShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Пролетарская"),
                stationIndex.getStation("Текстильщики"));
        List<Station> expect = List.of(stationIndex.getStation("Пролетарская"),
                stationIndex.getStation("Волгоградка"),
                stationIndex.getStation("Текстильщики"));
        System.out.println(expect);
        System.out.println(actual);
        assertEquals(expect, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Пролетарская"),
                stationIndex.getStation("Текстильщики"));
        List<Station> expect = List.of(stationIndex.getStation("Пролетарская"),
                stationIndex.getStation("Волгоградка"),
                stationIndex.getStation("Текстильщики"));
        System.out.println(expect);
        System.out.println(actual);
        assertEquals(expect, actual);
    }

    public  void testGetWithOneConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Текстильщики"),
                stationIndex.getStation("Римская"));
        List<Station> expect = List.of(stationIndex.getStation("Текстильщики"),
                stationIndex.getStation("Волгоградка"),
                stationIndex.getStation("Пролетарская"),
                stationIndex.getStation("Крестьянская застава"),
                stationIndex.getStation("Ещё"),
                stationIndex.getStation("Римская"));
        System.out.println(expect);
        System.out.println(actual);
        assertEquals(expect, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Текстильщики"),
                stationIndex.getStation("Шосики"));
        List<Station> expect = List.of(stationIndex.getStation("Текстильщики"),
                stationIndex.getStation("Волгоградка"),
                stationIndex.getStation("Пролетарская"),
                stationIndex.getStation("Крестьянская застава"),
                stationIndex.getStation("Ещё"),
                stationIndex.getStation("Римская"),
                stationIndex.getStation("Площадь Ильича"),
                stationIndex.getStation("Авиамоторная"),
                stationIndex.getStation("Шосики"));
        System.out.println(expect);
        System.out.println(actual);
        assertEquals(expect, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
