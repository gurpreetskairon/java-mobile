package pages;

import framework.Element;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class HomePage {

    public void scrollIntoView(String elementText){
        Element element = new Element(AppiumBy.xpath("//android.widget.TextView[@content-desc='" + elementText + "']"));
        boolean canScroll;
        do {
            canScroll = (Boolean)element.applyMobileGesture("scrollGesture");

            try{
                element.findElement();
                System.out.println("found " + elementText);
                element.element.click();
                break;
            }catch(Exception e){}

        }while(canScroll);
    }

    public void scrollAndroidElementIntoView(String elementText){
        new Element().scrollAndroidElementIntoView(elementText);
    }
}
