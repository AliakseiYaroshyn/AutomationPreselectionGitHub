package by.epam.automationpreselection.task234.utils.airparkutils;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class SortAirPark {
    public List<CompanyAirCraft> sortAirParkByMaxDistanceDesc (List<CompanyAirCraft> airCompanyPark) {
        List<CompanyAirCraft> sortedAirCompanyPark = new ArrayList<>();
        sortedAirCompanyPark.addAll(0,airCompanyPark);
        long startTime = currentTimeMillis();
        sortedAirCompanyPark.sort((o1, o2) -> {
            if (o1.getExactMaxDistanceKm() == o2.getExactMaxDistanceKm()) return 0;
            else if (o1.getExactMaxDistanceKm() > o2.getExactMaxDistanceKm()) return -1;
            else return 1;
        });
        long runTime = currentTimeMillis() - startTime;
        out.println("Time to sort " + sortedAirCompanyPark.getClass().getName() + " with " + sortedAirCompanyPark.size() + " air crafts is: " + runTime);
        out.println("Sorted list by maximum coverable distance from high to low:");
        return sortedAirCompanyPark;
    }

    public List<CompanyAirCraft> sortAirParkByMaxDistanceAsc (List<CompanyAirCraft> airCompanyPark) {
        List<CompanyAirCraft> sortedAirCompanyPark = new ArrayList<>();
        sortedAirCompanyPark.addAll(0,airCompanyPark);
        long startTime = currentTimeMillis();
        sortedAirCompanyPark.sort((o1, o2) -> {
            if (o1.getExactMaxDistanceKm() == o2.getExactMaxDistanceKm()) return 0;
            else if (o1.getExactMaxDistanceKm() > o2.getExactMaxDistanceKm()) return 1;
            else return -1;
        });
        long runTime = currentTimeMillis() - startTime;
        out.println("Time to sort " + sortedAirCompanyPark.getClass().getName() + " with " + sortedAirCompanyPark.size() + " air crafts is: " + runTime);
        out.println("Sorted list by maximum coverable distance from low to high:");
        return sortedAirCompanyPark;
        }
    }

