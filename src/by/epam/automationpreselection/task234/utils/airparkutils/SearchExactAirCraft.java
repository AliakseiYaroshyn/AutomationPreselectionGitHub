package by.epam.automationpreselection.task234.utils.airparkutils;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.in;

public class SearchExactAirCraft {

    public void searchExactAirCraftById(List<CompanyAirCraft> airCompanyPark) {
        Scanner scanner = new Scanner(in);
        CompanyAirCraft airCraftFound = null;
        out.print("Please enter ID to search: ");
        String airCraftIDToSearch = scanner.nextLine();
        for (CompanyAirCraft iterateAirCraft : airCompanyPark) {
            if (iterateAirCraft.getCompanyAirCraftID().equals(airCraftIDToSearch)) {
                airCraftFound = iterateAirCraft;
                break;
            }
        }
        if (airCraftFound == null) {out.println ("Air craft is not found");}
        else airCraftFound.printAirCraftData();
    }
}