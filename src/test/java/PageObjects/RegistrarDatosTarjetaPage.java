package PageObjects;

import io.cucumber.java.eo.Do;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrarDatosTarjetaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Double Monto;
    private Double creditoLimite;

    protected static String MontoCompra;
    @FindBy(name = "card_nmuber") private WebElement txt_NroTarjeta;
    @FindBy(name = "month") private WebElement cbx_mes;
    @FindBy(name = "year") private WebElement cbx_anio;
    @FindBy(name = "cvv_code") private WebElement txt_cvv;
    @FindBy(name = "submit") private WebElement btn_confirmar;
    @FindBy(xpath = "//*[@id=\"three\"]/div/form/div[1]/div/font[2]") private WebElement lbl_MontoCompra;

    public RegistrarDatosTarjetaPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void MontoComprar(){
        MontoCompra=lbl_MontoCompra.getText().replace("$","");
        Monto= Double.parseDouble(MontoCompra);
        creditoLimite= Double.parseDouble(TarjetaPage.Credito_Limite);


    }
    public void IngresarTarjeta(){
        if(Monto>creditoLimite){
            System.out.println("Error Excediste el Limite");
        }else{
            System.out.println("Estas Dentro del Limite de compra");
            wait.until(ExpectedConditions.visibilityOf(txt_NroTarjeta));
            txt_NroTarjeta.sendKeys(TarjetaPage.nro_tarjeta);
            new Select(cbx_mes).selectByVisibleText(TarjetaPage.mes);
            new Select(cbx_anio).selectByValue(TarjetaPage.anio);
            txt_cvv.sendKeys(TarjetaPage.nro_cvv);
        }

    }

    public void BtnConfirmar(){
        btn_confirmar.click();
        System.out.println("La Cantidad comprada es: "+HomePage.cant);
    }
}
