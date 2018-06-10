package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu extends MainPage{

    @FindBy(css = ".navbar #li_myaccount")
    WebElement myAccountMenu;

    @FindBy(css = ".navbar [href$='register']")
    WebElement signUpLink;

    @FindBy(css = ".navbar a[href*='logout']")
    WebElement logoutLink;

    public TopMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TopMenu clickMyAccountMenu() {
        this.myAccountMenu.click();
        waitForJStoLoad();
        return this;
    }

    public RegisterPage clickSignUpLink() {
        this.signUpLink.click();
        waitForJStoLoad();
        return new RegisterPage(driver);
    }
}
