package by.epam.automationpreselection.task234.utils.airparkutils;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import by.epam.automationpreselection.task234.aircrafttypes.PassengerAirCraftTypeDefault;
import by.epam.automationpreselection.task234.aircrafttypes.CargoAirCraftDefault;
import by.epam.automationpreselection.task234.utils.GenerateDefaultSet;
import java.util.*;

import static java.lang.System.*;

public class GenerateAirPark {
    public List generateAirPark(int totalAirCrafts) {
        GenerateDefaultSet defaultSet = new GenerateDefaultSet();
        Map<Integer, PassengerAirCraftTypeDefault> defaultPassengerSet = defaultSet.generateDefaultPassengerSet();
        Map<Integer, CargoAirCraftDefault> defaultCargoSet = defaultSet.generateDefaultCargoSet();
        ArrayList<CompanyAirCraft> airCompanyPark = new ArrayList<>();
        Random randomize = new Random();
        long startTime = currentTimeMillis();
        for (int i = 1; i <= totalAirCrafts; i++) {
            int randomCargoSetIndex = 1 + randomize.nextInt(defaultCargoSet.size() - 1);
            int randomPassSetIndex = 1 + randomize.nextInt(defaultPassengerSet.size() - 1);
            if (i % 3 == 0) {
                CompanyAirCraft companyAirCraft = new CompanyAirCraft(i, defaultCargoSet.get(randomCargoSetIndex));
                airCompanyPark.add(companyAirCraft);
            } else {
                CompanyAirCraft companyAirCraft = new CompanyAirCraft(i, defaultPassengerSet.get(randomPassSetIndex));
                airCompanyPark.add(companyAirCraft);
            }
        }
        long runTime = currentTimeMillis() - startTime;
        out.println("Time to create an ArrayList with " + totalAirCrafts + " air crafts is: " + runTime);
        return airCompanyPark;
    }

    public List generateAirParkLinkedList(int totalAirCrafts) {
        GenerateDefaultSet defaultSet = new GenerateDefaultSet();
        Map<Integer, PassengerAirCraftTypeDefault> defaultPassengerSet = defaultSet.generateDefaultPassengerSet();
        Map<Integer, CargoAirCraftDefault> defaultCargoSet = defaultSet.generateDefaultCargoSet();
        LinkedList<CompanyAirCraft> airCompanyPark = new LinkedList<>();
        Random randomize = new Random();
        long startTime = currentTimeMillis();
        for (int i = 1; i <= totalAirCrafts; i++) {
            int randomCargoSetIndex = 1 + randomize.nextInt(defaultCargoSet.size() - 1);
            int randomPassSetIndex = 1 + randomize.nextInt(defaultPassengerSet.size() - 1);
            if (i % 3 == 0) {
                CompanyAirCraft companyAirCraft = new CompanyAirCraft(i, defaultCargoSet.get(randomCargoSetIndex));
                airCompanyPark.add(companyAirCraft);
            } else {
                CompanyAirCraft companyAirCraft = new CompanyAirCraft(i, defaultPassengerSet.get(randomPassSetIndex));
                airCompanyPark.add(companyAirCraft);
            }
        }
        long runTime = currentTimeMillis() - startTime;
        out.println("Time to create a LinkedList with " + totalAirCrafts + " air crafts is: " + runTime);
        return airCompanyPark;
    }
}

