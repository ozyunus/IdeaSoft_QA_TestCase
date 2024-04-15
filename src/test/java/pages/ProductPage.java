package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    @FindBy (className = "showcase-image-vertical")
    private WebElement productDetail;

    @FindBy (id = "qty-input")
    private WebElement getProductQuantityButton;

    @FindBy (xpath = "//*[@id='qty-input']/option[5]")
    private WebElement productQuantity;

    @FindBy (className = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy (className = "shopping-information-cart")
    private WebElement addToCartMassage;

    @FindBy(className = "cart-menu")
    private WebElement goToBasket;

    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setProductDetail(){
        productDetail.click();
    }

    public void setProductQuantity(){
        getProductQuantityButton.click();

        productQuantity.click();
    }

    public void setAddToCartButton(){
        addToCartButton.click();
    }

    public void setAddToCartMassage(String string){
        Assert.assertEquals(addToCartMassage.getText(),string);
    }

    public void setGoToBasket(){
        goToBasket.click();
    }
}
