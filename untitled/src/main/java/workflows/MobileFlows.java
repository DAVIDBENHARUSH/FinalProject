package workflows;

import Utilities.CommonOps;
import extentions.MobileActions;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

public class MobileFlows extends CommonOps {

@Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate){
        MobileActions.updateText(mortgageMain.Amount , amount );
        MobileActions.updateText(mortgageMain.Term , term );
        MobileActions.updateText(mortgageMain.Rate , rate );
        MobileActions.tap(mortgageMain.Calculate);
    }

}
