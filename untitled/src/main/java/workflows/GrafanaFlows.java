package workflows;

import Utilities.CommonOps;
import extentions.DBActions;
import extentions.UIActions;
import extentions.verifications;
import io.qameta.allure.Step;

import java.util.List;

public class GrafanaFlows extends CommonOps {

    @Step("testing")
    public static void login(String user, String pass) {

        UIActions.updateText(GrafanaLogin.txt_username, user);
        UIActions.updateText(GrafanaLogin.txt_password, pass);
        UIActions.click(GrafanaLogin.btn_login);
        UIActions.click(GrafanaLogin.Skip);

    }
    public static void loginDB() {
        String query = "SELECT name, password FROM Employees WERE id=3";
         List<String> cred =  DBActions.getCredentials(query);
        UIActions.updateText(GrafanaLogin.txt_username, cred.get(0));
        UIActions.updateText(GrafanaLogin.txt_password, cred.get(1));
        UIActions.click(GrafanaLogin.btn_login);
        UIActions.click(GrafanaLogin.Skip);

    }
    public static void createNewUser(String name,String email,String userName,String pass ){
        UIActions.click(GrafanaServerAdminMain.btn_newUser);
        UIActions.updateText(GrafanaAddNewUser.txt_name,name);
        UIActions.updateText(GrafanaAddNewUser.txt_email,email);
        UIActions.updateText(GrafanaAddNewUser.txt_userName,userName);
        UIActions.updateText(GrafanaAddNewUser.txt_password,pass);
        UIActions.click(GrafanaAddNewUser.btn_create);
    }

    public static void deleteLastUser(){
       UIActions.click(GrafanaServerAdminMain.rows.get(GrafanaServerAdminMain.rows.size()-1));
       UIActions.click(GrafanaEditUser.btn_deleteUser);
        UIActions.click(GrafanaEditUser.btn_confirmDeleteUser);
    }

    public static void searchAndVerifyUser(String user, String shouldExists){
        UIActions.updateTextHuman(GrafanaServerAdminMain.txt_search, user);
        if (shouldExists.equalsIgnoreCase("exist"))
            verifications.existanceOfElement(GrafanaServerAdminMain.rows);
        else if(shouldExists.equalsIgnoreCase("notExist"))
            verifications.notExistanceOfElement(GrafanaServerAdminMain.rows);
        else
            throw new RuntimeException(("Invalid Expected Output Option in Data Driven testing, Should be Exists or not Exists"));
            

    }


}
