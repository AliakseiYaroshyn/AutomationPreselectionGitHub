package by.epam.automationpreselection.task234.aircrafttypes;

import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.AirCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.AirCraftMaxDistance;

import javax.xml.bind.annotation.XmlType;

import static java.lang.System.*;
@XmlType(propOrder = {"airCraftSubName","airCraftProductName","airCraftType","airCraftMaxDistance","airCraftCapacity"}, name = "airCraftMaxDistance")
public abstract class AirCraftTypeDefault {
    String airCraftSubName;
    String airCraftProductName;
    String airCraftType;
    AirCraftMaxDistance airCraftMaxDistance;
    AirCraftCapacity airCraftCapacity;
    AirCraftTypeDefault companyAirCraft;

    public AirCraftTypeDefault(){}

    public AirCraftTypeDefault(String airCraftSubName, String airCraftProductName, String airCraftType, AirCraftMaxDistance airCraftMaxDistance, AirCraftCapacity airCraftCapacity){
        this.airCraftSubName = airCraftSubName;
        this.airCraftProductName = airCraftProductName;
        this.airCraftType = airCraftType;
        this.airCraftMaxDistance = airCraftMaxDistance;
        this.airCraftCapacity = airCraftCapacity;
    }

    public AirCraftTypeDefault (int randomDataIndex) {}

    @Override
    public String toString()
    {
        return this.airCraftSubName + "|" + this.airCraftProductName + "|" +
                this.airCraftType + "|" + this.airCraftMaxDistance.toString() + "|" + this.airCraftCapacity.toString();
    }
    public void printAirCraftData() {
        out.println(toString());
    }

    public String getAirCraftSubName() {
        return airCraftSubName;
    }
    public void setAirCraftSubName(String airCraftSubName){
        this.airCraftSubName = airCraftSubName;
    }

    public String getAirCraftProductName() {
        return airCraftProductName;
    }
    public void setAirCraftProductName(String airCraftProductName){this.airCraftProductName = airCraftProductName;}

    public String getAirCraftType() {
        return airCraftType;
    }
    public void setAirCraftType (String airCraftType) {this.airCraftType = airCraftType;}

    public AirCraftMaxDistance getAirCraftMaxDistance() {
        return airCraftMaxDistance;
    }
    public void setAirCraftMaxDistance (AirCraftMaxDistance airCraftMaxDistance){this.airCraftMaxDistance = airCraftMaxDistance;}

    public AirCraftCapacity getAirCraftCapacity() {
        return airCraftCapacity;
    }
    public void setAirCraftCapacity (AirCraftCapacity airCraftCapacity){this.airCraftCapacity = airCraftCapacity;}
}
