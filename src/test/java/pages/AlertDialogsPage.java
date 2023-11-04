package pages;

import framework.Element;
import io.appium.java_client.AppiumBy;

public class AlertDialogsPage {

    public void clickButton(String button){
        new Element(AppiumBy.accessibilityId(button)).findElement().click();
    }

    public String getDataFromAlertDialog(String element) {
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        return new Element(AppiumBy.id("android:id/" + element)).findElement().getText();
    }


}
