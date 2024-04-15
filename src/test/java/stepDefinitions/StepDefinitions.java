package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductPage;
import utilities.MyDriver;

import java.time.Duration;

public class StepDefinitions {
    private WebDriver driver;
    MainPage mainPage;
    ProductPage productPage;
    BasketPage basketPage;

    @Given("Web sayfasına git")
    public void web_sayfasina_git() {
        String BaseUrl = "https://testcase.myideasoft.com/";
        driver = MyDriver.getDriver();
        driver.get(BaseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("Arama alanına tıkla")
    public void arama_alanina_tikla() {
        mainPage = new MainPage(driver);
    }

    @And("{string} yaz")
    public void yaz(String string) {
        mainPage.setSearchText("ürün");
    }

    @When("Enter tuşuna bas")
    public void enter_tusuna_bas() {
        mainPage.clickSearchButton();
    }

    @Then("Ürün'ün listelendiğini gör. Assert True ürün")
    public void urunun_listelendigini_gor_assert_true_urun() {
        mainPage.assertSuccessSearch();
    }

    @And("Scroll page")
    public void scroll_page() {
        mainPage.setHtmlTag();
    }

    @Given("Ürün detay sayfasına git")
    public void urun_detay_sayfasina_git() {
        productPage = new ProductPage(driver);
        productPage.setProductDetail();

    }

    @And("Ürün adedini 5 yap")
    public void urun_adedini_degistir() {
        productPage.setProductQuantity();
    }

    @When("Sepete 5 adet ekle")
    public void sepete_ekle() {
        productPage.setAddToCartButton();
    }

    @Then("Sepete Eklendi metnini yakala. Assert True")
    public void metnini_yakala_assert_true() {
        productPage.setAddToCartMassage("SEPETİNİZE EKLENMİŞTİR");
    }

    @Given("Sepet sayfasına git")
    public void sepet_sayfasina_git() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productPage.setGoToBasket();

    }

    @Then("Sepete gidip 5 ürün eklendiğini doğrula.")
    public void sepete_gidip_urun_eklendigini_dogrula() {
        basketPage = new BasketPage(driver);
        basketPage.setBasketQuantity();
        MyDriver.closeDriver();
    }

}
