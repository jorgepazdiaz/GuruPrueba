package PageObjects;

import Definitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class TarjetaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    protected static String nro_tarjeta;
    protected static String nro_cvv;
    protected static String mes;
    protected static String anio;
    protected static String Credito_Limite;

    @FindBy(xpath = "//*[@id=\"three\"]/div/h4[1]") private WebElement lbl_nro_tarjeta;
    @FindBy(xpath = "//*[@id=\"three\"]/div/h4[2]") private WebElement lbl_CVV;
    @FindBy(xpath = "//*[@id=\"three\"]/div/h4[3]") private WebElement lbl_Fecha_Exp;
    @FindBy(xpath = "//*[@id=\"three\"]/div/h4[4]/span") private  WebElement lbl_Credito;

    public TarjetaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void UbicarWindows() {
        Set<String> identificadores = driver.getWindowHandles();
        for (String identificador : identificadores) {
            driver.switchTo().window(identificador);
        }
    }

    public void Capturar_Tarjeta() {
        wait.until(ExpectedConditions.visibilityOf(lbl_nro_tarjeta));
        nro_tarjeta=lbl_nro_tarjeta.getText().replace("Card Number:- ","");
        System.out.println(nro_tarjeta);
    }

    public void Capturar_CVV() {
        nro_cvv=lbl_CVV.getText().replace("CVV:- ","");
        System.out.println(nro_cvv);

    }

    public void Capturar_Fecha() {
        String dato[]=lbl_Fecha_Exp.getText().replace("Exp:- ","").split("/");
        mes=dato[0];
        anio=dato[1];
        System.out.println(mes);
        System.out.println(anio);
    }

    public void Capturar_Credito() {
      Credito_Limite= lbl_Credito.getText().replace("$","");
      System.out.println("Tu Credito Limite es: " +Credito_Limite);
    }

    public void CerrarVentana() {
        driver.close();
        switch (Hooks.navegador){
            case "Chrome": {
                driver.switchTo().window("");
            }
            case "Edge":{
                driver.switchTo().window("");
            }

            case "Firefox": {
                Set<String> identificadores = driver.getWindowHandles();
                for (String identificador : identificadores) {
                    driver.switchTo().window(identificador);

                }
            }
    }
    }
}
