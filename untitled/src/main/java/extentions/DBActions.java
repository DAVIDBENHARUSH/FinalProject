package extentions;

import Utilities.CommonOps;
import io.qameta.allure.Step;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get credentials from Database")
    public static List<String> getCredentials(String query) {
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));


        } catch (Exception e) {
            System.out.println("Error occurred while printing table data, See details " + e);
        }
    return credentials;
    }
}

