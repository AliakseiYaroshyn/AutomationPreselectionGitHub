package by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2;

/**
 * static data for cargo air crafts and getters
 */
public class CargoAirCraftDataSource {

    private String[] airCraftTechname = new String [] {"AirbusA300600ST", "AH124100", "AH225", "Boeing747LCF"};
    private String[] airCraftSubName = new String[] {"Airbus A300-600ST", "AH-124-100", "AH-225", "Boeing 747 LCF"};
    private String[] airCraftProductName = new String[] {"AIRBUS","AH","AH","BOEING"};
    private int [] airCraftCargoCapacities = new int[]{1210,1050,1050,1840};
    private double [] airCraftCapacitiesTons = new double[]{47,120,253,113.4};
    private int [] airCraftMaxDistanceCovered = new int[] {2779,4800,4000,7800};

    public int getTotalDefaultCargoAirCraft (){
        return airCraftTechname.length;
    }
    public String getAirCraftSubName(int randomCargoDataIndex) {
        return airCraftSubName[randomCargoDataIndex];
    }
    public String getAirCraftProductName(int randomCargoDataIndex) {
        return airCraftProductName[randomCargoDataIndex];
    }
    public int getAirCraftCargoCapacity (int randomCargoDataIndex) {
        return airCraftCargoCapacities[randomCargoDataIndex];
    }
    public double getAirCraftCapacitiesTons (int randomCargoDataIndex) {
        return airCraftCapacitiesTons[randomCargoDataIndex];
    }
    public int getMaxDistanceCovered (int randomCargoDataIndex) {
        return airCraftMaxDistanceCovered[randomCargoDataIndex];
    }

}
