package by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity;

import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.PassengerAirCraftDataSource;

public class PassengerCraftCapacity extends AirCraftCapacity {
    PassengerAirCraftDataSource passengerAirCraft = new PassengerAirCraftDataSource();

    public PassengerCraftCapacity(int airCraftCapacityVolume, int airCraftCapacityPassengers) {
        super(airCraftCapacityVolume, airCraftCapacityPassengers);
    }

    public PassengerCraftCapacity(int randomPassDataIndex) {
        super(randomPassDataIndex);
        this.airCraftCapacityVolume = generateAirCraftCapacityVolume(randomPassDataIndex);
        this.airCraftCapacityPassengers = generateAirCraftCapacityPassengers(randomPassDataIndex);
    }

    public PassengerCraftCapacity(){}

    private int generateAirCraftCapacityVolume (int randomPassDataIndex){
        return passengerAirCraft.getAirCraftCargoCapacity(randomPassDataIndex);
    }

    private int generateAirCraftCapacityPassengers (int randomPassDataIndex) {
        return passengerAirCraft.getAirCraftPassengerCapacity(randomPassDataIndex);
    }

    @Override
    public String toString()
    {
        return this.airCraftCapacityVolume+"|"+this.airCraftCapacityPassengers;
    }

    @Override
    public int getAirCraftCapacityVolume() {
        return this.airCraftCapacityVolume;
    }

    public int getPassCapacityPassengers() {
        return this.airCraftCapacityPassengers;
    }
}
