package Utilities;

import java.sql.DriverManager;

public class ManegeDB extends CommonOps{

    public static void StatConnection(String dbURL, String user, String dbPassword){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, dbPassword);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while Connecting to DB, See details " + e);

        }

    }

    public static void CloseConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while Closing  to DB, See details " + e);
        }
    }

}
