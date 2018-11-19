package Lab06Auto.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;

// pagina pentru a verifica daca suntem pe pagina cu "Directory ***** was successfully created."
public class NewDirectoryPage extends PageObject {

    @FindBy(xpath="//*[@id=\"NewDirForm\"]/a/img")
    private WebElementFacade backButton;

    public void click_back() {
        backButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("div"));
        return definitionList.findElements(By.tagName("form")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

}