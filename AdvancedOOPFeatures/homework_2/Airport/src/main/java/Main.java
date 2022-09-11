import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals()
                .stream()
                .flatMap(terminal -> terminal.getFlights().stream().filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE)))
                .filter(flight -> flight.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().isBefore(LocalTime.now().plusHours(2)))
                .collect(Collectors.toList());     //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
    }

}