package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.*;

import java.util.Map;

public class APIDemoSteps {
    WifiSettingsPage wifiSettingsPage;
    CustomAdaptorPage customAdaptorPage;
    HomePage homePage;
    ViewGalleryPage viewGalleryPage;
    DragAndDropPage dragAndDropPage;
    AlertDialogsPage alertDialogsPage;

    ListDialogPage listDialogPage;

    @Given("I connect to the device and application")
    public void i_connect_to_the_device_and_application() {


    }
    @When("I select {string} menu item on the home screen")
    public void selectMenuItemOnHomeScreen(String menuItem){
        wifiSettingsPage = new WifiSettingsPage();
        wifiSettingsPage.selectMenuItem(menuItem);
    }

    @When("I set the wifi name as {string}")
    public void i_set_the_wifi_name_as(String wifiName) {
        wifiSettingsPage.setWifi(wifiName);
    }

    @Then("I should see the wifi set as {string}")
    public void i_should_see_the_wifi_set_as(String expectedWifiName) {
        Assert.assertEquals(expectedWifiName, wifiSettingsPage.getWifiName());
    }

    @When("I longpress on Profile Names")
    public void longPressOnProfileNames(){
        customAdaptorPage = new CustomAdaptorPage();
        customAdaptorPage.longPressPeopleNamesMenuItem();

    }

    @Then("I should see the {string} context menu item")
    public void validateContextMenu(String expectedMenuItem) {
        System.out.println(expectedMenuItem);
        Assert.assertTrue(customAdaptorPage.doesContextMenuExist(expectedMenuItem));
    }

    @When("I scroll till {string} element is seen")
    public void scrollIntoView(String elementText){
        homePage = new HomePage();
        //homePage.scrollIntoView(elementText);
        homePage.scrollAndroidElementIntoView(elementText);
    }

    @When("I swipe {string} by {int} photo")
    public void swipeImage(String direction, int numberOfPhotos){
        viewGalleryPage = new ViewGalleryPage();
        viewGalleryPage.swipeImageIntoView(direction, numberOfPhotos);
    }

    @Then("I should see photo {int} is {string} focus")
    public void validatePhotoInFocus(int photoNumber, String condition){
        viewGalleryPage = new ViewGalleryPage();
        String expectedResult = "";
        if (condition.equalsIgnoreCase("in"))
            expectedResult = "true";
        else if(condition.equalsIgnoreCase("out of"))
            expectedResult = "false";
        Assert.assertEquals(expectedResult, viewGalleryPage.isPhotoInFocus(photoNumber));
    }


    @When("I drag and drop image {int} onto image {int}")
    public void dragAndDropImage(int sourceImage, int destinationImage){
        dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.dragAndDrop(sourceImage, destinationImage);
    }

    @Then("I see the text {string} that confirms it was dragged and dropped")
    public void validateIfDraggedAndDropped(String expectedText){
        Assert.assertEquals(expectedText, dragAndDropPage.getDroppedText());
    }

    @When("I click on {string} button")
    public void clickOnButton(String button){
        alertDialogsPage = new AlertDialogsPage();
        alertDialogsPage.clickButton(button);
    }

    @Then("I see the dialog with following attributes")
    public void validateAlertDialog(DataTable dataTable){
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        for(String field : data.keySet()){
            String actualData = alertDialogsPage.getDataFromAlertDialog(field);
            actualData = actualData.replace("\n", " ");
            System.out.println("Expected Data:" + data.get(field));
            System.out.println("Actual Data:" + actualData);
            System.out.println("----");

            Assert.assertEquals(data.get(field), actualData);
        }

    }

    @When("I click on {string} option in the alert window")
    public void clickOnOptionInAlertWindow(String option){
        listDialogPage = new ListDialogPage();
        listDialogPage.selectOption(option);
    }

    @Then("I see the dialog with message as {string}")
    public void validateAlertMessage(String expectedMessage){
        String actualMessage = listDialogPage.getMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
