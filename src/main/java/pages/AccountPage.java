package pages;

import assertions.RegisterAssertion;
import org.openqa.selenium.WebDriver;

public class AccountPage extends IndexPage{
    public RegisterAssertion registerAssertion;

    public AccountPage(WebDriver driver) {
        super(driver);
        registerAssertion = new RegisterAssertion(driver);
    }
}
