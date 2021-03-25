package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidarOrdenPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "h1") private WebElement lbl_ValidarTexto;
    @FindBy(name = "customer_id") private WebElement txt_orden;
    @FindBy( xpath="//input[@name='submit']") private WebElement btn_validar;


    public ValidarOrdenPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ValidarTexto(){
        wait.until(ExpectedConditions.visibilityOf(lbl_ValidarTexto));
        lbl_ValidarTexto.isDisplayed();
    }
    public void IngresarOrden(){
        txt_orden.sendKeys(NroCustomerPage.orden);
    }

    public void ClickValidar(){
        btn_validar.click();
    }
}
