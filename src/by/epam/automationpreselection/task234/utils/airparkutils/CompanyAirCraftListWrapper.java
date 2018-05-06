package by.epam.automationpreselection.task234.utils.airparkutils;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name="companyAirPark")
@XmlAccessorType(XmlAccessType.FIELD)

public class CompanyAirCraftListWrapper {
    private ArrayList<CompanyAirCraft> companyAirCraft;

    public CompanyAirCraftListWrapper(){
        companyAirCraft = new ArrayList<>();
    }

    public List<CompanyAirCraft> getTheWrappedCollection(){
        return companyAirCraft;
    }
    public void setTheWrappedCollection(ArrayList<CompanyAirCraft> companyAirCraft){
        this.companyAirCraft=companyAirCraft;
    }
}
