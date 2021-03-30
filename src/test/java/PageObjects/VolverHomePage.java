package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VolverHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "h2") private WebElement lbl_ValidarTexto;
    @FindBy(xpath = "//a[@class='button']") private WebElement btn_volver;


    public VolverHomePage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void validarFelicitacion(){
        wait.until(ExpectedConditions.visibilityOf(lbl_ValidarTexto));
        lbl_ValidarTexto.isDisplayed();
    }

    public void Volver(){
        btn_volver.click();
    }

}
