package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.NAME, using = "user")
    public WebElement txt_username;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using = "button[type='submit'")
    public WebElement btn_login;


    @FindBy(how = How.CSS, using = "a [class='btn-link']")
    public WebElement btn_skip;

    @FindBy(how = How.XPATH , using = "//a[@class='btn btn-link']")
    public WebElement Skip;
}
