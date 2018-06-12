package pages;

import components.CalendarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends IndexPage {
    private String url;

    @FindBy(xpath = "//a //span[contains(.,'Search by Hotel or City Name')]")
    WebElement hotelSearch;

    @FindBy(css = "#select2-drop input")
    WebElement hotelSearchInput;

    @FindBy(css = "[name*='checkin']")
    WebElement checkInInput;

    @FindBy(css = "[name*='checkout']")
    WebElement checkOutInput;

    @FindBy(css = "#HOTELS button[type=submit]")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage(WebDriver driver, String url) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.url = url;
    }

    public HomePage openHomePage() {
        driver.get(url);
        this.waitForJStoLoad();
        return this;
    }

    public HomePage setHotelSearchInput(String hotelSearchInput) {
        this.hotelSearch.click();
        waitForJStoLoad();
        this.hotelSearchInput.sendKeys(hotelSearchInput);
        waitForJStoLoad();
        return this;
    }

    public HomePage setCheckInInput(String checkInInput) {
        this.checkInInput.sendKeys(checkInInput);
        waitForJStoLoad();
        return this;
    }

    public HomePage setCheckOutInput(String checkOutInput) {
        this.checkOutInput.sendKeys(checkOutInput);
        waitForJStoLoad();
        return this;
    }

    public HotelsPage clickSearchButton() {
        this.searchButton.click();
        waitForJStoLoad();
        return new HotelsPage(driver, url);
    }

    public HomePage pickDateFromCalendar(int day, CalendarComponent.Month month, int year) {
        new CalendarComponent(driver).pickDate(day, month, year);
        return this;
    }
}
