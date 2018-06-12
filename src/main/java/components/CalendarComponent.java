package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class CalendarComponent extends MainPage{

    @FindBy(css = "div[style*='block'] .datepicker-days .next")
    WebElement nextMonthSelectArrow;

    @FindBy(css = "div[style*='block']")
    WebElement calendar;

    public CalendarComponent(WebDriver driver) {
        super(driver);
    }

    public void setDate(String dayMonthYear) {

    }

    public void pickDate(int day, Month month, int year) {
        String monthYear = month.toString() + " " + String.valueOf(year);

        while(calendar.findElements(By.xpath("//th[text()='" + monthYear + "']")).size()==0){
            clickNextMonth();
        }
        pickDay(day);
    }

    public void pickDay(int day) {
        calendar.findElement(By.xpath("//td[text()='" + day + "']")).click();
    }

    public void clickNextMonth() {
        nextMonthSelectArrow.click();
    }
    
    public void pickMonthYear(String monthYear) {
        
    }

    public enum Month{
        January, February, March, April, May, June, July, August, September, October, November, December
    }
}
