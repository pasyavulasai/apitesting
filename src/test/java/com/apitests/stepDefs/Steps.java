package com.apitests.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver = new FirefoxDriver();
    private static String url = "http://localhost:3003";

    @Given("^I delete the cookies in the browser$")
    public void i_delete_the_cookies_in_the_browser() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @When("^I launch the website$")
    public void i_launch_the_website() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("^I click on link \"([^\"]*)\" with the xpath \"([^\"]*)\"$")
    public void i_click_on_link_with_the_xpath(String arg1, String arg2) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(arg2)).click();
    }

    @When("^I click the button with xpath \"([^\"]*)\"$")
    public void i_click_the_button_with_xpath(String arg1) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(arg1)).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    //Step to close the opened browser
    @Then("^I close the Browser$")
    public void i_close_the_Browser() throws Throwable {
        driver.close();
    }

    //Steps to click on buttons
    @When("^I click on the button with id \"([^\"]*)\"$")
    public void i_click_on_the_button_with_id(String identifier) throws Throwable {
        driver.findElement(By.id(identifier)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^I enter \"([^\"]*)\" with the id \"([^\"]*)\"$")
    public void i_enter_Username_to_the_id(String string, String identifier) throws Throwable {
        driver.findElement(By.id(identifier)).sendKeys(string);
    }

    @Then("^It should open the \"([^\"]*)\" popup$")
    public void it_should_open_the_popup(String arg1) throws Throwable {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            Assert.assertEquals(arg1, alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("The popup is throwing the error : "+e);
        }
    }

    @Then("^I should see content \"([^\"]*)\"$")
    public void iShouldSeeContent(String arg0) throws Throwable {
        List<WebElement> divElements = driver.findElements(By.tagName("p"));
        for (WebElement option : divElements) {
            String tagtext = option.getText();
            if(tagtext == arg0) {
                System.out.println( arg0+" text present on the page.");
            }
        }
    }

    @When("^I found a record entry in the Hotel Management platform$")
    public void iFoundARecordEntryInTheHotelManagementPlatform() throws Throwable {
        String rowtext =  driver.findElement(By.xpath("//div[1]/div[2]/div")).getText();
        System.out.println("*****************   "+rowtext);
        if (rowtext != null)
        {
            System.out.println("There are Hotel entries created!");
        }
        else
        {
            System.out.println("There are no Hotel entries created!");
        }
    }
}
