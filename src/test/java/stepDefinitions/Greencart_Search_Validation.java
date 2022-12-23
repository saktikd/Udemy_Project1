package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Greencart_Search_Validation {
public WebDriver driver;
public String landingPageproductName;
public String offerPageProductName;
	

@Given("User is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() {
    
	driver = WebDriverManager.edgedriver().avoidShutdownHook().create();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	
}

@When("use searched with product short name {string} and extracted actual name of product")
public void use_searched_with_product_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
    
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	Thread.sleep(3000);
	landingPageproductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	System.out.println(landingPageproductName+" is extracted from home page");
	
}

@Then("user searched for {string} short name in offers page to check if product exist with same name")
public void user_searched_for_the_same_short_name_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {

	driver.findElement(By.linkText("Top Deals")).click();
	Set<String> s1 = driver.getWindowHandles();
	Iterator<String> i1 = s1.iterator();
	String parentWindow = i1.next();
	String childwindow = i1.next();
	driver.switchTo().window(childwindow);
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	Thread.sleep(10000);
    offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

	
    Assert.assertEquals(landingPageproductName, offerPageProductName);

	
	
	
}
	
	
	
	
}
