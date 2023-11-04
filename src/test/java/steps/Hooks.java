package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import static framework.TestDriver.*;


public class Hooks {

    @Before
    public void setup() {
        String device = "android";
        initialisedDriver(device);
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
