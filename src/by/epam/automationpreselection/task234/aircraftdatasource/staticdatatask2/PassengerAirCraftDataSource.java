package by.epam.automationpreselection.task234.aircraftdatasource.staticdatatask2;

/**
 * static data for passenger air crafts and getters
 */
public class PassengerAirCraftDataSource {

    private String[] airCraftTechname = new String [] {"Boeing7878", "Boeing777300", "Boeing777200", "TU334",
                                               "Airbus330300", "AirbusA321", "TU204100", "Airbus380800"};
    private String[] airCraftSubName = new String[] {"Boeing 787-8", "Boeing 777-300", "Boeing 777-200", "TU-334",
                                              "Airbus A330-300", "Airbus A321", "TU-204-100", "Airbus A380-800"};
    private String[] airCraftProductName = new String[] {"BOEING","BOEING","BOEING","TU","AIRBUS","AIRBUS","TU","AIRBUS"};
    private int [] airCraftCargoCapacities = new int[]{113,200,150,16,163,9,43,184};
    private int [] airCraftPassengerCapacities = new int[]{242,550,440,102,440,185,210,853};
    private int [] airCraftMaxDistanceCovered = new int[] {14500,10595,9700,4100,10800,5550,6800,15200};


    public int getTotalDefaultPassengerAirCraft (){return airCraftTechname.length;}
    public String getAirCraftTechname(int randomPassDataIndex) {
        return airCraftTechname[randomPassDataIndex];
    }
    public String getAirCraftSubName(int randomPassDataIndex) {
        return airCraftSubName[randomPassDataIndex];
    }
    public String getAirCraftProductName(int randomPassDataIndex) {
        return airCraftProductName[randomPassDataIndex];
    }
    public int getAirCraftCargoCapacity (int randomPassDataIndex) {
        return airCraftCargoCapacities[randomPassDataIndex];
    }
    public int getAirCraftPassengerCapacity (int randomPassDataIndex) {
        return airCraftPassengerCapacities[randomPassDataIndex];
    }
    public int getMaxDistanceCovered (int randomPassDataIndex) {
        return airCraftMaxDistanceCovered[randomPassDataIndex];
    }
}
