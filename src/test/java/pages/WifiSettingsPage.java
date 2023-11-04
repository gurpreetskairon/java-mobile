package pages;

import framework.Element;
import io.appium.java_client.AppiumBy;

public class WifiSettingsPage {
    //Element mnuPreferences = new Element(AppiumBy.accessibilityId("Preference"));
    //Element mnuPreferenceDependencies = new Element(AppiumBy.accessibilityId("3. Preference dependencies"));

    Element chkWifi = new Element(AppiumBy.id("android:id/checkbox"));
    Element mnuWifiSettings = new Element(AppiumBy.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
    Element txtWifiName = new Element(AppiumBy.id("android:id/edit"));
    Element btnOk = new Element(AppiumBy.id("android:id/button1"));

    public void selectMenuItem(String menuItem){
        new Element(AppiumBy.accessibilityId(menuItem)).findElement().click();
    }
    public void setWifi(String wifiName){
        //mnuPreferenceDependencies.findElement().click();
        chkWifi.findElement().click();
        mnuWifiSettings.findElement().click();
        txtWifiName.findElement().sendKeys(wifiName);
        btnOk.findElement().click();
    }

    public String getWifiName() {
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        mnuWifiSettings.findElement().click();
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        return txtWifiName.findElement().getAttribute("text");
    }

}
