package pageelements;
import org.openqa.selenium.WebDriver;

public class TextField extends BaseElement {
    public TextField(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public String getText(){
        return this.element.getText();
    }
}