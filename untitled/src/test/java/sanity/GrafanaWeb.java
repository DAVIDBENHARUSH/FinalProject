package sanity;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import extentions.UIActions;
import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workflows.GrafanaFlows;

import java.util.concurrent.TimeUnit;

@Listeners(Utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {


    @Test(description = "Test01- Verify Header")
    @Description("This Test login and verifies the main header")
    public void test01_verifyHeader() {
        GrafanaFlows.login("admin", "admin");
        verifications.verifyTextElement(GrafanaMain.head_Dashboard, "Home Dashboard");

    }

    @Test(description = "Test02- Verify Default Users")
    @Description("This Test Verify and Default Users")
    public void test02_verifyDefaultUsers() {
        UIActions.mouseHover(GrafanaLeftMenu.btn_server, GrafanaServerAdmin.link_users);
        verifications.numberOfElements(GrafanaServerAdminMain.rows, 1);

    }

    @Test(description = "Test03- Verify New Users")
    @Description("This Test  verifies a new user has been Added")
    public void test03_verifyNewUser() {
        UIActions.mouseHover(GrafanaLeftMenu.btn_server, GrafanaServerAdmin.link_users);
        GrafanaFlows.createNewUser("David", "sbh135@walla.co.il", "Davidf", "12345");
        verifications.numberOfElements(GrafanaServerAdminMain.rows, 2);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Test(description = "Test04- Verify user Deletion")
    @Description("This Test verifies deletion of a user")
    public void test04_verifyUserDeletion() {
        UIActions.mouseHover(GrafanaLeftMenu.btn_server, GrafanaServerAdmin.link_users);
        GrafanaFlows.deleteLastUser();
        verifications.numberOfElements(GrafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test05- Verify Progress Steps")
    @Description("This Test login verify and default  progress steps")
    public void test05_verifyProgressSteps() {
        verifications.visibilityOfElements(GrafanaMain.progressSteps);
    }

    @Test(description = "Test06- Verify Avatar Icon")
    @Description("This Test verifies the Avatar Image Using Sikuli tool")
    public void test06_verifyAvatarIcon() throws Exception{
        verifications.visualElement("grafanaAvatar");
    }

    @Test(description = "Test07- Search Users", dataProvider = "data-provider-users", dataProviderClass = Utilities.manageDDT.class)
    @Description("This Test Searched Users in a table using DOT")
    public void test07_SearchUsers(String user, String shouldEXist) {
        UIActions.mouseHover(GrafanaLeftMenu.btn_server, GrafanaServerAdmin.link_users);
        GrafanaFlows.searchAndVerifyUser(user,shouldEXist);
    }
}