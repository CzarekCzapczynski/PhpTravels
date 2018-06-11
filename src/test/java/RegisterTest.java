import org.testng.annotations.Test;
import scenarios.RegisterScenario;

public class RegisterTest extends MainTest {

    @Test
    public void shouldRegister() {
        String firstName = "Jan";
        String lastName = "Nowak" + getRandomString(5);
        String email = firstName + lastName + "@test.com";

        homePage.run(new RegisterScenario(
                firstName,
                lastName,
                "+48123456789",
                email,
                "password",
                "password"))
                .registerAssertion
                .isUserRegister();
    }

    @Test
    public void shouldNotRegisterShortPassword() {
        String firstName = "Jan";
        String lastName = "Nowak" + getRandomString(5);
        String email = firstName + lastName + "@test.com";

        homePage.run(new RegisterScenario(
                firstName,
                lastName,
                "+48123456789",
                email,
                "pass",
                "pass"))
                .registerAssertion
                .isUserNotRegister();
    }

    @Test
    public void shouldNotRegisterNotValidEmail() {
        String firstName = "Jan";
        String lastName = "Nowak" + getRandomString(5);
        String email = firstName + lastName + "test.com";

        homePage.run(new RegisterScenario(
                firstName,
                lastName,
                "+48123456789",
                email,
                "password",
                "password"))
                .registerAssertion
                .isUserNotRegister();
    }

    @Test
    public void shouldNotRegisterDifferentPassword() {
        String firstName = "Jan";
        String lastName = "Nowak" + getRandomString(5);
        String email = firstName + lastName + "@test.com";

        homePage.run(new RegisterScenario(
                firstName,
                lastName,
                "+48123456789",
                email,
                "password",
                "confirmPassword"))
                .registerAssertion
                .isUserNotRegister();
    }

    @Test
    public void shouldNotRegisterEmptyEmail() {
        String firstName = "Jan";
        String lastName = "Nowak" + getRandomString(5);

        homePage.run(new RegisterScenario(
                firstName,
                lastName,
                "+48123456789",
                "",
                "password",
                "password"))
                .registerAssertion
                .isUserNotRegister();
    }

    @Test
    public void shouldNotRegisterUserExists() {
        String firstName = "Jan";
        String lastName = "Nowak" + getRandomString(5);
        String email = firstName + lastName + "@test.com";

        homePage.run(new RegisterScenario(
                firstName,
                lastName,
                "+48123456789",
                email,
                "password",
                "password"))
                .navigationBar
                .clickMyAccountMenu()
                .clickLogoutLink()
                .run(new RegisterScenario(
                        firstName,
                        lastName,
                        "+48123456789",
                        email,
                        "password",
                        "password"))
                .registerAssertion
                .isUserRegister();
    }
}
