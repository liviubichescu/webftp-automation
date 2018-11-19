package Lab06Auto.steps.serenity;

import Lab06Auto.pages.NewDirectoryPage;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class NewDirectorySteps {

    NewDirectoryPage newDirectoryPage;

    @Step
    public void should_see_message(String message) {
        assertThat(newDirectoryPage.getDefinitions(), hasItem(containsString(message)));
    }

    @Step
    public void click_backButton() {
        newDirectoryPage.click_back();
    }


}