package Lab06Auto.features.login.valid;

import Lab06Auto.steps.serenity.AccountSteps;
import Lab06Auto.steps.serenity.LoginSteps;
import Lab06Auto.steps.serenity.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src\\test/resources/validData.csv")
public class LoginParametrizedTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public AccountSteps accountSteps;

    @Steps
    public LogoutSteps logoutSteps;

    String server, user, pass;
    @Test
    public void valid_login() {
        loginSteps.go_to_login_page();
        loginSteps.login_steps(server, user, pass);
        accountSteps.should_be_in_current_directory("/home/scs/others/" + pass);
        accountSteps.click_logout();
        logoutSteps.should_see_message("You have logged out from the FTP server");

//        pasii din test sunt:
//        1. go to login page   =>facut
//        2. enter data  =>facut
//        3. check if valid login =>facut
//        4. log out to check if it was a valid login
//        5. check if valid logout
    }

} 