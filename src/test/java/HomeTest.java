import org.testng.annotations.Test;

public class HomeTest extends MainTest{

    @Test
    public void shouldFindHotel(){
        homePage.openHomePage()
        .setHotelSearchInput("London")
        .setCheckInInput("01/07/2018")
        .setCheckOutInput("01/07/2018")
        .clickSearchButton();
    }


}
