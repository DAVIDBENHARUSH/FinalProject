package sanity;

import Utilities.CommonOps;
import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workflows.ApiFlows;
@Listeners(Utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test01_Get Team From Grafana")
    @Description("this test is verify team property")
    public void test1_VerifyTeam() {
        verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"),"BTem");
    }
    @Test(description = "Test02_Add Team From Grafana")
    @Description("this test add a team to Grafana and verify it")
    public void test2_AddTeamAndVerify() {
        ApiFlows.postTeam("davidTeam", "sbh135@walla.com");
        verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"),"david");
    }
    @Test(description = "Test03_Update Team and Verify")
    @Description("this test Update a team in Grafana and verify it")
    public void test3_UpdateTeamAndVerify() {
        ApiFlows.UpdateTeam("davidTeam", "Davidbenharush993@gmail.com", "5");
        verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"),"Davidbenharush993@gmail.com");
    }
    @Test(description = "Test04_Delete Team and Verify")
    @Description("this test Update a team in Grafana and verify it")
    public void test4_DeleteTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[2].id");
        ApiFlows.DeleteTeam(id);
        verifications.verifyText(ApiFlows.getTeamProperty("totalCount"),"3");

    }

}
