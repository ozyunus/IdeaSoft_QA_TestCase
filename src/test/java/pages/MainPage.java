package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class MainPage {
    private WebDriver driver;
    String searchText="ürün";
    @FindBy (className = "auto-complete")
    private WebElement searchBox;

    @FindBy (css = ".search button")
    private WebElement searchButton;

    @FindBy (className = "contentbox-header")
    private WebElement searchResult;

    @FindBy (css = "html")
    private WebElement htmlTag;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void setSearchText(String searchText){
        searchBox.sendKeys(searchText);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void assertSuccessSearch(){
        Assert.assertTrue(searchResult.isDisplayed());
        htmlTag.sendKeys(Keys.SPACE);

    }

    public void setHtmlTag(){
    }
}
