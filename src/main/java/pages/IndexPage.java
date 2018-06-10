package pages;

import org.openqa.selenium.WebDriver;

public abstract class IndexPage extends MainPage{
    public TopMenu navigationBar;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.navigationBar = new TopMenu(driver);
    }
}
