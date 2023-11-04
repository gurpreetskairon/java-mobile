Feature: This feature file covers tests related to API Demo Debug Android app

  Scenario: Wifi Settings
    Given I connect to the device and application
    When I select 'Preference' menu item on the home screen
    And I select '3. Preference dependencies' menu item on the home screen
    And I set the wifi name as 'Gurpreet'
    Then I should see the wifi set as 'Gurpreet'

  Scenario: Longpress gesture
    When I select 'Views' menu item on the home screen
    And I select 'Expandable Lists' menu item on the home screen
    And I select '1. Custom Adapter' menu item on the home screen
    And I longpress on Profile Names
    Then I should see the 'Sample menu' context menu item

  Scenario: Scroll down gesture
    When I select 'Views' menu item on the home screen
    And I scroll till 'Layouts' element is seen

  Scenario: swipe gesture
    When I select 'Views' menu item on the home screen
    And  I select 'Gallery' menu item on the home screen
    And  I select '1. Photos' menu item on the home screen
    Then I should see photo 1 is 'in' focus
    When I swipe 'left' by 1 photo
    Then I should see photo 2 is 'in' focus
    And I should see photo 1 is 'out of' focus

  Scenario: Drag and Drop gesture
    When I select 'Views' menu item on the home screen
    And  I select 'Drag and Drop' menu item on the home screen
    And I drag and drop image 1 onto image 2
    Then I see the text 'Dropped!' that confirms it was dragged and dropped

  Scenario: Drag and Drop gesture where it cannot be dropped
    When I select 'Views' menu item on the home screen
    And  I select 'Drag and Drop' menu item on the home screen
    And I drag and drop image 1 onto image 3
    Then I see the text 'No drop' that confirms it was dragged and dropped

  Scenario: validate alert fields
    When I select 'App' menu item on the home screen
    And I select 'Alert Dialogs' menu item on the home screen
    And I click on 'OK Cancel dialog with a message' button
    Then I see the dialog with following attributes
      | alertTitle | Lorem ipsum dolor sit aie consectetur adipiscing Plloaso mako nuto siwuf cakso dodtos anr koop. |
      | button2    | Cancel                                                                                          |
      | button1    | OK                                                                                              |

  Scenario: validate alert fields in traditional theme screen
    When I select 'App' menu item on the home screen
    And I select 'Alert Dialogs' menu item on the home screen
    And I click on 'OK Cancel dialog with traditional theme' button
    Then I see the dialog with following attributes
      | alertTitle | Lorem ipsum dolor sit aie consectetur adipiscing Plloaso mako nuto siwuf cakso dodtos anr koop. |
      | button2    | Cancel                                                                                          |
      | button1    | OK                                                                                              |

  Scenario Outline: select items on alert window
    When I select 'App' menu item on the home screen
    And I select 'Alert Dialogs' menu item on the home screen
    And I click on 'List dialog' button
    And I click on '<option>' option in the alert window
    Then I see the dialog with message as '<message>'

    Examples:
      | option        | message                         |
      | Command one   | You selected: 0 , Command one   |
      | Command two   | You selected: 1 , Command two   |
      | Command three | You selected: 2 , Command three |
      | Command four  | You selected: 3 , Command four  |