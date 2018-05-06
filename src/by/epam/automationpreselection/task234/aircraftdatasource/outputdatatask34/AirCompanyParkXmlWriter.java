package by.epam.automationpreselection.task234.aircraftdatasource.outputdatatask34;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import by.epam.automationpreselection.task234.utils.airparkutils.CompanyAirCraftListWrapper;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.*;


public class AirCompanyParkXmlWriter {

    public void writeAirCompanyParkToXml(ArrayList<CompanyAirCraft> companyAirPark) {
        String filepath = "files\\initialcompanypark\\SkyDreamerJetCompanyPark.xml";

        try {
            JAXBContext context = JAXBContext.newInstance(CompanyAirCraftListWrapper.class);
            CompanyAirCraftListWrapper listWrapper = new CompanyAirCraftListWrapper();
            listWrapper.setTheWrappedCollection(companyAirPark);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listWrapper,new FileOutputStream(filepath));

        } catch (JAXBException exception) {
            Logger.getLogger(AirCompanyParkXmlWriter.class.getName()).
                    log(Level.SEVERE, "writeAirCompanyParkToXml threw JAXBException", exception);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AirCompanyParkXmlWriter.class.getName()).log(Level.SEVERE, filepath + " is not found",ex);

        }
    }
}