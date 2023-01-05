package pageObjects.mortegage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;



public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
     this.mobileDriver = mobileDriver;
     PageFactory.initElements(new AppiumFieldDecorator(mobileDriver , Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(xpath = "//*[@id='etAmount']")
    public AndroidElement Amount;

    @AndroidFindBy(xpath = "//*[@id='etTerm']")
    public AndroidElement Term;

    @AndroidFindBy(xpath = "//*[@id='etRate']")
    public AndroidElement Rate;

    @AndroidFindBy(xpath = "//*[@id='btnCalculate']")
    public AndroidElement Calculate;

    @AndroidFindBy(xpath = "//*[@id='tvRepayment']")
    public AndroidElement Repayment;

}
