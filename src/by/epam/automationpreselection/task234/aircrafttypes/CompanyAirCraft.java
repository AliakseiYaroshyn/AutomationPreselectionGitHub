package by.epam.automationpreselection.task234.aircrafttypes;

import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.AirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.AirCraftCapacity;
import javax.xml.bind.annotation.XmlType;
import static java.lang.System.*;

@XmlType(propOrder = {"companyAirCraftID","companyAirCraftTypeDefault"}, name = "companyAirCraft")
public class CompanyAirCraft extends AirCraftTypeDefault{
    private String companyAirCraftID;
    private AirCraftTypeDefault companyAirCraftTypeDefault;

    public CompanyAirCraft(int totalSequence, CargoAirCraftDefault defaultAirCraft) {
        this.companyAirCraftID = generateAirCraftID(totalSequence);
        this.companyAirCraft = defaultAirCraft;
        this.airCraftSubName = defaultAirCraft.airCraftSubName;
        this.airCraftProductName = defaultAirCraft.airCraftProductName;
        this.airCraftType = defaultAirCraft.airCraftType;
        this.airCraftMaxDistance = defaultAirCraft.airCraftMaxDistance;
        this.airCraftCapacity = defaultAirCraft.airCraftCapacity;
    }

    public CompanyAirCraft(int totalSequence, PassengerAirCraftTypeDefault defaultAirCraft) {
        this.companyAirCraftID = generateAirCraftID(totalSequence);
        this.companyAirCraft = defaultAirCraft;
        this.airCraftSubName = defaultAirCraft.airCraftSubName;
        this.airCraftProductName = defaultAirCraft.airCraftProductName;
        this.airCraftType = defaultAirCraft.airCraftType;
        this.airCraftMaxDistance = defaultAirCraft.airCraftMaxDistance;
        this.airCraftCapacity = defaultAirCraft.airCraftCapacity;
    }
    public CompanyAirCraft (String airCraftID, CargoAirCraftDefault defaultAirCraft){
        this.companyAirCraftID = airCraftID;
        this.companyAirCraft = defaultAirCraft;
        this.airCraftSubName = defaultAirCraft.airCraftSubName;
        this.airCraftProductName = defaultAirCraft.airCraftProductName;
        this.airCraftType = defaultAirCraft.airCraftType;
        this.airCraftMaxDistance = defaultAirCraft.airCraftMaxDistance;
        this.airCraftCapacity = defaultAirCraft.airCraftCapacity;
    }
    public CompanyAirCraft (String airCraftID, PassengerAirCraftTypeDefault defaultAirCraft) {
        this.companyAirCraftID = airCraftID;
        this.companyAirCraft = defaultAirCraft;
        this.airCraftSubName = defaultAirCraft.airCraftSubName;
        this.airCraftProductName = defaultAirCraft.airCraftProductName;
        this.airCraftType = defaultAirCraft.airCraftType;
        this.airCraftMaxDistance = defaultAirCraft.airCraftMaxDistance;
        this.airCraftCapacity = defaultAirCraft.airCraftCapacity;
    }

    public CompanyAirCraft() {}

    private String generateAirCraftID(int totalSequence) {
        return "ID" + totalSequence;
    }

    @Override
    public String getAirCraftSubName() {
        return airCraftSubName;
    }

    @Override
    public String getAirCraftProductName() {
        return airCraftProductName;
    }

    @Override
    public String getAirCraftType() {
        return this.airCraftType;
    }

    @Override
    public AirCraftMaxDistance getAirCraftMaxDistance() {
        return this.airCraftMaxDistance;
    }

    public int getExactMaxDistanceKm(){
        return this.airCraftMaxDistance.getAirCraftMaxDistanceKm();
    }
    public String getExactMaxDistanceType() {
        return this.airCraftMaxDistance.getAirCraftMaxDistanceType();
    }

    @Override
    public AirCraftCapacity getAirCraftCapacity() {
        return airCraftCapacity;
    }
    public int getExactCapacityVolume() {
        return this.airCraftCapacity.getAirCraftCapacityVolume();
    }

    public int getExactCapacityPassengers(){
        try {
        return this.airCraftCapacity.getAirCraftCapacityPassengers();
        } catch (NullPointerException e) {
            return 0;
        }
    }
    public double getExactCapacityTons(){
        try {
            return this.airCraftCapacity.getAirCraftCapacityTons();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    @Override
    public String toString(){return companyAirCraftID + "|" + companyAirCraft;}

    @Override
    public void printAirCraftData() {
        try {
            out.println(toString());
        } catch (NullPointerException e) {
            out.println("Air craft is not found");
        }
    }
    public String getCompanyAirCraftID() {
        return companyAirCraftID;
    }
    public void setCompanyAirCraftID(String companyAirCraftID) {
        this.companyAirCraftID = companyAirCraftID;
    }

    public AirCraftTypeDefault getCompanyAirCraftTypeDefault() {
        return companyAirCraftTypeDefault;
    }

    public void setCompanyAirCraftTypeDefault(AirCraftTypeDefault companyAirCraftTypeDefault) {
        this.companyAirCraftTypeDefault = companyAirCraftTypeDefault;
    }

}