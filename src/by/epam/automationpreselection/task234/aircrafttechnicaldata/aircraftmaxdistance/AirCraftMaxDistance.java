package by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"airCraftMaxDistanceKm","airCraftMaxDistanceType"}, name = "exactAirCraftMaxDistance")
public abstract class AirCraftMaxDistance implements CalculateAirCraftMaxDistance {
    int airCraftMaxDistanceKm;
    String airCraftMaxDistanceType;

    AirCraftMaxDistance(int airCraftMaxDistance, String airCraftMaxDistanceType) {
        this.airCraftMaxDistanceKm = airCraftMaxDistance;
        this.airCraftMaxDistanceType = airCraftMaxDistanceType;
    }

    public AirCraftMaxDistance (int randomCargoDataIndex){}

    public AirCraftMaxDistance() {}

    @Override
    public String calculateAirCraftMaxDistanceType(int staticAirCraftMaxDistance) {
        if (staticAirCraftMaxDistance > 0 && staticAirCraftMaxDistance <1500) {airCraftMaxDistanceType = "short-haul";}
            else if (staticAirCraftMaxDistance >=1500 && staticAirCraftMaxDistance < 4000) {airCraftMaxDistanceType= "medium-haul";}
                else if (staticAirCraftMaxDistance >= 4000 && staticAirCraftMaxDistance < 7000) {airCraftMaxDistanceType = "long-haul";}
                    else if (staticAirCraftMaxDistance >= 7000) {airCraftMaxDistanceType = "transcontinental";}
                        else {airCraftMaxDistanceType = "N/A";}

        return airCraftMaxDistanceType;
    }

    public int getAirCraftMaxDistanceKm() {
        return this.airCraftMaxDistanceKm;
    }
    public void setAirCraftMaxDistanceKm(int airCraftMaxDistanceKm){
        this.airCraftMaxDistanceKm = airCraftMaxDistanceKm;
    }

    public String getAirCraftMaxDistanceType() {
        return this.airCraftMaxDistanceType;
    }
    public void setAirCraftMaxDistanceType(String airCraftMaxDistanceType){
        this.airCraftMaxDistanceType = airCraftMaxDistanceType;
    }
    @Override
    public String toString()
    {
        return this.airCraftMaxDistanceKm + "|" + this.airCraftMaxDistanceType;
    }
}





