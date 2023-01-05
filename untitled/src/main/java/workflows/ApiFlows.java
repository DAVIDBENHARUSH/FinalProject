package workflows;

import Utilities.CommonOps;
import extentions.ApiActions;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class ApiFlows extends CommonOps {


    public static String  getTeamProperty;

    @Step("Business Flow:Get Team Property")
    @Description("this test verify team property")
    public static String getTeamProperty(String jPath) {
        response = ApiActions.get("/api/teams/search");
        return ApiActions.extractFromJSON(response, jPath);

    }

    @Step("Business Flow:Create new team in Grafana")
    public static void postTeam(String name, String email) {
        params.put("name", name);
        params.put("email", email);
        ApiActions.post(params, "/api/teams");
    }

    @Step("Business Flow:Update Existing Team in Grafana")
    @Description("this test verify team property")
    public static void UpdateTeam(String name, String email, String id) {
        params.put("name", name);
        params.put("email", email);
        ApiActions.put(params, "/api/teams" + id);
    }
    @Step("Business Flow:delete Existing Team in Grafana")
    @Description("this test verify team property")
    public static void DeleteTeam( String id) {
        ApiActions.Delete(id);
    }
}