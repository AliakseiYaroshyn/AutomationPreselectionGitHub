package by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance;

import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.CargoAirCraftDataSource;


public class CargoAirCraftMaxDistance extends AirCraftMaxDistance {

    private CargoAirCraftDataSource cargoAirCraft = new CargoAirCraftDataSource();

    public CargoAirCraftMaxDistance (int airCraftMaxDistance, String airCraftMaxDistanceType) {
        super(airCraftMaxDistance,airCraftMaxDistanceType);
    }

    public CargoAirCraftMaxDistance (int randomCargoDataIndex){
        this.airCraftMaxDistanceKm = generateAirCraftMaxDistance(randomCargoDataIndex);
        this.airCraftMaxDistanceType = super.calculateAirCraftMaxDistanceType(this.airCraftMaxDistanceKm);
    }

    @Override
    public int generateAirCraftMaxDistance(int randomCargoDataIndex) {
        return cargoAirCraft.getMaxDistanceCovered(randomCargoDataIndex);
    }
}
