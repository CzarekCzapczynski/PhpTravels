import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends MainTest {

//    @BeforeMethod
//    public void before() {
//        homePage.openHomePage()
//                .navigationBar
//                .clickMyAccountMenu()
//                .clickSignUpLink();
//    }

    @Test
    public void shouldRegister() {
        String firstName = "Jan";
        String lastName = "Nowak" + getRandomString(5);
        String email = firstName + lastName + "@test.com";

        homePage.openHomePage()
                .navigationBar
                .clickMyAccountMenu()
                .clickSignUpLink()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber("+48123456789")
                .setEmail(email)
                .setPassword("password")
                .setConfirmPassword("password")
                .clickSignUpButton()
                .isUserRegister();

    }
}
