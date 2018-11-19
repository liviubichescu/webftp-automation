package Lab06Auto.features.login.valid;

import Lab06Auto.steps.serenity.AccountSteps;
import Lab06Auto.steps.serenity.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Lab06Auto.steps.serenity.LoginSteps;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public AccountSteps accountSteps;

    @Steps
    public LogoutSteps logoutSteps;

    @Issue("#WIKI-1")
    @Test
    public void valid_login() {
        loginSteps.go_to_login_page();
        loginSteps.login_steps("linux.scs.ubbcluj.ro", "vvta", "vvta2018+");
        accountSteps.should_be_in_current_directory("/home/scs/others/" + "vvta");
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