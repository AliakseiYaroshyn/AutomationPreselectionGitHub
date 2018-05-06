package by.epam.automationpreselection.task234.aircraftdatasource.inputdatatask34;

import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.CargoCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.PassengerCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.CargoAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.PassengerAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttypes.CargoAirCraftDefault;
import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import by.epam.automationpreselection.task234.aircrafttypes.PassengerAirCraftTypeDefault;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirCompanyParkFileReader implements GetAirCraftExactData {
    private static final String FILEPATH = "files\\initialcompanypark\\SkyDreamerJetCompanyPark.txt";
    private String[] exactAirCraftRow;
    private List<CompanyAirCraft> companyAirParkFromFile = new ArrayList<>();

    public List<CompanyAirCraft> readAirCompanyParkFromFile() throws IOException{
        try {FileInputStream fstream = new FileInputStream(FILEPATH);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fstream))) {
                String companyAirCraftDataRow;
                while ((companyAirCraftDataRow = bufferedReader.readLine()) != null) {
                    exactAirCraftRow = companyAirCraftDataRow.split("\\|", -1);
                    CompanyAirCraft companyAirCraft;
                    String s = getAirCraftType();
                    if (s.equals("CARGO")) {
                        CargoAirCraftMaxDistance cargoAirCraftMaxDistance = new CargoAirCraftMaxDistance(getMaxDistanceCovered(), getAirCraftMaxDistanceType());
                        CargoCraftCapacity cargoCraftCapacity = new CargoCraftCapacity(getAirCraftCargoCapacity(), getAirCraftCapacitiesTons());
                        CargoAirCraftDefault cargoAirCraft = new CargoAirCraftDefault(getAirCraftSubName(), getAirCraftProductName(), getAirCraftType(), cargoAirCraftMaxDistance, cargoCraftCapacity);
                        companyAirCraft = new CompanyAirCraft(getAirCraftID(), cargoAirCraft);
                        companyAirParkFromFile.add(companyAirCraft);
                    } else if (s.equals("PASSENGER")) {
                        PassengerAirCraftMaxDistance passengerAirCraftMaxDistance = new PassengerAirCraftMaxDistance(getMaxDistanceCovered(), getAirCraftMaxDistanceType());
                        PassengerCraftCapacity passengerCraftCapacity = new PassengerCraftCapacity(getAirCraftCargoCapacity(), getAirCraftPassengerCapacity());
                        PassengerAirCraftTypeDefault passengerAirCraft = new PassengerAirCraftTypeDefault(getAirCraftSubName(), getAirCraftProductName(), getAirCraftType(), passengerAirCraftMaxDistance, passengerCraftCapacity);
                        companyAirCraft = new CompanyAirCraft(getAirCraftID(), passengerAirCraft);
                        companyAirParkFromFile.add(companyAirCraft);
                    }
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(AirCompanyParkFileReader.class
                    .getName()).log(Level.SEVERE, "Error reading from ..\\"+ FILEPATH, ex);
        }
        return companyAirParkFromFile;
    }

    @Override
    public String getAirCraftID() {
        return exactAirCraftRow[0];
    }

    @Override
    public String getAirCraftSubName() {
        return exactAirCraftRow[1];
    }

    @Override
    public String getAirCraftProductName() {
        return exactAirCraftRow[2];
    }

    @Override
    public String getAirCraftType() {
        return exactAirCraftRow[3];
    }

    @Override
    public int getMaxDistanceCovered() {
        return Integer.parseInt(exactAirCraftRow[4]);
    }
    @Override
    public String getAirCraftMaxDistanceType() {
        return exactAirCraftRow[5];
    }

    @Override
    public int getAirCraftCargoCapacity() {
        return Integer.parseInt(exactAirCraftRow[6]);
    }

    @Override
    public double getAirCraftCapacitiesTons() {
        if (getAirCraftType().equals("CARGO")) {
            return Double.parseDouble(exactAirCraftRow[7]);
        }
        else return 0;
    }

    @Override
    public int getAirCraftPassengerCapacity() {
        if (getAirCraftType().equals("PASSENGER")) {
            return Integer.parseInt(exactAirCraftRow[7]);
        }
        else return 0;
    }
}

