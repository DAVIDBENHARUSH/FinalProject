package Utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.grafana.AddNewUserPage;
import pageObjects.grafana.EditUserPage;
import pageObjects.grafana.serverAdminMainPage;
import pageObjects.grafana.serverAdminMenuPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {


    //General
    protected static WebDriverWait wait;

    protected static Actions actions;

    protected static Alert alert;

    protected static SoftAssert softAssert;

    protected static Screen screen;

    protected static String Platform;

    //Web

    protected static WebDriver driver;

    //Mobile

    protected static AppiumDriver mobileDriver;

    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Electron

    protected static pageObjects.todo.MainPage todoMain;

    //Rest API

    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static  JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database

    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //Page Objects grafana
    protected static pageObjects.grafana.LoginPage GrafanaLogin;

    protected static pageObjects.grafana.MainPage GrafanaMain;

    protected static pageObjects.grafana.LeftMenuPage GrafanaLeftMenu;

    protected static serverAdminMenuPage GrafanaServerAdmin;

    protected static serverAdminMainPage GrafanaServerAdminMain;

    protected static AddNewUserPage GrafanaAddNewUser;

    protected static EditUserPage GrafanaEditUser;


    //Page Objects mobile

    protected static pageObjects.mortegage.MainPage mortgageMain;

    //Page Objects Desktop

    protected static pageObjects.Calculator.MainPage calcMain;





}
