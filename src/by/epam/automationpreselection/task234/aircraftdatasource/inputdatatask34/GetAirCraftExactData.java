package by.epam.automationpreselection.task234.aircraftdatasource.inputdatatask34;

import java.sql.SQLException;

public interface GetAirCraftExactData {
    String getAirCraftID() throws SQLException;
    String getAirCraftSubName() throws SQLException;
    String getAirCraftProductName() throws SQLException;
    String getAirCraftType() throws SQLException;
    String getAirCraftMaxDistanceType() throws SQLException;
    int getAirCraftCargoCapacity() throws SQLException;
    double getAirCraftCapacitiesTons() throws SQLException;
    int getAirCraftPassengerCapacity() throws SQLException;
    int getMaxDistanceCovered() throws SQLException;
}
