package framework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestDriver {

    public static RemoteWebDriver driver;

    public static void initialisedDriver(String device) {

        if (device.equalsIgnoreCase("android")) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel_3a");
            options.setApp("//Users//gurpreetsingh//gurpreet//code//java-mobile//src//test//resources//ApiDemos-debug.apk");

            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            }
            catch(MalformedURLException e){
                System.out.println(e.getMessage());
            }
            try {
                //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
