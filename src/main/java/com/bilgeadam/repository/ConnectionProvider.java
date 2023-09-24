package com.bilgeadam.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionProvider {
    String connectionString= "jdbc:postgresql://localhost:5432/companyDB";
    String username= "postgres";
    String password= "root";
    Connection connection;
    PreparedStatement preparedStatement;

    public boolean openConnection(){
        try {
            connection= DriverManager.getConnection(connectionString,username,password);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public boolean closeConnection(){
        try {
            if (!connection.isClosed()){
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean executeUpdate(String sqlSorgu){
        if (openConnection()){
            try {
                preparedStatement= connection.prepareStatement(sqlSorgu);
                preparedStatement.executeUpdate();
                closeConnection();
                return true;
            } catch (SQLException e) {
                closeConnection();
            }
        }
        return false;
    }


}
