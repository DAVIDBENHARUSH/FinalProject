package workflows;

import Utilities.CommonOps;
import extentions.UIActions;
import io.qameta.allure.Step;

public class DesktopFlows extends CommonOps {

    @Step()
    public static void CalCalculateAddition(){

        UIActions.click(calcMain.btn_one);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_eight);
        UIActions.click(calcMain.btn_equals);
        UIActions.click(calcMain.btn_clear);

    }

}
