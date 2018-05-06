package by.epam.automationpreselection.task234;

import by.epam.automationpreselection.task234.aircraftdatasource.inputdatatask34.AirCompanyParkFileReader;
import by.epam.automationpreselection.task234.aircraftdatasource.inputdatatask34.AirCompanyParkJdbcReader;
import by.epam.automationpreselection.task234.aircraftdatasource.inputdatatask34.AirCompanyParkXmlReader;
import by.epam.automationpreselection.task234.aircraftdatasource.outputdatatask34.AirCompanyParkFileWriter;
import by.epam.automationpreselection.task234.aircraftdatasource.outputdatatask34.AirCompanyParkJdbcWriter;
import by.epam.automationpreselection.task234.aircraftdatasource.outputdatatask34.AirCompanyParkXmlWriter;
import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import by.epam.automationpreselection.task234.utils.airparkutils.CalculateCapacity;
import by.epam.automationpreselection.task234.utils.airparkutils.GenerateAirPark;
import by.epam.automationpreselection.task234.utils.airparkutils.SearchExactAirCraft;
import by.epam.automationpreselection.task234.utils.airparkutils.SortAirPark;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

public class SkyDreamerJetCompanyTask234 {
    private static Scanner scanner = new Scanner(in);
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        List<CompanyAirCraft> skyDreamerJetCompanyPark;
        List<CompanyAirCraft> sortedSkyDreamerJetCompanyPark;
        List<CompanyAirCraft> skyDreamerJetCompanyParkFromFile;
        List<CompanyAirCraft> skyDreamerJetCompanyParkFromXml;
        List<CompanyAirCraft> skyDreamerJetCompanyParkFromDB;
        int totalAirCrafts;
        while(true){
            out.print("Please enter the total number of air crafts in SkyDreamerJetCompany to generate: ");
            try {
               totalAirCrafts = scanner.nextInt();
               break;
            }
            catch(InputMismatchException e){
               out.println("Incorrect value!");
               scanner.next();
            }
        }

        GenerateAirPark airParkGenerator = new GenerateAirPark();
        SearchExactAirCraft airCraftSearcher = new SearchExactAirCraft();
        CalculateCapacity calculateCapacity = new CalculateCapacity();

        // generating skyDreamerJetCompanyPark from static data
        airParkGenerator.generateAirParkLinkedList(totalAirCrafts);
        skyDreamerJetCompanyPark = airParkGenerator.generateAirPark(totalAirCrafts);
        for (CompanyAirCraft aSkyDreamerJetCompanyPark : skyDreamerJetCompanyPark) {
                aSkyDreamerJetCompanyPark.printAirCraftData();
        }

        SortAirPark airParkSorter = new SortAirPark();
        sortedSkyDreamerJetCompanyPark = airParkSorter.sortAirParkByMaxDistanceDesc(skyDreamerJetCompanyPark);
        for (CompanyAirCraft aSkyDreamerJetCompanyPark : sortedSkyDreamerJetCompanyPark) {
              aSkyDreamerJetCompanyPark.printAirCraftData();
        }
        // writing sortedSkyDreamerJetCompanyPark to txt file
        AirCompanyParkFileWriter airCompanyParkFileWriter = new AirCompanyParkFileWriter();
        airCompanyParkFileWriter.writeAirCompanyParkToFile(sortedSkyDreamerJetCompanyPark);

        calculateCapacity.calculateTotalParkPassengerCapacity(skyDreamerJetCompanyPark);
        calculateCapacity.calculateTotalParkCapacityTons(skyDreamerJetCompanyPark);
        calculateCapacity.calculateTotalParkCapacityVolume(skyDreamerJetCompanyPark);
        airCraftSearcher.searchExactAirCraftById(skyDreamerJetCompanyPark);

        // reading skyDreamerJetCompanyParkFromFile from txt file
        AirCompanyParkFileReader airCompanyParkFileReader = new AirCompanyParkFileReader();
        skyDreamerJetCompanyParkFromFile = airCompanyParkFileReader.readAirCompanyParkFromFile();
        out.println();
        out.println("SkyDreamerJetCompanyPark is read from TXT file");
        for (CompanyAirCraft aSkyDreamerJetCompanyPark : skyDreamerJetCompanyParkFromFile) {
            aSkyDreamerJetCompanyPark.printAirCraftData();
        }
        // writing skyDreamerJetCompanyParkFromFile to xml file
        AirCompanyParkXmlWriter  airCompanyParkXmlWriter = new AirCompanyParkXmlWriter();
        airCompanyParkXmlWriter.writeAirCompanyParkToXml((ArrayList<CompanyAirCraft>) skyDreamerJetCompanyParkFromFile);

        // reading skyDreamerJetCompanyParkFromXml from xml file
        AirCompanyParkXmlReader airCompanyParkXmlReader = new AirCompanyParkXmlReader();
        skyDreamerJetCompanyParkFromXml = airCompanyParkXmlReader.readCompanyAirParkFromXml();
        out.println();
        out.println("SkyDreamerJetCompanyPark is read from XML file");
        for (CompanyAirCraft aSkyDreamerJetCompanyPark:skyDreamerJetCompanyParkFromXml) {
            aSkyDreamerJetCompanyPark.printAirCraftData();
        }

        // writing skyDreamerJetCompanyPark to MySQL with JDBC
        AirCompanyParkJdbcWriter airCompanyParkJdbcWriter = new AirCompanyParkJdbcWriter();
        airCompanyParkJdbcWriter.writeAirCompanyParkToDB(skyDreamerJetCompanyPark);

        // reading skyDreamerJetCompanyParkFromXml from DB
        AirCompanyParkJdbcReader airCompanyParkJdbcReader = new AirCompanyParkJdbcReader();
        skyDreamerJetCompanyParkFromDB = airCompanyParkJdbcReader.readAirCompanyParkFromDB();
        out.println();
        out.println("SkyDreamerJetCompanyPark is read from DB");
        for (CompanyAirCraft aSkyDreamerJetCompanyPark:skyDreamerJetCompanyParkFromDB) {
            aSkyDreamerJetCompanyPark.printAirCraftData();
        }
    }
}

