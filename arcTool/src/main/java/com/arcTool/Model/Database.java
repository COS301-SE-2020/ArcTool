package com.arcTool.Model;

import java.sql.*;

public class Database {

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.jdbc.Driver";
    //static final String url = "jdbc:mysql://localhost/EMP";
    private final String url = "jdbc:mysql://localhost:3306/arctooldb";
    private final String username = "root";
    private final String pass = "";
    private Connection connection = null;
    ResultSet rs = null;


    /*public Connection instance() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(url, username, null);
        }

        return connection;
    }*/

    public Database(){

    }

    private void createConnection() throws SQLException {

        //Class.forName(com.mysql.jdbc.Driver);
        connection = DriverManager.getConnection(url, "root", "");
    }

    private void closeConnection() throws SQLException {
        connection.close();
    }

    public Boolean addUser(User user){
        if (user == null) return false;

        try{
            if (connection == null){
                System.out.println("Failed to establish connection!!!");
                return false;
            }
            else
                System.out.println("Connection established");
            //Statement statement = connection.createStatement();
            String query = "INSERT INTO user(firstname, lastname, email, password)" +
                    "values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setString(4, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                 rs = preparedStatement.getGeneratedKeys();
                int uid = rs.getInt(1);
                System.out.println("****New user succesfully registered with ID " + uid);
            }
            else
                System.out.println("registration failed");

        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
        finally {
            try{
                if (rs != null)
                    rs.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

            try {
                closeConnection();
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }

        return true;
    }
}
