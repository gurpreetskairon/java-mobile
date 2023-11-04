package pages;

import framework.Element;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class CustomAdaptorPage {
    Element lblPeopleNames = new Element(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));


    public void longPressPeopleNamesMenuItem(){
        lblPeopleNames.findElement();
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("duration", "2000");
        lblPeopleNames.applyMobileGesture("longClickGesture", options);
    }

    public boolean doesContextMenuExist(String menuItem){
        return new Element(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='" + menuItem + "']"))
                .findElement().isDisplayed();
    }
}
