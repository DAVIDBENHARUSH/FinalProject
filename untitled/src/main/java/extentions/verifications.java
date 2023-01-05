package extentions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;

import java.util.List;


import static org.testng.Assert.*;
import static org.testng.FileAssert.fail;

public class verifications extends CommonOps {


    public static void verifyTextElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);

    }

    public static void numberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expected);
    }

    public static void visibilityOfElements(List<WebElement> elems){
        for (WebElement elem : elems){
            softAssert.assertTrue(elem.isDisplayed());
        }

        softAssert.assertAll();
    }

    public static void visualElement(String expectedImageName) throws Exception {
        try {
        screen.find(getData("ImageRepo") + expectedImageName + ".png");
    } catch (FindFailed findFailed) {
            fail("Error in Image File: " + findFailed);
        }
}
    @Step("Verify Element is Displayed")
    public static void existanceOfElement(List<WebElement> elements)
    {

        assertTrue(elements.size() > 0);
    }

    @Step("Verify Element Not Displayed")
    public static void notExistanceOfElement(List<WebElement> elements){

        assertFalse(elements.size() > 0);
    }

    @Step("Verify with Text")
    public static void VerifyText(String actual, String expected){

        assertEquals(actual,expected);
    }
     @Step("Verify Text")
    public static void verifyText(String teamProperty, String s) {}

    @Step("Verify with Number")
    public static void VerifyNumber(int actual, int expected){

        assertEquals(actual,expected);
    }
}

