package by.epam.automationpreselection.task234.aircraftdatasource.inputdatatask34;

import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.CargoCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftcapacity.PassengerCraftCapacity;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.CargoAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttechnicaldata.aircraftmaxdistance.PassengerAirCraftMaxDistance;
import by.epam.automationpreselection.task234.aircrafttypes.CargoAirCraftDefault;
import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import by.epam.automationpreselection.task234.aircrafttypes.PassengerAirCraftTypeDefault;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Statement;

public class AirCompanyParkJdbcReader implements GetAirCraftExactData {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DBNAME = "skydreamerjetcompanydb";
    private static final String USERNAME = "AIRPARKAGENT";
    private static final String PASS_WORD = "AIRPARKAGENT";
    private static final String SQL_SELECT_ALL_STATEMENT = "SELECT * FROM skydreamerjetcompanyairpark";
    private ResultSet exactAirCraftRecord;


    public List<CompanyAirCraft> readAirCompanyParkFromDB () throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        List<CompanyAirCraft> companyAirParkFromDB = new ArrayList<>();
        try {
            Connection conn = getConnection();
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_STATEMENT)) {
                while (resultSet.next()) {
                    exactAirCraftRecord = resultSet;
                    CompanyAirCraft companyAirCraft;
                    String s = getAirCraftType();
                    if (s.equals("CARGO")) {
                        CargoAirCraftMaxDistance cargoAirCraftMaxDistance = new CargoAirCraftMaxDistance(getMaxDistanceCovered(), getAirCraftMaxDistanceType());
                        CargoCraftCapacity cargoCraftCapacity = new CargoCraftCapacity(getAirCraftCargoCapacity(), getAirCraftCapacitiesTons());
                        CargoAirCraftDefault cargoAirCraft = new CargoAirCraftDefault(getAirCraftSubName(), getAirCraftProductName(), getAirCraftType(), cargoAirCraftMaxDistance, cargoCraftCapacity);
                        companyAirCraft = new CompanyAirCraft(getAirCraftID(), cargoAirCraft);
                        companyAirParkFromDB.add(companyAirCraft);
                    } else if (s.equals("PASSENGER")) {
                        PassengerAirCraftMaxDistance passengerAirCraftMaxDistance = new PassengerAirCraftMaxDistance(getMaxDistanceCovered(), getAirCraftMaxDistanceType());
                        PassengerCraftCapacity passengerCraftCapacity = new PassengerCraftCapacity(getAirCraftCargoCapacity(), getAirCraftPassengerCapacity());
                        PassengerAirCraftTypeDefault passengerAirCraft = new PassengerAirCraftTypeDefault(getAirCraftSubName(), getAirCraftProductName(), getAirCraftType(), passengerAirCraftMaxDistance, passengerCraftCapacity);
                        companyAirCraft = new CompanyAirCraft(getAirCraftID(), passengerAirCraft);
                        companyAirParkFromDB.add(companyAirCraft);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AirCompanyParkJdbcReader.class
                        .getName()).log(Level.SEVERE, "readAirCompanyParkFromDB threw SQLException", ex);
            }
            return companyAirParkFromDB;
        } catch (SQLException ex) {
            Logger.getLogger(AirCompanyParkJdbcReader.class
                    .getName()).log(Level.SEVERE, "readAirCompanyParkFromDB threw SQLException", ex);
        }
        return companyAirParkFromDB;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DBNAME + "?autoReconnect=true&useSSL=false", USERNAME, PASS_WORD);
    }

    @Override
    public String getAirCraftID() throws SQLException {
        return exactAirCraftRecord.getString("companyAirCraftID");
    }

    @Override
    public String getAirCraftSubName() throws SQLException {
        return exactAirCraftRecord.getString("companyAirCraftSubName");
    }

    @Override
    public String getAirCraftProductName() throws SQLException {
        return exactAirCraftRecord.getString("companyAirCraftProductName");
    }

    @Override
    public String getAirCraftType() throws SQLException{
        return exactAirCraftRecord.getString("companyAirCraftType");
    }

    @Override
    public String getAirCraftMaxDistanceType() throws SQLException{
        return exactAirCraftRecord.getString("airCraftMaxDistanceType");
    }

    @Override
    public int getAirCraftCargoCapacity() throws SQLException{
        return exactAirCraftRecord.getInt("airCraftCapacityVolume");
    }

    @Override
    public double getAirCraftCapacitiesTons() throws SQLException{
        return exactAirCraftRecord.getDouble("airCraftCapacityTons");
    }

    @Override
    public int getAirCraftPassengerCapacity() throws SQLException{
        return exactAirCraftRecord.getInt("airCraftCapacityPassengers");
    }

    @Override
    public int getMaxDistanceCovered() throws SQLException{
        return exactAirCraftRecord.getInt("airCraftMaxDistanceKm");
    }
}
