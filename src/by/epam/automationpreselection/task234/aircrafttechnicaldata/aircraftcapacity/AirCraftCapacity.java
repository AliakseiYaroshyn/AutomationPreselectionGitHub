package by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"airCraftCapacityVolume","airCraftCapacityTons","airCraftCapacityPassengers"}, name = "exactAirCraftCapacity")

public class AirCraftCapacity {

    int airCraftCapacityVolume;
    double airCraftCapacityTons;
    int airCraftCapacityPassengers;

    public AirCraftCapacity(int airCraftCapacityVolume, double airCraftCapacityTons) {
        this.airCraftCapacityVolume = airCraftCapacityVolume;
        this.airCraftCapacityTons = airCraftCapacityTons;
    }

    public AirCraftCapacity(int airCraftCapacityVolume, int airCraftCapacityPassengers) {
        this.airCraftCapacityVolume = airCraftCapacityVolume;
        this.airCraftCapacityPassengers = airCraftCapacityPassengers;
    }

    public AirCraftCapacity(int randomDataIndex) {}

    public AirCraftCapacity(){}


    public int getAirCraftCapacityVolume(){ return airCraftCapacityVolume; }
    public void setAirCraftCapacityVolume(int airCraftCapacityVolume){this.airCraftCapacityVolume = airCraftCapacityVolume;}

    public int getAirCraftCapacityPassengers() {
        return airCraftCapacityPassengers;
    }
    public void setAirCraftCapacityPassengers (int airCraftCapacityPassengers){this.airCraftCapacityPassengers = airCraftCapacityPassengers;}

    public double getAirCraftCapacityTons() {
        return airCraftCapacityTons;
    }
    public void setAirCraftCapacityTons(double airCraftCapacityTons){this.airCraftCapacityTons = airCraftCapacityTons;}
}

