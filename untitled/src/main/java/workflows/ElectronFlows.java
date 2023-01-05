package workflows;

import Utilities.CommonOps;
import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

public class ElectronFlows extends CommonOps {

    @Step("AddNewTask to the List")
    public static void AddNewTask(String taskName){
        UIActions.updateText(todoMain.txt_create, taskName);
        UIActions.insertKey(todoMain.txt_create, Keys.RETURN);

    }
    @Step("count and Return Number of Tasks in the List")
    public static int getNumberOfTasks(){
       return todoMain.list_tasks.size();
    }


}
