package scenarios;

import pages.AccountPage;
import pages.HomePage;

public class RegisterScenario implements Scenario <HomePage, AccountPage>{
    private String firstName, lastName, mobileNumber, email, password, confirmPassword;

    public RegisterScenario(String firstName, String lastName, String mobileNumber, String email,
                            String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public AccountPage run(HomePage entry) {
        return entry.openHomePage()
                .navigationBar
                .clickMyAccountMenu()
                .clickSignUpLink()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword)
                .clickSignUpButton();
    }
}
