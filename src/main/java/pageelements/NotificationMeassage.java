package pageelements;

import org.openqa.selenium.WebDriver;

public class NotificationMeassage extends BaseElement {


    public NotificationMeassage(WebDriver driver, String xpath) {
        super(driver, xpath);
    }
    public String getText(){
        return this.element.getText();
    }

    public NotificationMeassage isDisplayed(){
        this.element.isDisplayed();
        return this;
    }



}




