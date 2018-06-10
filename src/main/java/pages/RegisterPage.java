package pages;

import assertions.RegisterAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends IndexPage{

    @FindBy(css = "[name='firstname']")
    WebElement firstName;

    @FindBy(css = "[name='lastname']")
    WebElement lastName;

    @FindBy(css = "[name='phone']")
    WebElement mobileNumber;

    @FindBy(css = "[name='email']")
    WebElement email;

    @FindBy(css = "[name='password']")
    WebElement password;

    @FindBy(css = "[name='confirmpassword']")
    WebElement confirmPassword;

    @FindBy(css = ".form-group [type='submit']")
    WebElement signUpButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RegisterPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegisterPage setMobileNumber(String mobileNumber) {
        this.mobileNumber.sendKeys(mobileNumber);
        return this;
    }

    public RegisterPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public RegisterPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public RegisterAssertion clickSignUpButton() {
        this.signUpButton.click();
        waitForJStoLoad();
        return new RegisterAssertion(driver);
    }
}
