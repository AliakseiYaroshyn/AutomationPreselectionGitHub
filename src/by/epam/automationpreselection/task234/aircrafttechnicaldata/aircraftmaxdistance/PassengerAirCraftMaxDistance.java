package by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance;

import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.PassengerAirCraftDataSource;

public class PassengerAirCraftMaxDistance extends AirCraftMaxDistance {

    private PassengerAirCraftDataSource passengerAirCraft = new PassengerAirCraftDataSource();

    public PassengerAirCraftMaxDistance (int airCraftMaxDistance, String airCraftMaxDistanceType) {
        super(airCraftMaxDistance,airCraftMaxDistanceType);
    }
    public PassengerAirCraftMaxDistance (int randomPassDataIndex){
        this.airCraftMaxDistanceKm = generateAirCraftMaxDistance(randomPassDataIndex);
        this.airCraftMaxDistanceType = super.calculateAirCraftMaxDistanceType(this.airCraftMaxDistanceKm);
    }

    @Override
    public int generateAirCraftMaxDistance(int randomPassDataIndex) {
        return passengerAirCraft.getMaxDistanceCovered(randomPassDataIndex);
    }
}
