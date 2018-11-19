package Lab06Auto.steps.serenity;

import Lab06Auto.pages.LogoutPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class LogoutSteps {

    LogoutPage logoutPage;


    @Step
    public void should_see_message(String message) {
        assertThat(logoutPage.getDefinitions(), hasItem(containsString(message)));
    }
}