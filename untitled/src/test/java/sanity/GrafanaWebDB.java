package sanity;

import Utilities.CommonOps;
import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workflows.GrafanaFlows;


@Listeners(Utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps{


    @Test(description = "Test01- Verify Header")
    @Description("This Test loginDB to grafana with BD credentials ")
    public void test01_loginDBAndVerifyHeader() {
        GrafanaFlows.loginDB();
        verifications.verifyTextElement(GrafanaMain.head_Dashboard, "Home Dashboard");

    }

    }


