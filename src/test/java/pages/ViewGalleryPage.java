package pages;

import framework.Element;
import io.appium.java_client.AppiumBy;

import java.util.HashMap;
import java.util.Map;

public class ViewGalleryPage {

    public void swipeImageIntoView(String direction, int image){
        Map<String, Object> options = new HashMap<>();
        options.put("direction", direction);
        options.put("percent", 0.75);
        Element photoElement = new Element(AppiumBy.xpath("//android.widget.Gallery/android.widget.ImageView[" + image + "]"));
        photoElement.findElement();
        photoElement.applyMobileGesture("swipeGesture", options);
    }

    public String isPhotoInFocus(int photoNumber){
        Element photoElement = new Element(AppiumBy.xpath("//android.widget.Gallery/android.widget.ImageView[" + photoNumber + "]"));
        photoElement.findElement();
        return photoElement.element.getAttribute("focusable");
    }
}
