package by.epam.automationpreselection.task234.utils.airparkutils;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import java.util.List;
import static java.lang.System.*;

public class CalculateCapacity {
    public int calculateTotalParkPassengerCapacity (List<CompanyAirCraft> airCompanyPark) {
        int totalParkPassengerCapacity = 0;
        for (CompanyAirCraft anAirCompanyPark: airCompanyPark) {
            totalParkPassengerCapacity = totalParkPassengerCapacity + anAirCompanyPark.getExactCapacityPassengers();
        }
        out.println("Total air park passenger capacity: " + totalParkPassengerCapacity);
        return totalParkPassengerCapacity;

    }

    public double calculateTotalParkCapacityTons (List<CompanyAirCraft> airCompanyPark){
        double totalParkCargoCapacityTons = 0;
        for (CompanyAirCraft anAirCompanyPark: airCompanyPark) {
            totalParkCargoCapacityTons = totalParkCargoCapacityTons + anAirCompanyPark.getExactCapacityTons();
        }
        out.println("Total air park cargo capacity (tons): " + totalParkCargoCapacityTons);
        return totalParkCargoCapacityTons;
    }

    public int calculateTotalParkCapacityVolume (List<CompanyAirCraft> airCompanyPark) {
        int totalParkCargoCapacityVolume = 0;
        for (CompanyAirCraft anAirCompanyPark: airCompanyPark) {
            totalParkCargoCapacityVolume = totalParkCargoCapacityVolume + anAirCompanyPark.getExactCapacityVolume();
        }
        out.println("Total air park cargo capacity (kub.m.): " + totalParkCargoCapacityVolume);
        return totalParkCargoCapacityVolume;
    }
}
