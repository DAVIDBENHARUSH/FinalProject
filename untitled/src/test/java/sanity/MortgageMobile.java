package sanity;

import Utilities.CommonOps;
import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workflows.MobileFlows;


@Listeners(Utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test01- Verify Mortgage")
    @Description("This Test fill in mortgage fields and calculate repayment")
    public void test01_verifyMortgage() {
        MobileFlows.calculateMortgage("1000","3","4");
        verifications.verifyTextElement(mortgageMain.Repayment, "£30.03");
    }
}
