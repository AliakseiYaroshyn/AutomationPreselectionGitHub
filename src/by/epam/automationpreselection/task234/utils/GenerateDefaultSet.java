package by.epam.automationpreselection.task234.utils;

import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.CargoAirCraftDataSource;
import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.PassengerAirCraftDataSource;
import by.epam.automationpreselection.task234.aircrafttypes.CargoAirCraftDefault;
import by.epam.automationpreselection.task234.aircrafttypes.PassengerAirCraftTypeDefault;

import java.util.HashMap;
import java.util.Map;

public class GenerateDefaultSet {
    public Map generateDefaultCargoSet() {
        HashMap<Integer,CargoAirCraftDefault> defaultCargoAirCraftSet = new HashMap<>();
        //declaration of a CargoAirCraftDataSource class object to get number of initial cargo air crafts
        CargoAirCraftDataSource cargoAirCraftDataSource = new CargoAirCraftDataSource();
        // iterate through CargoAirCraftDataSource, create default cargo air craft, add cargo air craft to default cargo air crafts collection
        for (int i = 0; i < cargoAirCraftDataSource.getTotalDefaultCargoAirCraft(); i++) {
            CargoAirCraftDefault cargoAirCraft = new CargoAirCraftDefault(i);
            defaultCargoAirCraftSet.put(i+1,cargoAirCraft);

        }
        return defaultCargoAirCraftSet;
    }
    public Map generateDefaultPassengerSet() {
        HashMap<Integer,PassengerAirCraftTypeDefault> defaultPassengerAircraftSet = new HashMap<>();
        PassengerAirCraftDataSource passengerAirCraftDataSource = new PassengerAirCraftDataSource();
        for (int i = 0; i < passengerAirCraftDataSource.getTotalDefaultPassengerAirCraft(); i++) {
            PassengerAirCraftTypeDefault passengerAirCraft = new PassengerAirCraftTypeDefault(i);
            defaultPassengerAircraftSet.put(i+1,passengerAirCraft);

        }
        return defaultPassengerAircraftSet;
    }
}
