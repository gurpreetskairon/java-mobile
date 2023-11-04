package pages;

import framework.Element;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.an.E;

public class ListDialogPage {

    public void selectOption(String option){
        new Element(AppiumBy.xpath("//android.widget.TextView[@text='" + option + "']")).findElement().click();
    }

    public String getMessage(){
        return new Element(AppiumBy.id("android:id/message")).findElement().getText();
    }
}
