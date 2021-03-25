package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Generate Card Number") private WebElement lnk_generarTarjeta;

    public MenuPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickGenerarTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_generarTarjeta)); //Wait Explicito
        lnk_generarTarjeta.click();
    }
}
