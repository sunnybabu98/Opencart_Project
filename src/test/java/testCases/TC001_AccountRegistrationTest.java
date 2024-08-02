package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_Registration() {
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("Providing customer details...");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumber();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();

		logger.info("Validating expected message..");
		
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
		logger.info("Test passed");
	} 
	catch (Exception e)
	{
		logger.error("Test failed: " + e.getMessage());
		Assert.fail("Test failed: " + e.getMessage());
	} 
	finally 
	{
	logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}

}




}

	
	
	
	
	
	
