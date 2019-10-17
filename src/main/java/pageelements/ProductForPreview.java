package pageelements;

import org.openqa.selenium.WebElement;

public class ProductForPreview {
    private WebElement removeButton;
    private String name;
    private String count;
    private String cost;

    public ProductForPreview(String name, String count, String cost, WebElement removeWebElement) {
        this.name = name;
        this.count = count;
        this.cost = cost;
        this.removeButton = removeWebElement;
    }

    public void removeProduct() {
        removeButton.click();
    }

}
