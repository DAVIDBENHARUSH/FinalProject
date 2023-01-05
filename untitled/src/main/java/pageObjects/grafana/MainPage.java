package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    // @FindBy(how = How.XPATH, using = "//div[@class='text-center dashboard-header']/span")
    @FindBy(how = How.XPATH , using = "//p[@ng-bind-html='ctrl.content']")
    public WebElement head_Dashboard;

    @FindBy(how = How.XPATH , using = "//div[@class='progress-tracker']")
    public List<WebElement> progressSteps;
}
