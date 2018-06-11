package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.IndexPage;


public class RegisterAssertion extends IndexPage{

    @FindBy(css = "a[href*='#profile']")
    WebElement profileLink;

    @FindBy(xpath = "//p[contains(.,'The Password field must be at least 6 characters in length.')]")
    WebElement shortPasswordAlert;

    @FindBy(css = ".resultsignup .alert")
    WebElement signUpAlert;

    public RegisterAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isUserRegister() {
        Assert.assertTrue(profileLink.isDisplayed());
    }

    public void isUserNotRegister() {
        Assert.assertTrue(signUpAlert.isDisplayed());
    }
}
