package com.newtours.tests;


import com.baseTest.test.BaseTest;
import com.newtours.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest
{
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameters(String noOfPassengers, String expectedPrice)
    {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;

    }

    @Test
    public void registrationPageTest()
    {
        registrationPage registrationPag = new registrationPage(driver);
        registrationPag.goTo();
        registrationPag.enterUserDetails("Selenium", "docker");
        registrationPag.enterUserCredentials("selenium", "docker");
        registrationPag.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPage() {
        registrationConfirmation registrationConfirmationPage1 = new registrationConfirmation(driver);
        registrationConfirmationPage1.goToFlightDetailsPages();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
        }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        findFlightPage findFlightPage2 = new findFlightPage(driver);
        findFlightPage2.submitFindFlightPage();
        findFlightPage2.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage3 = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage3.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }




}
