package Utilities;

import io.appium.java_client.MobileDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;

import static Utilities.Base.*;
import static Utilities.CommonOps.getData;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("---starting---");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        if (!Platform.equalsIgnoreCase("api")){
       //Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }      //Delete Recorder File
            File file = new File("./test-recordings" + iTestResult.getName() + "avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("File to Delete File");
          }
        }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            saveScreenShot();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("--starting--");
    }


    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("--finishing--");
}

   @Attachment(value = "Page screen-shot", type = "image/png")
   public byte[] saveScreenShot() throws Exception {
       if (Platform.equalsIgnoreCase("web"))
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
       else
           return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
   }
}
