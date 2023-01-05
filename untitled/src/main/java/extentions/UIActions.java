package extentions;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {


  public static void click(WebElement elem) {
      wait.until(ExpectedConditions.elementToBeClickable(elem));
      elem.click();
  }
   public static void updateText(WebElement elem, String text) {
      wait.until(ExpectedConditions.visibilityOf(elem));
       elem.sendKeys(text);
   }
    public static void updateTextHuman(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
      for (char ch: text.toCharArray()){
          Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
          elem.sendKeys(ch + "" );
      }
  }
   public static void updateDropDown(WebElement elem, String text){
      wait.until(ExpectedConditions.elementToBeClickable(elem));
       Select dropDown = new Select(elem);
       dropDown.selectByVisibleText(text);
  }
  public static void mouseHover(WebElement elem1,WebElement elem2){
      actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();

  }
    public static void mouseHover(WebElement elem1){
        actions.moveToElement(elem1).click().build().perform();
    }

    public static void insertKey(WebElement elem, Keys value){
      elem.sendKeys(value);
    }
}
