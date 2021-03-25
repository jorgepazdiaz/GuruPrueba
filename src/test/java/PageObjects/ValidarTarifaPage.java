package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidarTarifaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "h3") private WebElement lbl_ValidarTexto;
    @FindBy(xpath="//label [@for='sele']") private WebElement rdn_tarifa;
    @FindBy(name = "submit") private WebElement btn_ValidaTarifa;


    public ValidarTarifaPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ValidarTexto(){
        wait.until(ExpectedConditions.visibilityOf(lbl_ValidarTexto));

        lbl_ValidarTexto.isDisplayed();
    }

    public void clickTarifa(){
       // wait.until(ExpectedConditions.elementToBeClickable(rdn_tarifa));
       //Actions action = new Actions(driver);
       //action.moveToElement(rdn_tarifa).click().perform();

      // rdn_tarifa.click();
    }

    public void ClickValidarTarifa(){
        btn_ValidaTarifa.click();
    }
}
