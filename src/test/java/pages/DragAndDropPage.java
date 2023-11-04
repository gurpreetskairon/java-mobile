package pages;

import framework.Element;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.an.E;

import java.util.HashMap;
import java.util.Map;

public class DragAndDropPage {

    Element lblDropped = new Element(AppiumBy.id("io.appium.android.apis:id/drag_result_text"));

    public void dragAndDrop(int source, int destination){
        Element sourceImageElement = new Element(AppiumBy.id("io.appium.android.apis:id/drag_dot_" + source));
        sourceImageElement.findElement();
        int x = 0, y = 0;
        switch (destination){
            case 1:
                x = 220;
                y = 580;
                break;
            case 2:
                x = 660;
                y = 580;
                break;
            case 3:
                x = 220;
                y = 1020;
                break;
            case 4:
                x = 660;
                y = 1020;
                break;
        }

        Map<String, Object> options = new HashMap<>();
        options.put("endX", x);
        options.put("endY", y);
        sourceImageElement.applyMobileGesture("dragGesture", options);
    }

    public String getDroppedText(){
        return lblDropped.findElement().getAttribute("text");
    }
}
