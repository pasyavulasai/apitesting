@Test01
Feature: Create Entry
  As a admin User
  I am able to create a Hotel entry and can create multiple entries and can delete the existing entry.

  Background:
    Given I delete the cookies in the browser
    And I launch the website
    When I click on link "Login" with the xpath "//div[1]/nav/div[1]/ul/li[2]/a"
    Then It should open the "Login" popup
    When I enter "admin" with the id "username"
    And I enter "password" with the id "password"
    And I click on the button with id "doLogin"

    #Create a Hotel entry
  Scenario: 1 - Create a Hotel entry after login with Admin user.
    When I enter "TestHotel" with the id "hotelName"
    And I enter "This is Test address" with the id "address"
    And I enter "TestOwner" with the id "owner"
    And I enter "01111111111" with the id "phone"
    And I enter "test@test.com" with the id "email"
    And I click on the button with id "createHotel"
    Then I should see content "TestHotel"
    And I should see content "This is Test address"
    And I should see content "TestOwner"
    And I should see content "01111111111"
    And I should see content "test@test.com"
    When I click on link "logout" with the xpath "//div[1]/nav/div[1]/ul/li[2]/a"
    And I close the Browser

    # Delete the existing Hotel Entry
  Scenario: 2 - Delete existing Hotel entry after login with Admin user.
    When I found a record entry in the Hotel Management platform
    Then I click the button with xpath "//div[1]/div[2]/div[2]/span"
    When I click on link "logout" with the xpath "//div[1]/nav/div[1]/ul/li[2]/a"
    And I close the Browser

  #Creating multiple Hotel entries
  Scenario:  - Creating Multiple entries after login with Admin user.
    When I enter "test hotel1" "Test address1" "test owner1" "11111111111" and "test1@test.com"
    And I click on link "logout" with the xpath "//div[1]/nav/div[1]/ul/li[2]/a"
    When I enter "test hotel2" "Test address2" "test owner2" "22222222222" and "test2@test.com"
    And I click on link "logout" with the xpath "//div[1]/nav/div[1]/ul/li[2]/a"
    When I enter "test hotel3" "Test address3" "test owner3" "33333333333" and "test3@test.com"
    And I click on link "logout" with the xpath "//div[1]/nav/div[1]/ul/li[2]/a"
    And I close the Browser