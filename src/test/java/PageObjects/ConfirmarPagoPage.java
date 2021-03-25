package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmarPagoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "h2") private WebElement lbl_Payment;
    @FindBy(xpath = "//td[2]//h3//strong") private  WebElement lbl_nro_Orden;
    @FindBy(xpath = "//*[@class='button special']") private WebElement btn_Home;



    public ConfirmarPagoPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ValidarFrase(String validar){
        wait.until(ExpectedConditions.visibilityOf(lbl_Payment));
        Assert.assertEquals("Estoy Validando el Texto enviado",validar,lbl_Payment.getText());

        //lbl_Payment.isDisplayed();

    }

    public void ValidarNroOrden(){
        lbl_nro_Orden.isDisplayed();
        System.out.println("El numero de Orden es: "+lbl_nro_Orden.getText());

    }

    public void VolverHome(){
        btn_Home.click();
    }
}
