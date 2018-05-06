package by.epam.automationpreselection.task234.aircraftdatasource.outputdatatask34;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirCompanyParkFileWriter {

    public void writeAirCompanyParkToFile(List<CompanyAirCraft> companyAirPark) throws IOException {
        String txtFilePath = "files\\initialcompanypark\\SkyDreamerJetCompanyPark.txt";
        Path filepath = Paths.get(txtFilePath);
        Files.deleteIfExists(filepath);
        try (OutputStream output = new FileOutputStream(String.valueOf(filepath))) {
            for (CompanyAirCraft companyAirCraft : companyAirPark) {
                output.write(companyAirCraft.toString().getBytes());
                output.write("\r\n".getBytes());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AirCompanyParkFileWriter.class
                    .getName()).log(Level.SEVERE, "writeAirCompanyParkToFile threw FileNotFoundException", ex);
        } catch (IOException ex) {
            Logger.getLogger(AirCompanyParkFileWriter.class
                    .getName()).log(Level.SEVERE, "writeAirCompanyParkToFile threw IOException", ex);
        }
    }
}
