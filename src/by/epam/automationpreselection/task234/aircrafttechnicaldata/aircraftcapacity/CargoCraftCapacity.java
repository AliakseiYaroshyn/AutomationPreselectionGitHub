package by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity;

import by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2.CargoAirCraftDataSource;

public class CargoCraftCapacity extends AirCraftCapacity {
    private CargoAirCraftDataSource cargoAirCraft = new CargoAirCraftDataSource();

    public CargoCraftCapacity(int airCraftCapacityVolume, double airCraftCapacityTons) {
        super(airCraftCapacityVolume,airCraftCapacityTons);
    }

    public CargoCraftCapacity (int randomCargoDataIndex){
        super(randomCargoDataIndex);
        this.airCraftCapacityVolume = generateAirCraftCapacityVolume(randomCargoDataIndex);
        this.airCraftCapacityTons = generateAirCraftCapacityTons(randomCargoDataIndex);
    }
    public CargoCraftCapacity(){}

   private int generateAirCraftCapacityVolume(int randomCargoDataIndex) {
        return cargoAirCraft.getAirCraftCargoCapacity(randomCargoDataIndex);
    }

    private double generateAirCraftCapacityTons(int randomCargoDataIndex) {
        return cargoAirCraft.getAirCraftCapacitiesTons(randomCargoDataIndex);
    }

    public String toString()
    {
        return this.airCraftCapacityVolume+"|"+this.airCraftCapacityTons;
    }

    @Override
    public int getAirCraftCapacityVolume() {
        return this.airCraftCapacityVolume;
    }

    public double getCargoCapacityTons() {
        return this.airCraftCapacityTons;
    }
}
