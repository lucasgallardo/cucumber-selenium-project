package io.cucumber.skeleton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepsLogin {
	WebDriver driver;
	
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
    	driver = utilities.DriverFactory.open("Chrome");
    	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");    	
    }
    
    @When("user enters correct username and correct password")
    public void user_enters_correct_username_and_correct_password(){
    	driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();    	
    }
    
	@When("user enters email (.*)")
	public void user_enters_username(String username) {
    	driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);		
	}
	
	@And("user enters password (.*)")
	public void user_enters_password(String password) {
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
	}
	
	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}
    
    @Then("user gets confirmation")
    public void user_gets_confirmation() {
    	Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("Logged in successfully"));
    	driver.quit();
    }
}
