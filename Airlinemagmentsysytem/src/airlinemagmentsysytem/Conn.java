package airlinemagmentsysytem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    PreparedStatement pst;  // Declare PreparedStatement

    public Conn() {
        try {
            // Load PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Connect to your PostgreSQL DB
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/airline", "postgres", "postgres");
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query with parameters
    public ResultSet executeQuery(String query, String... params) {
        try {
            // Prepare statement with the query
            pst = c.prepareStatement(query);
            
            // Set parameters for PreparedStatement (if any)
            for (int i = 0; i < params.length; i++) {
                pst.setString(i + 1, params[i]);
            }
            
            // Execute the query and return the ResultSet
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Method to close the connection
    public void close() {
        try {
            if (c != null) c.close();
            if (s != null) s.close();
            if (pst != null) pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
