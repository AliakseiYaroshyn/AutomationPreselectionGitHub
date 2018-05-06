package by.epam.automationpreselection.task234.aircraftdatasource.inputdatatask34;

import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.CargoCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.PassengerCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.CargoAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.PassengerAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttypes.CargoAirCraftDefault;
import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import by.epam.automationpreselection.task234.aircrafttypes.PassengerAirCraftTypeDefault;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirCompanyParkXmlReader implements GetAirCraftExactData{
    private Element element;
    private static final String FILEPATH = "files\\initialcompanypark\\SkyDreamerJetCompanyPark.xml";
    private List<CompanyAirCraft> companyAirParkFromXml = new ArrayList<>();

    public List<CompanyAirCraft> readCompanyAirParkFromXml() {
        try {
            final File xmlFile = new File(FILEPATH);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("companyAirCraft");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                element = (Element) node;
                CompanyAirCraft companyAirCraft;
                if (getAirCraftType().equals("CARGO")) {
                    CargoAirCraftMaxDistance cargoAirCraftMaxDistance = new CargoAirCraftMaxDistance(getMaxDistanceCovered(), getAirCraftMaxDistanceType());
                    CargoCraftCapacity cargoCraftCapacity = new CargoCraftCapacity(getAirCraftCargoCapacity(), getAirCraftCapacitiesTons());
                    CargoAirCraftDefault cargoAirCraft = new CargoAirCraftDefault(getAirCraftSubName(), getAirCraftProductName(), getAirCraftType(), cargoAirCraftMaxDistance, cargoCraftCapacity);
                    companyAirCraft = new CompanyAirCraft(getAirCraftID(), cargoAirCraft);
                    companyAirParkFromXml.add(companyAirCraft);
                } else if (getAirCraftType().equals("PASSENGER")) {
                    PassengerAirCraftMaxDistance passengerAirCraftMaxDistance = new PassengerAirCraftMaxDistance(getMaxDistanceCovered(), getAirCraftMaxDistanceType());
                    PassengerCraftCapacity passengerCraftCapacity = new PassengerCraftCapacity(getAirCraftCargoCapacity(), getAirCraftPassengerCapacity());
                    PassengerAirCraftTypeDefault passengerAirCraft = new PassengerAirCraftTypeDefault(getAirCraftSubName(), getAirCraftProductName(), getAirCraftType(), passengerAirCraftMaxDistance, passengerCraftCapacity);
                    companyAirCraft = new CompanyAirCraft(getAirCraftID(), passengerAirCraft);
                    companyAirParkFromXml.add(companyAirCraft);
                }
            }
        } catch (ParserConfigurationException | SAXException
                | IOException ex) {
            Logger.getLogger(AirCompanyParkXmlReader.class.getName())
                    .log(Level.SEVERE, "readCompanyAirParkFromXml threw ", ex);
        }
        return companyAirParkFromXml;
    }

    @Override
    public String getAirCraftID() {
        return element.getElementsByTagName("companyAirCraftID").item(0).getTextContent();
    }

    @Override
    public String getAirCraftSubName() {
        return element.getElementsByTagName("airCraftSubName").item(0).getTextContent();
    }

    @Override
    public String getAirCraftProductName() {
        return element.getElementsByTagName("airCraftProductName").item(0).getTextContent();
    }

    @Override
    public String getAirCraftType() {
        return element.getElementsByTagName("airCraftType").item(0).getTextContent();
    }

    @Override
    public String getAirCraftMaxDistanceType() {
        return element.getElementsByTagName("airCraftMaxDistanceType").item(0).getTextContent();
    }

    @Override
    public int getAirCraftCargoCapacity() {
        return Integer.parseInt(element.getElementsByTagName("airCraftCapacityVolume").item(0).getTextContent());
    }

    @Override
    public double getAirCraftCapacitiesTons() {
        return Double.parseDouble(element.getElementsByTagName("airCraftCapacityTons").item(0).getTextContent());
    }

    @Override
    public int getAirCraftPassengerCapacity() {
        return Integer.parseInt(element.getElementsByTagName("airCraftCapacityPassengers").item(0).getTextContent());
    }

    @Override
    public int getMaxDistanceCovered() {
        return Integer.parseInt(element.getElementsByTagName("airCraftMaxDistanceKm").item(0).getTextContent());
    }
}
