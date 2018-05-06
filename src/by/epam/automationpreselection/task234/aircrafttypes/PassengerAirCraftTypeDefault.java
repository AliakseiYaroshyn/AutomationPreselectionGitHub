package by.epam.automationpreselection.task234.aircrafttypes;

import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.PassengerAirCraftDataSource;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.PassengerAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.AirCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.PassengerCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.AirCraftMaxDistance;

import static java.lang.System.*;

public class PassengerAirCraftTypeDefault extends AirCraftTypeDefault {
    private static final String PASSENGER = staticAirCraftType.PASSENGER.toString();
    protected String defaultAirCraftSubName;
    protected String defaultAirCraftProductName;
    protected String defaultAirCraftType;
    protected AirCraftMaxDistance defaultAirCraftMaxDistance;
    protected PassengerCraftCapacity defaultAirCraftCapacity;
    private PassengerAirCraftDataSource defaultPassengerAirCraft = new PassengerAirCraftDataSource();

    public PassengerAirCraftTypeDefault(String airCraftSubName, String airCraftProductName, String airCraftType,
                                AirCraftMaxDistance airCraftMaxDistance, AirCraftCapacity airCraftCapacity)
    {
        super(airCraftSubName,airCraftProductName,airCraftType,airCraftMaxDistance,airCraftCapacity);
    }

    public PassengerAirCraftTypeDefault (){}
    public PassengerAirCraftTypeDefault (int randomPassDataIndex) {
        super(randomPassDataIndex);
        this.airCraftSubName = defaultPassengerAirCraft.getAirCraftSubName(randomPassDataIndex);
        this.airCraftProductName = defaultPassengerAirCraft.getAirCraftProductName(randomPassDataIndex);
        this.airCraftType = PASSENGER;
        this.airCraftMaxDistance = new PassengerAirCraftMaxDistance(randomPassDataIndex);
        this.airCraftCapacity = new PassengerCraftCapacity(randomPassDataIndex);
    }

    @Override
    public String toString()
    {
        return this.airCraftSubName + "|" + this.airCraftProductName + "|" +
                this.airCraftType + "|" + this.airCraftMaxDistance.toString() + "|" + this.airCraftCapacity.toString();
    }
    @Override
    public void printAirCraftData() {
        out.println(toString());
    }
}
