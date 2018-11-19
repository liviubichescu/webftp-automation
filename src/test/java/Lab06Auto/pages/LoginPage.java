package Lab06Auto.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.cs.ubbcluj.ro/apps/ftp/")
public class LoginPage extends PageObject {

    @FindBy(name="ftpserver") // ne uitam in pagina cu inspect element la "nume" si il identificam
    private WebElementFacade ftpserver;

    public void select_server(String serverName) {
        ftpserver.selectByValue(serverName);
    }

    @FindBy(name="username") // ne uitam in pagina cu inspect element la "nume" si il identificam
    private WebElementFacade user;

    public void enters_username(String username) {
        user.type(username);
    }

    @FindBy(name="password")
    private WebElementFacade password;

    public void enters_password(String pass) {
        password.type(pass);
    }

    @FindBy(name="Login")
    private WebElementFacade loginButton;

    public void click_login() {
        loginButton.click();
    }


    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}