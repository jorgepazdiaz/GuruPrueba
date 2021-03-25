package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class FormularioTelecomPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Alert MensajeAlerta;

    @FindBy(xpath = "//*[@id='done']//following-sibling::label") private WebElement rd_done;
    @FindBy(xpath = "//*[@id='pending']//following-sibling::label") private WebElement rd_pending;
    @FindBy(name = "fname") private WebElement txt_nombre;
    @FindBy(name = "lname") private WebElement txt_apellido;
    @FindBy(name = "emailid") private WebElement txt_email;
    @FindBy(name = "addr") private WebElement txt_direccion;
    @FindBy(name = "telephoneno") private WebElement txt_telefono;
    @FindBy(name = "submit") private WebElement btn_enviar;

    public FormularioTelecomPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickCheck(String check){
        if (check.toLowerCase().equals("done")){
        wait.until(ExpectedConditions.elementToBeClickable(rd_done));
        rd_done.click();
        } else if(check.toLowerCase().equals("pending")){
        wait.until(ExpectedConditions.elementToBeClickable(rd_pending));
        rd_pending.click();}
    }

    public void IngresarNombre(String nombre){
        wait.until(ExpectedConditions.visibilityOf(txt_nombre));
        txt_nombre.clear();
        txt_nombre.sendKeys(nombre);
    }

    public void IngresarApellido(String Ape){
        wait.until(ExpectedConditions.visibilityOf(txt_apellido));
        txt_apellido.clear();
        txt_apellido.sendKeys(Ape);
    }

    public void IngresarEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(txt_email));
        txt_email.clear();
        txt_email.sendKeys(email);
    }
    public void IngresarDireccion(String direc){
        wait.until(ExpectedConditions.visibilityOf(txt_direccion));
        txt_direccion.clear();
        txt_direccion.sendKeys(direc);
    }
    public void IngresarCelular(String celular){
        wait.until(ExpectedConditions.visibilityOf(txt_telefono));
        txt_telefono.clear();
        txt_telefono.sendKeys(celular);
    }
    public void EnviarRegistro(){
        wait.until(ExpectedConditions.visibilityOf(btn_enviar));
       btn_enviar.click();
    }
    public void ObtenerAlerta(){
        MensajeAlerta=driver.switchTo().alert();
        System.out.println("El Mensaje de Alerta es: "+MensajeAlerta.getText());
        MensajeAlerta.accept();
    }


}
