package Lab06Auto.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;

// pagina pentru a verifica daca am trecut de pagina de login cu succes
public class AccountPage extends PageObject {

    @FindBy(xpath="//*[@id=\"toptable\"]/tbody/tr/td[2]/input") // ne uitam in pagina cu inspect element la "nume" si il identificam
    private WebElementFacade currentDirectory;

    public String get_current_directory_name(){
        return currentDirectory.getValue();
    }


    @FindBy(xpath="//*[@id=\"StatusbarForm\"]/a[3]/img")
    private WebElementFacade logoutButton;

    public void click_logout() {
        logoutButton.click();
    }


    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}