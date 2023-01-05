package Utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.AddNewUserPage;
import pageObjects.grafana.EditUserPage;
import pageObjects.grafana.serverAdminMainPage;
import pageObjects.grafana.serverAdminMenuPage;

public class manegePages extends Base {

    public static void initGrafana() {
        GrafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);

        GrafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);

        GrafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);

        GrafanaServerAdmin = PageFactory.initElements(driver, serverAdminMenuPage.class);

        GrafanaServerAdminMain = PageFactory.initElements(driver, serverAdminMainPage.class);

        GrafanaAddNewUser = PageFactory.initElements(driver, AddNewUserPage.class);

        GrafanaEditUser = PageFactory.initElements(driver, EditUserPage.class);
    }

    public static void initMortgage() {

        mortgageMain = new pageObjects.mortegage.MainPage(mobileDriver);

    }

    public static void InitToDo() {

        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);

    }

    public static void InitCalculator() {

        calcMain = PageFactory.initElements(driver, pageObjects.Calculator.MainPage.class);
    }
}
