package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "div.product-quantity input")
    private WebElement basketQuantity;

    public void setBasketQuantity(){
        String quantityString = basketQuantity.getAttribute("value");
        int quantity = Integer.parseInt(quantityString);
        Assert.assertEquals(quantity,5);

    }

}
