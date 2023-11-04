package framework;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

import static framework.TestDriver.driver;

public class Element {
    public By locator;
    public WebElement element;

    public Element(By locator){
        this.locator = locator;
    }
    public Element(){

    }
    public WebElement findElement(){
        element = driver.findElement(locator);
        return element;
    }


    public Object applyMobileGesture(String gesture, Map<String, Object> options){
        if (this.element != null)
            options.put("elementId", ((RemoteWebElement) this.element).getId());
        if(gesture.equalsIgnoreCase("scrollGesture")) {
            if (!options.containsKey("left"))
                options.put("left", 100);
            if (!options.containsKey("top"))
                options.put("top", 100);
            if (!options.containsKey("width"))
                options.put("width", 200);
            if (!options.containsKey("height"))
                options.put("height", 200);
            if (!options.containsKey("direction"))
                options.put("direction", "down");
            if (!options.containsKey("percent"))
                options.put("percent", 50);
        }
        return ((JavascriptExecutor) driver).executeScript("mobile: " + gesture, options);
    }
    public Object applyMobileGesture(String gesture){
        Map<String, Object> options = new HashMap<>();
        if(gesture.equalsIgnoreCase("scrollGesture")) {
            if (!options.containsKey("left"))
                options.put("left", 100);
            if (!options.containsKey("top"))
                options.put("top", 100);
            if (!options.containsKey("width"))
                options.put("width", 200);
            if (!options.containsKey("height"))
                options.put("height", 200);
            if (!options.containsKey("direction"))
                options.put("direction", "down");
            if (!options.containsKey("percent"))
                options.put("percent", 50);
        }
        return applyMobileGesture(gesture, options);
    }

    public void scrollAndroidElementIntoView(String elementText){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
    }
}
