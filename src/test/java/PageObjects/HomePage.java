package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    protected static String cant;

    @FindBy(name = "quantity") private WebElement cbx_cantidad;
    @FindBy(xpath = "//*[@value='Buy Now']") private WebElement btn_comprar;

    

    public HomePage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void SeleccionarCantidad(String cantidad){
        cant=cantidad;
        new Select(cbx_cantidad).selectByValue(cantidad);
    }

    public void ClickComprar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_comprar));
        btn_comprar.click();
    }
}
