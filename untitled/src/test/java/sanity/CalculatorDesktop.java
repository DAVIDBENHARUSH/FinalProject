package sanity;

import Utilities.CommonOps;
import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workflows.DesktopFlows;
import workflows.ElectronFlows;

@Listeners(Utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {
    @Test(description = "Test01-Verify Addition Command")
    @Description("This Test Verifies the Addition Command")
    public void test01_VerifyAdditionCommand() {
        DesktopFlows.CalCalculateAddition();
        verifications.verifyTextElement(calcMain.field_result, "Display is 9");
    }


}
