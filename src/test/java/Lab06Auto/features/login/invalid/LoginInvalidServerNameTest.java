package Lab06Auto.features.login.invalid;

import Lab06Auto.steps.serenity.AccountSteps;
import Lab06Auto.steps.serenity.LoginSteps;
import Lab06Auto.steps.serenity.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginInvalidServerNameTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public LogoutSteps logoutSteps;

    @Issue("#WIKI-1")
    @Test
    public void valid_login() {
        loginSteps.go_to_login_page();
        loginSteps.login_steps("nessie.cs.ubbcluj.ro", "vvta", "vvta2018+");
        logoutSteps.should_see_message("Unable to login to FTP server "+ "nessie.cs.ubbcluj.ro"+ " with username "+"vvta"+".");

    }

} 