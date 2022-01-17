Feature: Login to OrangeHRM

  @sanitytest
  Scenario: Login to Orange HRM site
    Given user launches Orange HRM website
    When user enters valid username "Admin" and password "admin123"
    And click on Submit button
    Then click on Maintenance
    And click on Access Records
    When user enters valid pwd "admin123"
    And click on Verify
    When user enters valid name "Goutam Ganes"
    And click on name
    Then click on search
    And click on Download
    Then click on Confirm Download
    And click on Welcome button
    Then click on Logout button
    And close browser
