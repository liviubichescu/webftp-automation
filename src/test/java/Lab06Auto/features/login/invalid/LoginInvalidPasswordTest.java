package Lab06Auto.features.login.invalid;

import Lab06Auto.steps.serenity.LoginSteps;
import Lab06Auto.steps.serenity.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src\\test/resources/invalidServerUserPasswordData.csv")
public class LoginInvalidPasswordTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    String server,user,pass,message;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public LogoutSteps logoutSteps;

    @Issue("#WIKI-1")
    @Test
    public void valid_login() {
        loginSteps.go_to_login_page();

        loginSteps.login_steps(server, user, pass);

        logoutSteps.should_see_message(message);

    }

} 