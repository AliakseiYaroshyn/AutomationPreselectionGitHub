package by.epam.automationpreselection.task234.aircraftdatasource.outputdatatask34;

import by.epam.automationpreselection.task234.aircrafttypes.CompanyAirCraft;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AirCompanyParkJdbcWriter {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DBNAME = "skydreamerjetcompanydb";
    private static final String USERNAME = "AIRPARKAGENT";
    private static final String PASS_WORD = "AIRPARKAGENT";
    private static final String SQL_INSERT_STATEMENT = "INSERT INTO skydreamerjetcompanyairpark "
            + "(companyAirCraftID, companyAirCraftSubName, companyAirCraftProductName,companyAirCraftType, airCraftMaxDistanceKm, "
            + "airCraftMaxDistanceType, airCraftCapacityVolume, airCraftCapacityTons, airCraftCapacityPassengers) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void writeAirCompanyParkToDB (List<CompanyAirCraft> companyAirPark) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        try {Connection conn = getConnection();
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate("TRUNCATE TABLE skydreamerjetcompanyairpark");
            }
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_STATEMENT)) {
                for (CompanyAirCraft companyAirCraft:companyAirPark) {
                    preparedStatement.setString(1,companyAirCraft.getCompanyAirCraftID());
                    preparedStatement.setString(2,companyAirCraft.getAirCraftSubName());
                    preparedStatement.setString(3,companyAirCraft.getAirCraftProductName());
                    preparedStatement.setString(4,companyAirCraft.getAirCraftType());
                    preparedStatement.setInt(5,companyAirCraft.getExactMaxDistanceKm());
                    preparedStatement.setString(6,companyAirCraft.getExactMaxDistanceType());
                    preparedStatement.setInt(7,companyAirCraft.getExactCapacityVolume());
                    preparedStatement.setDouble(8,companyAirCraft.getExactCapacityTons());
                    preparedStatement.setInt(9,companyAirCraft.getExactCapacityPassengers());
                    preparedStatement.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AirCompanyParkJdbcWriter.class
                    .getName()).log(Level.SEVERE, "writeAirCompanyParkToDB threw SQLException", ex);
        } finally {
            getConnection().close();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DBNAME + "?autoReconnect=true&useSSL=false", USERNAME, PASS_WORD);
    }
}
