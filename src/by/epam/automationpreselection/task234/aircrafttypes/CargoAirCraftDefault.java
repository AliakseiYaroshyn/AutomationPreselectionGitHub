package by.epam.automationpreselection.task234.aircrafttypes;

import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.AirCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.CargoCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.AirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.CargoAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.CargoAirCraftDataSource;

import static java.lang.System.*;

public class CargoAirCraftDefault extends AirCraftTypeDefault {
    private static final String CARGO = staticAirCraftType.CARGO.toString();
    protected String defaultAirCraftSubName;
    protected String defaultAirCraftProductName;
    protected String defaultAirCraftType;
    protected AirCraftMaxDistance defaultAirCraftMaxDistance;
    protected CargoCraftCapacity defaultAirCraftCapacity;
    private CargoAirCraftDataSource defaultCargoAirCraft = new CargoAirCraftDataSource();

    public CargoAirCraftDefault(String airCraftSubName, String airCraftProductName, String airCraftType, AirCraftMaxDistance airCraftMaxDistance, AirCraftCapacity airCraftCapacity){
        super(airCraftSubName,airCraftProductName,airCraftType,airCraftMaxDistance,airCraftCapacity);
    }


    public CargoAirCraftDefault(int randomCargoDataIndex) {
        super(randomCargoDataIndex);
        this.airCraftSubName = defaultCargoAirCraft.getAirCraftSubName(randomCargoDataIndex);
        this.airCraftProductName = defaultCargoAirCraft.getAirCraftProductName(randomCargoDataIndex);
        this.airCraftType = CARGO;
        this.airCraftMaxDistance = new CargoAirCraftMaxDistance(randomCargoDataIndex);
        this.airCraftCapacity = new CargoCraftCapacity(randomCargoDataIndex);
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
