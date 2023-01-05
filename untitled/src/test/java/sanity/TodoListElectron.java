package sanity;

import Utilities.CommonOps;
import extentions.UIActions;
import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workflows.ElectronFlows;

@Listeners(Utilities.Listeners.class)
public class TodoListElectron extends CommonOps {
    @Test(description = "Test01- Add End Verify New Task")
    @Description("This Test Adds a new task and verifies it in the list of task")
    public void test01_AddEndVerifyNewTask() {
        ElectronFlows.AddNewTask("learn java");
        verifications.VerifyNumber(ElectronFlows.getNumberOfTasks(),1);
    }
}
